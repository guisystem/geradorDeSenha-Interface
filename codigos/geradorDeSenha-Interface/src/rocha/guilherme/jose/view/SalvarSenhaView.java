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
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import rocha.guilherme.jose.model.ModelSenhasSalvas;
import rocha.guilherme.jose.model.ModelUsuario;

@SuppressWarnings("serial")
public class SalvarSenhaView extends JDialog {

	private JPanel contentPane;
	private JTextField textFieldSenhaGerada;
	private JTextField textFieldDescricao;
	private JButton btnSalvarSenha;
	private JButton btnSair;
	private static ModelUsuario usuario;
	private static ModelSenhasSalvas senha;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SalvarSenhaView frame = new SalvarSenhaView(usuario, senha);
					frame.setResizable(false);
					frame.setLocationRelativeTo(null);
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
	public SalvarSenhaView(ModelUsuario usuario, ModelSenhasSalvas senha) {
		setUndecorated(true);
		setModal(true);
		SalvarSenhaView.usuario = usuario;
		SalvarSenhaView.senha = senha;
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 361, 320);
		contentPane = new JPanelPersonalizado(0, 0, Color.decode("#373B44"), Color.decode("#4286f4"), false);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setForeground(new Color(255, 255, 255));
		lblSenha.setFont(new Font("Arial", Font.PLAIN, 24));
		lblSenha.setBounds(20, 32, 77, 28);
		contentPane.add(lblSenha);
		
		JLabel lblDescricao = new JLabel("Descrição:");
		lblDescricao.setForeground(new Color(255, 255, 255));
		lblDescricao.setFont(new Font("Arial", Font.PLAIN, 24));
		lblDescricao.setBounds(20, 132, 112, 28);
		contentPane.add(lblDescricao);
		
		textFieldSenhaGerada = new JTextField();
		textFieldSenhaGerada.setForeground(new Color(255, 255, 255));
		textFieldSenhaGerada.setCaretColor(Color.WHITE);
		textFieldSenhaGerada.setFont(new Font("Arial", Font.PLAIN, 20));
		textFieldSenhaGerada.setBounds(20, 65, 321, 40);
		textFieldSenhaGerada.setOpaque(false);
		contentPane.add(textFieldSenhaGerada);
		
		textFieldDescricao = new JTextField();
		textFieldDescricao.setForeground(new Color(255, 255, 255));
		textFieldDescricao.setCaretColor(Color.WHITE);
		textFieldDescricao.setFont(new Font("Arial", Font.PLAIN, 20));
		textFieldDescricao.setBounds(20, 164, 321, 40);
		textFieldDescricao.setOpaque(false);
		contentPane.add(textFieldDescricao);
		
		JLabel lblInfoDescricao = new JLabel("");
		lblInfoDescricao.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				exibeMensagemInformativa("Coloque na descrição o site, aplicativo ou dispositivo que\n "
						+ "a sua senha referência. Exemplo: Banco de Brasil, Netflix, Wi-Fi, etc.");
			}
		});
		lblInfoDescricao.setIcon(new ImageIcon(SalvarSenhaView.class.getResource("/rocha/guilherme/jose/view/icones/informacao.png")));
		lblInfoDescricao.setForeground(Color.WHITE);
		lblInfoDescricao.setFont(new Font("Arial", Font.PLAIN, 24));
		lblInfoDescricao.setBounds(313, 132, 28, 28);
		contentPane.add(lblInfoDescricao);
		
		btnSalvarSenha = new JButtonPersonalizado(Color.decode("#1E3663"), Color.decode("#133E8C"), 5, 5);
		btnSalvarSenha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnSalvarSenha.addMouseListener(new MouseAdapter() {
			@Override
		    public void mouseEntered(MouseEvent e) {
				efeitoMouseOver(btnSalvarSenha);
		    }

		    @Override
		    public void mouseExited(MouseEvent e) {
		    	efeitoMouseExit(btnSalvarSenha);
		    }
		});
		btnSalvarSenha.setText("SALVAR SENHA");
		btnSalvarSenha.setFont(new Font("Arial", Font.PLAIN, 20));
		btnSalvarSenha.setBounds(20, 240, 197, 48);
		contentPane.add(btnSalvarSenha);
		
		btnSair = new JButtonPersonalizado(Color.decode("#2060D2"), Color.decode("#2060D2"), 5, 5);
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
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
		btnSair.setBounds(248, 240, 93, 48);
		contentPane.add(btnSair);
		
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

	public JTextField getTextFieldSenhaGerada() {
		return textFieldSenhaGerada;
	}

	public void setTextFieldSenhaGerada(JTextField textFieldSenhaGerada) {
		this.textFieldSenhaGerada = textFieldSenhaGerada;
	}

	public JTextField getTextFieldDescricao() {
		return textFieldDescricao;
	}

	public void setTextFieldDescricao(JTextField textFieldDescricao) {
		this.textFieldDescricao = textFieldDescricao;
	}
	
}
