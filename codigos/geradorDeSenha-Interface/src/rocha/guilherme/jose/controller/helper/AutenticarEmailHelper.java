package rocha.guilherme.jose.controller.helper;

import rocha.guilherme.jose.view.AutenticarEmailView;

public class AutenticarEmailHelper {

	private final AutenticarEmailView autenticarEmailView;

	public AutenticarEmailHelper(AutenticarEmailView autenticarEmailView) {
		this.autenticarEmailView = autenticarEmailView;
	}

	public String obterEmail() {
		return autenticarEmailView.getTextFieldEmail().getText().trim();
	}

	public String obterCodigo() {
		return autenticarEmailView.getTextFieldCodigoRecebido().getText().trim();
	}

	public boolean verificarCodigo() {
		if(autenticarEmailView.getTextFieldCodigoRecebido().getText().trim().isEmpty()) return false;
		return true;
	}

}
