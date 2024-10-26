package rocha.guilherme.jose.controller.helper;

import rocha.guilherme.jose.model.ModelSenhasSalvas;
import rocha.guilherme.jose.view.SalvarSenhaView;

public class SalvarSenhaHelper {

	private SalvarSenhaView salvarSenhaView;

	public SalvarSenhaHelper(SalvarSenhaView salvarSenhaView) {
		this.salvarSenhaView = salvarSenhaView;
	}

	public void preencherSenha(ModelSenhasSalvas senha) {
		salvarSenhaView.getTextFieldSenhaGerada().setText(senha.getSenha());
		salvarSenhaView.getTextFieldDescricao().setText(senha.getDescricao());
		salvarSenhaView.getTextFieldSenhaGerada().setEditable(false);
	}

	public ModelSenhasSalvas obterModelo() {
		String senha = salvarSenhaView.getTextFieldSenhaGerada().getText();
		String descricao = salvarSenhaView.getTextFieldDescricao().getText();
		
		ModelSenhasSalvas novaSenha = new ModelSenhasSalvas(senha, descricao);
		
		return novaSenha;
	}
	
}
