package rocha.guilherme.jose.controller;

import javax.swing.JOptionPane;

import rocha.guilherme.jose.controller.helper.LoginHelper;
import rocha.guilherme.jose.model.ModelUsuario;
import rocha.guilherme.jose.model.dao.UsuarioDAO;
import rocha.guilherme.jose.view.CadastroUsuarioView;
import rocha.guilherme.jose.view.LoginView;
import rocha.guilherme.jose.view.RedefinirSenhaView;
import rocha.guilherme.jose.view.SenhasView;

public class LoginController {

	private final LoginView loginView;
	private final LoginHelper helper;
	
	public LoginController(LoginView loginView) {
		this.loginView = loginView;
		this.helper = new LoginHelper(loginView);
	}

	public void entrarNoAplicativo() {
		ModelUsuario usuario = helper.obterModelo();
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		ModelUsuario usuarioAutenticado = usuarioDAO.selectPorNomeOuEmailESenha(usuario);
		
		if(usuarioAutenticado != null) {
			irParaTelaInicial();
			loginView.dispose();
		}else {
			loginView.exibeMensagemInformativa("Usu�rio ou/e Senha inv�lidos");
		}
	}
	
	public void irParaTelaCadastro() {
		loginView.dispose();
		
		CadastroUsuarioView cadastroUsuarioView = new CadastroUsuarioView();
		cadastroUsuarioView.setLocationRelativeTo(null);
		cadastroUsuarioView.setResizable(false);
		cadastroUsuarioView.setVisible(true);
	}
	
	public void irParaTelaRedefinirSenha() {
		RedefinirSenhaView redefinirSenhaView = new RedefinirSenhaView();
		redefinirSenhaView.setLocationRelativeTo(null);
		redefinirSenhaView.setResizable(false);
		redefinirSenhaView.setVisible(true);
	}

	private void irParaTelaInicial() {
		SenhasView telaInicial = new SenhasView();
		telaInicial.setLocationRelativeTo(null);
		telaInicial.setResizable(false);
		telaInicial.setVisible(true);
	}

	public void fecharAplicacao() {
		if(loginView.exibeMensagemDecisao("Deseja fechar a aplica��o?") == 
				JOptionPane.YES_OPTION) {
			System.exit(0);
		}
		
	}

	
}