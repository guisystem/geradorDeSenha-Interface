package rocha.guilherme.jose.servico;

import java.awt.Color;
import java.awt.Font;
import java.security.SecureRandom;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class Email {

	public static String gerarOTP() {
        SecureRandom random = new SecureRandom();
        int otp = 100000 + random.nextInt(900000);
        return String.valueOf(otp);
    }

    public static void enviarEmail(String destinatario, String otpCode) {
        String host = "smtp.gmail.com";
        final String usuario = "seu-gmail@gmail.com";
        final String senha = "sua-senha-de-app";

        Properties prop = new Properties();
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");
        prop.put("mail.smtp.host", host);
        prop.put("mail.smtp.port", "587");

        Session sessao = Session.getInstance(prop, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(usuario, senha);
            }
        });

        try {
            Message mensagem = new MimeMessage(sessao);
            mensagem.setFrom(new InternetAddress(usuario));
            mensagem.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinatario));
            mensagem.setSubject("Seu Código de Verificação OTP");
            mensagem.setText("Seu código de verificação é: " + otpCode);

            Transport.send(mensagem);

            mostrarMensagem();

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

	private static void mostrarMensagem() {
		estilizarMensagem();
		JOptionPane.showMessageDialog(null, "E-mail enviado com sucesso!", "Informação" ,JOptionPane.INFORMATION_MESSAGE);
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
