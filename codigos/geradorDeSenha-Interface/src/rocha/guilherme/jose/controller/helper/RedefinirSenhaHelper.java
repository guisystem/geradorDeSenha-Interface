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

	public boolean verificarEmail() {
		if(redefinirSenhaView.getTextFieldEmail().getText().trim().isEmpty()) return false;
		return true;
	}
	
	public boolean validarSenha() {
		if(redefinirSenhaView.getTextFieldNovaSenha().getText().trim().isEmpty()) return false;
		if(redefinirSenhaView.getTextFieldNovaSenha().getText().trim().length() < 8) return false;
		return true;
	}

	public boolean verificarCodigo() {
		if(redefinirSenhaView.getTextFieldCodigoRecebido().getText().trim().isEmpty()) return false;
		return true;
	}

	public String obterSenha() {
		return redefinirSenhaView.getTextFieldNovaSenha().getText().trim();
	}
	
}
