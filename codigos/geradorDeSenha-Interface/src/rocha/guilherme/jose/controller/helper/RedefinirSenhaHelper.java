package rocha.guilherme.jose.controller.helper;

import rocha.guilherme.jose.view.RedefinirSenhaView;

public class RedefinirSenhaHelper {

	private final RedefinirSenhaView redefinirSenhaView;

	public RedefinirSenhaHelper(RedefinirSenhaView redefinirSenhaView) {
		this.redefinirSenhaView = redefinirSenhaView;
	}
	
	public String obterEmail() {
		return redefinirSenhaView.getTextFieldEmail().getText().trim();
	}
	
	public String obterCodigo() {
		return redefinirSenhaView.getTextFieldCodigoRecebido().getText().trim();
	}

	public boolean validarEmail() {
		if(redefinirSenhaView.getTextFieldEmail().getText().trim().isEmpty()) return false;
		
		String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";

		if (!redefinirSenhaView.getTextFieldEmail().getText().matches(emailRegex)) {
		    return false;
		} else if (!redefinirSenhaView.getTextFieldEmail().getText().contains("gmail.com")) {
		    return false;
		}
		
		return true;
	}

	public boolean verificarCampos() {
		if(redefinirSenhaView.getTextFieldEmail().getText().trim().isEmpty() ||
				redefinirSenhaView.getTextFieldCodigoRecebido().getText().trim().isEmpty() ||
				redefinirSenhaView.getTextFieldNovaSenha().getText().trim().isEmpty()) {
			return false;
		}
		
		return true;
	}
	
	public boolean validarSenha() {
		if(redefinirSenhaView.getTextFieldNovaSenha().getText().trim().length() < 8) return false;
		return true;
	}

	public String obterSenha() {
		return redefinirSenhaView.getTextFieldNovaSenha().getText().trim();
	}
	
}
