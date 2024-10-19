package rocha.guilherme.jose.controller.helper;

import rocha.guilherme.jose.model.ModelUsuario;
import rocha.guilherme.jose.model.dao.BancoDeDados;
import rocha.guilherme.jose.view.CadastroUsuarioView;

public class CadastroUsuarioHelper {

	private final CadastroUsuarioView cadastroUsuarioView;

	public CadastroUsuarioHelper(CadastroUsuarioView cadastroUsuarioView) {
		this.cadastroUsuarioView = cadastroUsuarioView;
	}

	public boolean verificarUsuario() {
		if(cadastroUsuarioView.getTextFieldUsuario().getText().trim().isEmpty()) return false;
		return true;
	}
	
	public boolean validarUsuario() {
		String nomeUsuario = cadastroUsuarioView.getTextFieldUsuario().getText().trim();
		
		for(ModelUsuario usuario: BancoDeDados.usuarios) {
			if(nomeUsuario.equals(usuario.getNomeUsuario())) {
				return false;
			}
		}
		
		return true;
	}

	public boolean verificarEmail() {
		if(cadastroUsuarioView.getTextFieldEmail().getText().trim().isEmpty()) return false;
		
		String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";

		if (!cadastroUsuarioView.getTextFieldEmail().getText().matches(emailRegex)) {
		    return false;
		} else if (!cadastroUsuarioView.getTextFieldEmail().getText().contains("gmail.com")) {
		    return false;
		}
		
		return true;
	}

	public boolean validarEmail() {
		String emailUsuario = cadastroUsuarioView.getTextFieldEmail().getText().trim();
		
		for(ModelUsuario usuario: BancoDeDados.usuarios) {
			if(emailUsuario.equals(usuario.getEmailUsuario())) {
				return false;
			}
		}
		
		return true;
	}

	@SuppressWarnings("deprecation")
	public boolean verificarSenha() {
		if(cadastroUsuarioView.getPasswordFieldSenha().getText().trim().length() < 8) return false;
		if(cadastroUsuarioView.getPasswordFieldSenha().getText().trim().isEmpty()) return false;
		return true;
	}

}
