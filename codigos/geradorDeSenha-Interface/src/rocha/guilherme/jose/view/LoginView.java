package rocha.guilherme.jose.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import rocha.guilherme.jose.controller.LoginController;

@SuppressWarnings("serial")
public class LoginView extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldUsuario;
	private JPasswordField passwordFieldSenha;
	private JButton btnEntrar;
	private JButton btnSeCadastrar;
	
	private LoginController controller;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginView frame = new LoginView();
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
	public LoginView() {
		setUndecorated(true);
		
		controller = new LoginController(this);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 393, 852);
		contentPane = new JPanelPersonalizado(0, 0, Color.decode("#373B44"), Color.decode("#4286f4"), true);
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.fecharAplicacao();
			}
		});
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(LoginView.class.getResource("/rocha/guilherme/jose/view/icones/fechar.png")));
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel.setBounds(348, 0, 46, 40);
		contentPane.add(lblNewLabel);
		
		JLabel lblIconeUsuario = new JLabel("");
		lblIconeUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconeUsuario.setIcon(new ImageIcon(LoginView.class.getResource("/rocha/guilherme/jose/view/icones/icone-usuario.png")));
		lblIconeUsuario.setBounds(116, 40, 160, 160);
		contentPane.add(lblIconeUsuario);
		
		JPanel painelCadastro = new JPanelPersonalizado(30, 30, Color.decode("#2193b0"), Color.decode("#6dd5ed"), false);
		painelCadastro.setBackground(new Color(255, 255, 255));
		painelCadastro.setBounds(20, 216, 353, 518);
		contentPane.add(painelCadastro);
		painelCadastro.setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usuário/Gmail");
		lblUsuario.setForeground(new Color(255, 255, 255));
		lblUsuario.setFont(new Font("Arial", Font.PLAIN, 28));
		lblUsuario.setBounds(28, 40, 181, 32);
		painelCadastro.add(lblUsuario);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setForeground(new Color(255, 255, 255));
		lblSenha.setFont(new Font("Arial", Font.PLAIN, 28));
		lblSenha.setBounds(28, 150, 81, 32);
		painelCadastro.add(lblSenha);

		JLabel lblEsqueceuSenha = new JLabel("Esqueceu sua senha?");
		lblEsqueceuSenha.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.irParaTelaRedefinirSenha();
			}
		});
		lblEsqueceuSenha.setForeground(new Color(255, 255, 255));
		lblEsqueceuSenha.setFont(new Font("Arial", Font.PLAIN, 16));
		lblEsqueceuSenha.setBounds(171, 242, 154, 20);
		painelCadastro.add(lblEsqueceuSenha);
		
		textFieldUsuario = new JTextFieldPersonalizado(50, 50, null);
		textFieldUsuario.setForeground(new Color(255, 255, 255));
		textFieldUsuario.setCaretColor(Color.WHITE);
		textFieldUsuario.setOpaque(false);
		textFieldUsuario.setFont(new Font("Arial", Font.PLAIN, 28));
		textFieldUsuario.setBounds(28, 76, 297, 52);
		painelCadastro.add(textFieldUsuario);
		textFieldUsuario.setColumns(10);
		
		JLabel lblOu = new JLabel("OU");
		lblOu.setForeground(new Color(255, 255, 255));
		lblOu.setFont(new Font("Arial", Font.PLAIN, 28));
		lblOu.setBounds(155, 374, 42, 32);
		painelCadastro.add(lblOu);
		
		btnEntrar = new JButtonPersonalizado(Color.decode("#3F66D0"), Color.decode("#3F66D0"), 50, 50);
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.entrarNoAplicativo();
			}
		});
		btnEntrar.addMouseListener(new MouseAdapter() {
			@Override
		    public void mouseEntered(MouseEvent e) {
				efeitoMouseOver(btnEntrar);
		    }

		    @Override
		    public void mouseExited(MouseEvent e) {
		    	efeitoMouseExit(btnEntrar);
		    }
		});
		btnEntrar.setText("ENTRAR");
		btnEntrar.setFont(new Font("Arial", Font.PLAIN, 20));
		btnEntrar.setBounds(28, 302, 297, 48);
		painelCadastro.add(btnEntrar);
		
		btnSeCadastrar = new JButtonPersonalizado(Color.decode("#2193b0"), Color.decode("#4286f4"), 50, 50);
		btnSeCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.irParaTelaCadastro();
			}
		});
		btnSeCadastrar.addMouseListener(new MouseAdapter() {
			@Override
		    public void mouseEntered(MouseEvent e) {
				efeitoMouseOver(btnSeCadastrar);
		    }

		    @Override
		    public void mouseExited(MouseEvent e) {
		    	efeitoMouseExit(btnSeCadastrar);
		    }
		});
		btnSeCadastrar.setText("SE CADASTRAR");
		btnSeCadastrar.setFont(new Font("Arial", Font.PLAIN, 20));
		btnSeCadastrar.setBounds(28, 430, 297, 48);
		painelCadastro.add(btnSeCadastrar);
		
		passwordFieldSenha = new JPasswordFieldPersonalizado(50, 50, null);
		passwordFieldSenha.setForeground(new Color(255, 255, 255));
		passwordFieldSenha.setCaretColor(Color.WHITE);
		passwordFieldSenha.setOpaque(false);
		passwordFieldSenha.setFont(new Font("Arial", Font.PLAIN, 28));
		passwordFieldSenha.setBounds(28, 186, 297, 52);
		painelCadastro.add(passwordFieldSenha);
		
	}
	
	private void efeitoMouseOver(JButton botao) {
		((JButtonPersonalizado) botao).setAlpha(0.4F);
	}

	private void efeitoMouseExit(JButton botao) {
		((JButtonPersonalizado) botao).setAlpha(0.3F);
	}

	public void exibeMensagemInformativa(String mensagem) {
		JOptionPanePersonalizado.exibeMensagemInformativa(mensagem);
	}

	public int exibeMensagemDecisao(String mensagem) {
		return JOptionPanePersonalizado.exibeMensagemDecisao(mensagem);
	}

	public JTextField getTextFieldUsuario() {
		return textFieldUsuario;
	}

	public void setTextFieldUsuario(JTextField textFieldUsuario) {
		this.textFieldUsuario = textFieldUsuario;
	}

	public JPasswordField getPasswordFieldSenha() {
		return passwordFieldSenha;
	}

	public void setPasswordFieldSenha(JPasswordField passwordFieldSenha) {
		this.passwordFieldSenha = passwordFieldSenha;
	}

}
