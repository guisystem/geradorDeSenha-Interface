package rocha.guilherme.jose.controller.helper;

import rocha.guilherme.jose.model.ModelUsuario;
import rocha.guilherme.jose.view.LoginView;

public class LoginHelper {

	private LoginView loginView;

	public LoginHelper(LoginView loginView) {
		this.loginView = loginView;
	}

	@SuppressWarnings("deprecation")
	public ModelUsuario obterModelo() {
		String nomeUsuario = loginView.getTextFieldUsuario().getText();
		String emailUsuario = loginView.getTextFieldUsuario().getText();
		String senha = loginView.getPasswordFieldSenha().getText();
		
		ModelUsuario usuario = new ModelUsuario(nomeUsuario, senha, emailUsuario);
		
		return usuario;
	}
	
}
