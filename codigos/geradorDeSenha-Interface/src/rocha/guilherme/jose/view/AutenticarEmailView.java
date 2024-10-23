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
import javax.swing.border.EmptyBorder;

import rocha.guilherme.jose.controller.AutenticarEmailController;
import rocha.guilherme.jose.model.ModelUsuario;

@SuppressWarnings("serial")
public class AutenticarEmailView extends JFrame {

	private JPanel contentPane;
	private JLabel lblStatusCodigo;
	private JButtonPersonalizado btnEnviarCodigo;
	private JTextFieldPersonalizado textFieldEmail;
	private JTextFieldPersonalizado textFieldCodigoRecebido;
	private JButtonPersonalizado btnSeCadastrar;
	private JButtonPersonalizado btnSair;
	
	private AutenticarEmailController controller;
	private static ModelUsuario usuario;
	private static CadastroUsuarioView cadastroView;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AutenticarEmailView frame = new AutenticarEmailView(usuario, cadastroView);
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
	public AutenticarEmailView(ModelUsuario usuario, CadastroUsuarioView cadastroView) {
		setUndecorated(true);
		
		AutenticarEmailView.usuario = usuario;
		AutenticarEmailView.cadastroView = cadastroView;
		controller = new AutenticarEmailController(this);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 360, 360);
		contentPane = new JPanelPersonalizado(0, 0, Color.decode("#373B44"), Color.decode("#4286f4"), false);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDigiteSeuEmail = new JLabel("Seu gmail:");
		lblDigiteSeuEmail.setBounds(20, 32, 117, 28);
		lblDigiteSeuEmail.setForeground(Color.WHITE);
		lblDigiteSeuEmail.setFont(new Font("Arial", Font.PLAIN, 24));
		contentPane.add(lblDigiteSeuEmail);
		
		textFieldEmail = new JTextFieldPersonalizado(10, 10, (Color) null);
		textFieldEmail.setText(usuario.getEmailUsuario());
		textFieldEmail.setEditable(false);
		textFieldEmail.setBounds(20, 64, 320, 40);
		textFieldEmail.setOpaque(false);
		textFieldEmail.setForeground(Color.WHITE);
		textFieldEmail.setFont(new Font("Arial", Font.PLAIN, 24));
		textFieldEmail.setColumns(10);
		textFieldEmail.setCaretColor(Color.WHITE);
		contentPane.add(textFieldEmail);
		
		JLabel lblSeuCodigo = new JLabel("Seu código:");
		lblSeuCodigo.setBounds(20, 194, 128, 28);
		lblSeuCodigo.setForeground(Color.WHITE);
		lblSeuCodigo.setFont(new Font("Arial", Font.PLAIN, 24));
		contentPane.add(lblSeuCodigo);
		
		textFieldCodigoRecebido = new JTextFieldPersonalizado(10, 10, (Color) null);
		textFieldCodigoRecebido.soNumeros();
		textFieldCodigoRecebido.setOpaque(false);
		textFieldCodigoRecebido.setForeground(Color.WHITE);
		textFieldCodigoRecebido.setFont(new Font("Arial", Font.PLAIN, 28));
		textFieldCodigoRecebido.setColumns(10);
		textFieldCodigoRecebido.setCaretColor(Color.WHITE);
		textFieldCodigoRecebido.setBounds(170, 188, 170, 40);
		contentPane.add(textFieldCodigoRecebido);
		
		lblStatusCodigo = new JLabel("código validado");
		lblStatusCodigo.setIcon(new ImageIcon(AutenticarEmailView.class.getResource("/rocha/guilherme/jose/view/icones/verificado.png")));
		lblStatusCodigo.setVisible(false);
		lblStatusCodigo.setForeground(Color.WHITE);
		lblStatusCodigo.setFont(new Font("Arial", Font.PLAIN, 16));
		lblStatusCodigo.setBounds(170, 236, 170, 20);
		contentPane.add(lblStatusCodigo);
		
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
		
		btnSeCadastrar = new JButtonPersonalizado(Color.decode("#1E3663"), Color.decode("#133E8C"), 10, 10);
		btnSeCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.cadastrarUsuario(usuario, cadastroView);
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
		btnSeCadastrar.setText("CADASTRAR");
		btnSeCadastrar.setFont(new Font("Arial", Font.PLAIN, 20));
		btnSeCadastrar.setBounds(45, 288, 160, 40);
		contentPane.add(btnSeCadastrar);
		
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
		btnSair.setBounds(229, 288, 86, 40);
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

	public JLabel getLblStatusCodigo() {
		return lblStatusCodigo;
	}

	public void setLblStatusCodigo(JLabel lblStatusCodigo) {
		this.lblStatusCodigo = lblStatusCodigo;
	}

	public JButtonPersonalizado getBtnEnviarCodigo() {
		return btnEnviarCodigo;
	}

	public void setBtnEnviarCodigo(JButtonPersonalizado btnEnviarCodigo) {
		this.btnEnviarCodigo = btnEnviarCodigo;
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
}
