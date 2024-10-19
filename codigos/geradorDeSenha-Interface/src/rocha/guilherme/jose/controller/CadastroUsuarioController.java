package rocha.guilherme.jose.controller;

import rocha.guilherme.jose.controller.helper.CadastroUsuarioHelper;
import rocha.guilherme.jose.view.AutenticarEmailView;
import rocha.guilherme.jose.view.CadastroUsuarioView;
import rocha.guilherme.jose.view.LoginView;

public class CadastroUsuarioController {

	private final CadastroUsuarioView cadastroUsuarioView;
	private final CadastroUsuarioHelper helper;

	public CadastroUsuarioController(CadastroUsuarioView cadastroUsuarioView) {
		this.cadastroUsuarioView = cadastroUsuarioView;
		this.helper = new CadastroUsuarioHelper(cadastroUsuarioView);
	}

	public void voltarParaLogin() {
		cadastroUsuarioView.dispose();
		
		LoginView login = new LoginView();
		login.setResizable(false);
		login.setLocationRelativeTo(null);
		login.setVisible(true);
	}

	public void continuar() {
		if(helper.verificarUsuario()) {
			if(helper.validarUsuario()) {
				if(helper.verificarEmail()) {
					if(helper.validarEmail()) {
						if(helper.verificarSenha()) {
							irParaAutenticarEmail();
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

	private void irParaAutenticarEmail() {
		AutenticarEmailView autenticarEmailView = new AutenticarEmailView();
		autenticarEmailView.setLocationRelativeTo(null);
		autenticarEmailView.setResizable(false);
		autenticarEmailView.setVisible(true);
		
	}
	
}
