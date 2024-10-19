package rocha.guilherme.jose.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import rocha.guilherme.jose.controller.CadastroUsuarioController;

@SuppressWarnings("serial")
public class CadastroUsuarioView extends JFrame {

	private JPanel contentPane;
	private JTextFieldPersonalizado textFieldUsuario;
	private JPasswordFieldPersonalizado passwordFieldSenha;
	private JTextFieldPersonalizado textFieldEmail;
	private JButtonPersonalizado btnContinuar;
	private JButtonPersonalizado btnVoltarLogin;
	
	private CadastroUsuarioController controller;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroUsuarioView frame = new CadastroUsuarioView();
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
	public CadastroUsuarioView() {
		setUndecorated(true);
		
		controller = new CadastroUsuarioController(this);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 393, 852);
		contentPane = new JPanelPersonalizado(0, 0, Color.decode("#373B44"), Color.decode("#4286f4"), true);
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIconeUsuario = new JLabel("");
		lblIconeUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconeUsuario.setIcon(new ImageIcon(LoginView.class.getResource("/rocha/guilherme/jose/view/icones/icone-usuario.png")));
		lblIconeUsuario.setBounds(116, 40, 160, 160);
		contentPane.add(lblIconeUsuario);
		
		JPanel painelCadastro = new JPanelPersonalizado(30, 30, Color.decode("#2193b0"), Color.decode("#6dd5ed"), false);
		painelCadastro.setBackground(new Color(255, 255, 255));
		painelCadastro.setBounds(20, 216, 353, 596);
		contentPane.add(painelCadastro);
		painelCadastro.setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usuário");
		lblUsuario.setForeground(new Color(255, 255, 255));
		lblUsuario.setFont(new Font("Arial", Font.PLAIN, 28));
		lblUsuario.setBounds(28, 40, 95, 32);
		painelCadastro.add(lblUsuario);
		
		JLabel lblEmail = new JLabel("Gmail");
		lblEmail.setForeground(new Color(255, 255, 255));
		lblEmail.setFont(new Font("Arial", Font.PLAIN, 28));
		lblEmail.setBounds(28, 150, 81, 32);
		painelCadastro.add(lblEmail);
		
		JLabel lblInformacao = new JLabel("Por que isso?");
		lblInformacao.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				exibeMensagemInformativa("Por que informar meu email para realizar o cadastro? \n"
						+ "O fornecimento do email é importante para: \n\n"
						+ "1. Validar a sua conta e provar que você é quem diz ser.\n"
						+ "2. Provar que você é detentor desse email.\n"
						+ "3. Ajuda-ló a recuperar a conta quando esquecer a senha.\n"
						+ "4. Tornar o aplicativo mais seguro.");
			}
		});
		lblInformacao.setForeground(new Color(255, 255, 255));
		lblInformacao.setFont(new Font("Arial", Font.PLAIN, 12));
		lblInformacao.setBounds(249, 158, 81, 16);
		painelCadastro.add(lblInformacao);

		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setForeground(new Color(255, 255, 255));
		lblSenha.setFont(new Font("Arial", Font.PLAIN, 28));
		lblSenha.setBounds(28, 260, 81, 32);
		painelCadastro.add(lblSenha);
		
		textFieldUsuario = new JTextFieldPersonalizado(50, 50, null);
		textFieldUsuario.setForeground(new Color(255, 255, 255));
		textFieldUsuario.setCaretColor(Color.WHITE);
		textFieldUsuario.setOpaque(false);
		textFieldUsuario.setFont(new Font("Arial", Font.PLAIN, 28));
		textFieldUsuario.setBounds(28, 76, 297, 52);
		painelCadastro.add(textFieldUsuario);
		textFieldUsuario.setColumns(10);
		
		textFieldEmail = new JTextFieldPersonalizado(50, 50, null);
		textFieldEmail.setForeground(new Color(255, 255, 255));
		textFieldEmail.setCaretColor(Color.WHITE);
		textFieldEmail.setOpaque(false);
		textFieldEmail.setFont(new Font("Arial", Font.PLAIN, 28));
		textFieldEmail.setBounds(28, 186, 297, 52);
		painelCadastro.add(textFieldEmail);
		textFieldEmail.setColumns(10);
		
		passwordFieldSenha = new JPasswordFieldPersonalizado(50, 50, null);
		passwordFieldSenha.setForeground(new Color(255, 255, 255));
		passwordFieldSenha.setCaretColor(Color.WHITE);
		passwordFieldSenha.setOpaque(false);
		passwordFieldSenha.setFont(new Font("Arial", Font.PLAIN, 28));
		passwordFieldSenha.setBounds(28, 296, 297, 52);
		painelCadastro.add(passwordFieldSenha);
		
		JLabel lblOu = new JLabel("OU");
		lblOu.setForeground(new Color(255, 255, 255));
		lblOu.setFont(new Font("Arial", Font.PLAIN, 28));
		lblOu.setBounds(155, 456, 42, 32);
		painelCadastro.add(lblOu);
		
		btnContinuar = new JButtonPersonalizado(Color.decode("#3F66D0"), Color.decode("#3F66D0"), 50, 50);
		btnContinuar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.continuar();
			}
		});
		btnContinuar.addMouseListener(new MouseAdapter() {
			@Override
		    public void mouseEntered(MouseEvent e) {
				efeitoMouseOver(btnContinuar);
		    }

		    @Override
		    public void mouseExited(MouseEvent e) {
		    	efeitoMouseExit(btnContinuar);
		    }
		});
		btnContinuar.setText("CONTINUAR");
		btnContinuar.setFont(new Font("Arial", Font.PLAIN, 20));
		btnContinuar.setBounds(28, 388, 297, 48);
		painelCadastro.add(btnContinuar);
		
		btnVoltarLogin = new JButtonPersonalizado(Color.decode("#2193b0"), Color.decode("#4286f4"), 50, 50);
		btnVoltarLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.voltarParaLogin();
			}
		});
		btnVoltarLogin.addMouseListener(new MouseAdapter() {
			@Override
		    public void mouseEntered(MouseEvent e) {
				efeitoMouseOver(btnVoltarLogin);
		    }

		    @Override
		    public void mouseExited(MouseEvent e) {
		    	efeitoMouseExit(btnVoltarLogin);
		    }
		});
		btnVoltarLogin.setText("VOLTAR PARA LOGIN");
		btnVoltarLogin.setFont(new Font("Arial", Font.PLAIN, 20));
		btnVoltarLogin.setBounds(28, 508, 297, 48);
		painelCadastro.add(btnVoltarLogin);
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

	public JTextFieldPersonalizado getTextFieldUsuario() {
		return textFieldUsuario;
	}

	public void setTextFieldUsuario(JTextFieldPersonalizado textFieldUsuario) {
		this.textFieldUsuario = textFieldUsuario;
	}

	public JPasswordFieldPersonalizado getPasswordFieldSenha() {
		return passwordFieldSenha;
	}

	public void setPasswordFieldSenha(JPasswordFieldPersonalizado passwordFieldSenha) {
		this.passwordFieldSenha = passwordFieldSenha;
	}

	public JTextFieldPersonalizado getTextFieldEmail() {
		return textFieldEmail;
	}

	public void setTextFieldEmail(JTextFieldPersonalizado textFieldEmail) {
		this.textFieldEmail = textFieldEmail;
	}
	
}
