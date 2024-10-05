package rocha.guilherme.jose.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class JOptionPanePersonalizado {

	public static void exibeMensagemInformativa(String mensagem) {
		estilizarMensagem();
		JOptionPane.showMessageDialog(null, mensagem, "Informação" ,JOptionPane.INFORMATION_MESSAGE);
	}
	
	public static int exibeMensagemDecisao(String mensagem) {
		estilizarMensagem();
		return JOptionPane.showConfirmDialog(null, mensagem, "O que deseja fazer?", JOptionPane.YES_NO_OPTION ,JOptionPane.QUESTION_MESSAGE);
	}
	
	private static void estilizarMensagem() {
		UIManager.put("OptionPane.yesButtonText", "Sim");
		UIManager.put("OptionPane.noButtonText", "Não");
		UIManager.put("OptionPane.cancelButtonText", "Cancelar");
		UIManager.put("OptionPane.okButtonText", "OK");
		
		UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 12));
		UIManager.put("Panel.background", Color.decode("#1E3663"));
		UIManager.put("OptionPane.background", Color.decode("#1E3663"));
		UIManager.put("OptionPane.messageForeground", Color.WHITE);
		UIManager.put("Button.background", Color.decode("#243B55"));
		UIManager.put("Button.foreground", Color.WHITE);
	}
}
