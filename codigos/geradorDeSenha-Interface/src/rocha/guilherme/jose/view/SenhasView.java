package rocha.guilherme.jose.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class SenhasView extends JFrame {

	private JPanel contentPane;
	private JButton btnMinhasSenhas;
	private JButton btnNovaSenha;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SenhasView frame = new SenhasView();
					frame.setLocationRelativeTo(null);
					frame.setResizable(false);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	@Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(Color.WHITE);
        g2d.drawLine(0, 84, 393, 84);

    }

	/**
	 * Create the frame.
	 */
	public SenhasView() {
		setUndecorated(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 393, 852);
		contentPane = new JPanelPersonalizado(0, 0, Color.decode("#373B44"), Color.decode("#4286f4"), false);
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPainelSenhas = new JLabel("Painel de Senhas");
		lblPainelSenhas.setForeground(new Color(255, 255, 255));
		lblPainelSenhas.setFont(new Font("Arial", Font.PLAIN, 32));
		lblPainelSenhas.setBounds(20, 24, 246, 36);
		contentPane.add(lblPainelSenhas);
		
		JLabel lblSair = new JLabel("");
		lblSair.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		lblSair.setIcon(new ImageIcon(SenhasView.class.getResource("/rocha/guilherme/jose/view/icones/sair.png")));
		lblSair.setBounds(313, 10, 64, 64);
		contentPane.add(lblSair);
		
		btnMinhasSenhas = new JButton("Minhas Senhas");
		btnMinhasSenhas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnMinhasSenhas.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        mudarEstiloDoBotaoCorrespondente(btnMinhasSenhas, btnNovaSenha);
		    }
		});
		btnMinhasSenhas.setCursor(new Cursor((Cursor.HAND_CURSOR)));
		btnMinhasSenhas.setForeground(Color.WHITE);
		btnMinhasSenhas.setBackground(Color.decode("#373B44"));
		btnMinhasSenhas.setBorder(null);
		btnMinhasSenhas.setFont(new Font("Arial", Font.PLAIN, 22));
		btnMinhasSenhas.setBounds(12, 96, 181, 48);
		contentPane.add(btnMinhasSenhas);
		
		btnNovaSenha = new JButton("Nova Senha");
		btnNovaSenha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        
			}
		});
		btnNovaSenha.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        mudarEstiloDoBotaoCorrespondente(btnNovaSenha, btnMinhasSenhas);
		    }
		});
		btnNovaSenha.setCursor(new Cursor((Cursor.HAND_CURSOR)));
		btnNovaSenha.setContentAreaFilled(false);
		btnNovaSenha.setForeground(Color.WHITE);
		btnNovaSenha.setBorder(null);
		btnNovaSenha.setFont(new Font("Arial", Font.PLAIN, 22));
		btnNovaSenha.setBounds(200, 96, 181, 48);
		contentPane.add(btnNovaSenha);
		
	}

	private void mudarEstiloDoBotaoCorrespondente(JButton botaoSelecionado, JButton botaoNaoSelecionado) {
		botaoSelecionado.setContentAreaFilled(true);
		botaoSelecionado.setBackground(Color.decode("#373B44"));
		botaoNaoSelecionado.setContentAreaFilled(false);
	}
	
	public int exibeMensagemDecisao(String mensagem) {
		return JOptionPanePersonalizado.exibeMensagemDecisao(mensagem);
	}
}
