package rocha.guilherme.jose.controller;

import javax.swing.JOptionPane;

import rocha.guilherme.jose.view.LoginView;
import rocha.guilherme.jose.view.SenhasView;

public class SenhasController {

	private SenhasView senhasView;

	public SenhasController(SenhasView senhasView) {
		this.senhasView = senhasView;
	}

	public void sair() {
		if(senhasView.exibeMensagemDecisao("Deseja retornar para a tela de Login?") == 
				JOptionPane.YES_OPTION) {
			senhasView.dispose();
			irParaLogin();
		}
	}

	private void irParaLogin() {
		LoginView login = new LoginView();
		login.setLocationRelativeTo(null);
		login.setResizable(false);
		login.setVisible(true);
	}
	
	
}
