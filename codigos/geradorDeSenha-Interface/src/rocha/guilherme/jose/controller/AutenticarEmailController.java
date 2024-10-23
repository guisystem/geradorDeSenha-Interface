package rocha.guilherme.jose.controller;

import rocha.guilherme.jose.controller.helper.AutenticarEmailHelper;
import rocha.guilherme.jose.model.ModelUsuario;
import rocha.guilherme.jose.model.dao.UsuarioDAO;
import rocha.guilherme.jose.servico.Email;
import rocha.guilherme.jose.view.AutenticarEmailView;
import rocha.guilherme.jose.view.CadastroUsuarioView;
import rocha.guilherme.jose.view.SenhasView;

public class AutenticarEmailController {

	private final AutenticarEmailView autenticarEmailView;
	private final AutenticarEmailHelper helper;
	private String codigoGerado;
	
	public AutenticarEmailController(AutenticarEmailView autenticarEmailView) {
		this.autenticarEmailView = autenticarEmailView;
		this.helper = new AutenticarEmailHelper(autenticarEmailView);
	}

	public void enviarCodigo() {
		String email = helper.obterEmail();
        codigoGerado = Email.gerarOTP();

        Email.enviarEmail(email, codigoGerado);
	}

	public Boolean validarCodigo() {
		String codigoInserido = helper.obterCodigo();
        return codigoInserido.equals(codigoGerado);
	}

	public void cadastrarUsuario(ModelUsuario usuario, CadastroUsuarioView cadastroView) {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		
		if(helper.verificarCodigo()) {
			if(validarCodigo()) {
				usuarioDAO.insert(usuario);
				irParaTelaInicial();
				cadastroView.dispose();
				autenticarEmailView.dispose();
			}else {
				autenticarEmailView.exibeMensagemInformativa("O código digitado está incorreto!");
			}
		}else {
			autenticarEmailView.exibeMensagemInformativa("Digite o código recebido!");
		}
	
	}

	private void irParaTelaInicial() {
		SenhasView telaInicial = new SenhasView();
		telaInicial.setLocationRelativeTo(null);
		telaInicial.setResizable(false);
		telaInicial.setVisible(true);
	}

	public void sair() {
		autenticarEmailView.dispose();
	}
	
}
