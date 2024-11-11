package rocha.guilherme.jose.controller;

import javax.persistence.EntityManager;

import rocha.guilherme.jose.controller.helper.CadastroUsuarioHelper;
import rocha.guilherme.jose.model.ModelUsuario;
import rocha.guilherme.jose.servico.JPAConnection;
import rocha.guilherme.jose.view.AutenticarEmailView;
import rocha.guilherme.jose.view.CadastroUsuarioView;
import rocha.guilherme.jose.view.LoginView;

public class CadastroUsuarioController {

	private final CadastroUsuarioView cadastroUsuarioView;
	private final CadastroUsuarioHelper helper;
	private final EntityManager em;

	public CadastroUsuarioController(CadastroUsuarioView cadastroUsuarioView) {
		this.cadastroUsuarioView = cadastroUsuarioView;
		this.helper = new CadastroUsuarioHelper(cadastroUsuarioView);
		this.em = new JPAConnection().getEntityManager();
	}

	public void voltarParaLogin() {
		cadastroUsuarioView.dispose();
		
		LoginView login = new LoginView();
		login.setResizable(false);
		login.setLocationRelativeTo(null);
		login.setVisible(true);
	}

	public void continuar() {
		ModelUsuario novoUsuario = helper.obterModelo();
		
		if(helper.verificarCampos()) {
			if(helper.validarNomeUsuario(em, novoUsuario)) {
				if(helper.validarEmail()) {
					if(helper.verificarEmailDisponivel(em, novoUsuario)) {
						if(helper.validarSenha()) {
							irParaAutenticarEmail(novoUsuario);
						}else {
							cadastroUsuarioView.exibeMensagemInformativa("Sua senha não pode ter menos que 8 caracteres!");
						}
					}else {
						cadastroUsuarioView.exibeMensagemInformativa("Esse email já está cadastrado em uma conta!");
					}
				}else {
					cadastroUsuarioView.exibeMensagemInformativa("Adicione um email válido!");
				}
			}else {
				cadastroUsuarioView.exibeMensagemInformativa("Esse nome de usuário já existe!");
			}
		}else {
			cadastroUsuarioView.exibeMensagemInformativa("Insira um nome de usuário!");
		}
	}

	private void irParaAutenticarEmail(ModelUsuario novoUsuario) {
		AutenticarEmailView autenticarEmailView = new AutenticarEmailView(novoUsuario, cadastroUsuarioView);
		autenticarEmailView.setLocationRelativeTo(null);
		autenticarEmailView.setResizable(false);
		autenticarEmailView.setVisible(true);
		
	}
	
}
