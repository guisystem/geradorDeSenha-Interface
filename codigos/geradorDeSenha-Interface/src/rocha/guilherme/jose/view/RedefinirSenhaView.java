package rocha.guilherme.jose.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import rocha.guilherme.jose.controller.RedefinirSenhaController;

@SuppressWarnings("serial")
public class RedefinirSenhaView extends JFrame {

	private JPanel contentPane;
	private JTextFieldPersonalizado textFieldEmail;
	private JTextFieldPersonalizado textFieldCodigoRecebido;
	private JTextFieldPersonalizado textFieldNovaSenha;
	private JButtonPersonalizado btnEnviarCodigo;
	private JButtonPersonalizado btnRedefinir;
	private JButtonPersonalizado btnSair;
	
	private RedefinirSenhaController controller;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RedefinirSenhaView frame = new RedefinirSenhaView();
					frame.setLocationRelativeTo(null);
					frame.setResizable(false);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public RedefinirSenhaView() {
		setUndecorated(true);
		
		controller = new RedefinirSenhaController(this);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 360, 388);
		contentPane = new JPanelPersonalizado(0, 0, Color.decode("#373B44"), Color.decode("#4286f4"), false);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDigiteSeuEmail = new JLabel("Digite seu gmail:");
		lblDigiteSeuEmail.setBounds(20, 32, 185, 28);
		lblDigiteSeuEmail.setForeground(Color.WHITE);
		lblDigiteSeuEmail.setFont(new Font("Arial", Font.PLAIN, 24));
		contentPane.add(lblDigiteSeuEmail);
		
		JLabel lblSeuCodigo = new JLabel("Seu código:");
		lblSeuCodigo.setBounds(20, 190, 128, 28);
		lblSeuCodigo.setForeground(Color.WHITE);
		lblSeuCodigo.setFont(new Font("Arial", Font.PLAIN, 24));
		contentPane.add(lblSeuCodigo);
		
		JLabel lblNovaSenha = new JLabel("Nova Senha:");
		lblNovaSenha.setBounds(20, 246, 141, 28);
		lblNovaSenha.setForeground(Color.WHITE);
		lblNovaSenha.setFont(new Font("Arial", Font.PLAIN, 24));
		contentPane.add(lblNovaSenha);
		
		textFieldEmail = new JTextFieldPersonalizado(10, 10, (Color) null);
		textFieldEmail.setBounds(20, 64, 320, 40);
		textFieldEmail.setOpaque(false);
		textFieldEmail.setForeground(Color.WHITE);
		textFieldEmail.setFont(new Font("Arial", Font.PLAIN, 24));
		textFieldEmail.setColumns(10);
		textFieldEmail.setCaretColor(Color.WHITE);
		contentPane.add(textFieldEmail);
		
		textFieldCodigoRecebido = new JTextFieldPersonalizado(10, 10, (Color) null);
		textFieldCodigoRecebido.soNumeros();
		textFieldCodigoRecebido.setOpaque(false);
		textFieldCodigoRecebido.setForeground(Color.WHITE);
		textFieldCodigoRecebido.setFont(new Font("Arial", Font.PLAIN, 28));
		textFieldCodigoRecebido.setColumns(10);
		textFieldCodigoRecebido.setCaretColor(Color.WHITE);
		textFieldCodigoRecebido.setBounds(170, 184, 170, 40);
		contentPane.add(textFieldCodigoRecebido);

		textFieldNovaSenha = new JTextFieldPersonalizado(10, 10, (Color) null);
		textFieldNovaSenha.setOpaque(false);
		textFieldNovaSenha.setForeground(Color.WHITE);
		textFieldNovaSenha.setFont(new Font("Arial", Font.PLAIN, 28));
		textFieldNovaSenha.setColumns(10);
		textFieldNovaSenha.setCaretColor(Color.WHITE);
		textFieldNovaSenha.setBounds(170, 240, 170, 40);
		contentPane.add(textFieldNovaSenha);
		
		btnEnviarCodigo = new JButtonPersonalizado(Color.decode("#1E3663"), Color.decode("#133E8C"), 10, 10);
		btnEnviarCodigo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.enviarCodigo();
			}
		});
		btnEnviarCodigo.addMouseListener(new MouseAdapter() {
			@Override
		    public void mouseEntered(MouseEvent e) {
				efeitoMouseOver(btnEnviarCodigo);
		    }

		    @Override
		    public void mouseExited(MouseEvent e) {
		    	efeitoMouseExit(btnEnviarCodigo);
		    }
		});
		btnEnviarCodigo.setText("Enviar Código");
		btnEnviarCodigo.setFont(new Font("Arial", Font.PLAIN, 20));
		btnEnviarCodigo.setBounds(20, 110, 180, 40);
		contentPane.add(btnEnviarCodigo);
		
		btnRedefinir = new JButtonPersonalizado(Color.decode("#1E3663"), Color.decode("#133E8C"), 10, 10);
		btnRedefinir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.redefinirSenha();
			}
		});
		btnRedefinir.addMouseListener(new MouseAdapter() {
			@Override
		    public void mouseEntered(MouseEvent e) {
				efeitoMouseOver(btnRedefinir);
		    }

		    @Override
		    public void mouseExited(MouseEvent e) {
		    	efeitoMouseExit(btnRedefinir);
		    }
		});
		btnRedefinir.setText("REDEFINIR");
		btnRedefinir.setFont(new Font("Arial", Font.PLAIN, 20));
		btnRedefinir.setBounds(50, 316, 150, 40);
		contentPane.add(btnRedefinir);
		
		btnSair = new JButtonPersonalizado(new Color(63, 102, 208), new Color(63, 102, 208), 10, 10);
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.sair();
			}
		});
		btnSair.addMouseListener(new MouseAdapter() {
			@Override
		    public void mouseEntered(MouseEvent e) {
				efeitoMouseOver(btnSair);
		    }

		    @Override
		    public void mouseExited(MouseEvent e) {
		    	efeitoMouseExit(btnSair);
		    }
		});
		btnSair.setText("SAIR");
		btnSair.setFont(new Font("Arial", Font.PLAIN, 20));
		btnSair.setBounds(224, 316, 86, 40);
		contentPane.add(btnSair);
	}
	
	private void efeitoMouseOver(JButtonPersonalizado botao) {
		((JButtonPersonalizado) botao).setAlpha(0.4F);
	}

	private void efeitoMouseExit(JButtonPersonalizado botao) {
		((JButtonPersonalizado) botao).setAlpha(0.3F);
	}
	
	public void exibeMensagemInformativa(String mensagem) {
		JOptionPanePersonalizado.exibeMensagemInformativa(mensagem);
	}

	public JTextFieldPersonalizado getTextFieldEmail() {
		return textFieldEmail;
	}

	public void setTextFieldEmail(JTextFieldPersonalizado textFieldEmail) {
		this.textFieldEmail = textFieldEmail;
	}

	public JTextFieldPersonalizado getTextFieldCodigoRecebido() {
		return textFieldCodigoRecebido;
	}

	public void setTextFieldCodigoRecebido(JTextFieldPersonalizado textFieldCodigoRecebido) {
		this.textFieldCodigoRecebido = textFieldCodigoRecebido;
	}

	public JTextFieldPersonalizado getTextFieldNovaSenha() {
		return textFieldNovaSenha;
	}

	public void setTextFieldNovaSenha(JTextFieldPersonalizado textFieldNovaSenha) {
		this.textFieldNovaSenha = textFieldNovaSenha;
	}
	
}
