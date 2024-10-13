package rocha.guilherme.jose.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

@SuppressWarnings("serial")
public class GerarSenhaPanel extends JPanel {

	private JTextField textFieldQuantLetras;
	private JTextField textFieldQuantNumeros;
	private JTextField textFieldQuantCaracteresEspeciais;
	private JTextField textFieldPalavraPessoal;
	private JTextField textFieldSenhaGerada;
	private JRadioButton rdbtnSoMaiusculas;
	private JRadioButton rdbtnSoMinusculas;
	private JRadioButton rdbtnMaiusculasEMinusculas;
	private JRadioButton rdbtnPalavraSim;
	private JRadioButton rdbtnPalavraNao;
	private JLabel lblAvisoSenha_Dois;
	private JLabel lblAvisoSenha_Um;
	private ButtonGroup formaDaLetra;
	private ButtonGroup palavraPessoal;
	private Color corCirculo = new Color(255, 0, 0, 0);
	
	@Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(Color.WHITE);
        g2d.drawLine(12, 67, 380, 67);
        g2d.drawLine(12, 151, 380, 151);
        g2d.drawLine(12, 427, 380, 427);
        g2d.drawLine(12, 519, 380, 519);
        g2d.drawLine(12, 631, 276, 631);
        g2d.drawLine(380, 554, 380, 631);
        
        g2d.setColor(corCirculo);
        int x = 12;
        int y = 604;
        int tamanho = 20;
        g2d.drawOval(x, y, tamanho, tamanho);

    }
	
	/**
	 * Create the panel.
	 * @param usuario 
	 */
	public GerarSenhaPanel() {
		this.setBounds(0, 156, 393, 696);
		this.setOpaque(false);
		this.setLayout(null);
		
		JLabel lblQuantLetras_um = new JLabel("Quantas letras deseja em");
		lblQuantLetras_um.setForeground(new Color(255, 255, 255));
		lblQuantLetras_um.setFont(new Font("Arial", Font.PLAIN, 20));
		lblQuantLetras_um.setBounds(12, 12, 226, 28);
		this.add(lblQuantLetras_um);
		
		JLabel lblQuantLetras_dois = new JLabel("sua senha?");
		lblQuantLetras_dois.setForeground(new Color(255, 255, 255));
		lblQuantLetras_dois.setFont(new Font("Arial", Font.PLAIN, 20));
		lblQuantLetras_dois.setBounds(12, 40, 100, 28);
		this.add(lblQuantLetras_dois);
		
		JLabel lblQuantNumeros_um = new JLabel("Quantas números deseja em");
		lblQuantNumeros_um.setForeground(Color.WHITE);
		lblQuantNumeros_um.setFont(new Font("Arial", Font.PLAIN, 20));
		lblQuantNumeros_um.setBounds(12, 96, 254, 28);
		this.add(lblQuantNumeros_um);
		
		JLabel lblQuantNumeros_dois = new JLabel("sua senha?");
		lblQuantNumeros_dois.setForeground(Color.WHITE);
		lblQuantNumeros_dois.setFont(new Font("Arial", Font.PLAIN, 20));
		lblQuantNumeros_dois.setBounds(12, 124, 100, 28);
		this.add(lblQuantNumeros_dois);
		
		JLabel lblQuantCaracteresEspeciais_um = new JLabel("Quantas caracteres especiais");
		lblQuantCaracteresEspeciais_um.setForeground(Color.WHITE);
		lblQuantCaracteresEspeciais_um.setFont(new Font("Arial", Font.PLAIN, 20));
		lblQuantCaracteresEspeciais_um.setBounds(12, 372, 267, 28);
		this.add(lblQuantCaracteresEspeciais_um);
		
		JLabel lblQuantCaracteresEspeciais_dois = new JLabel("deseja em sua senha?");
		lblQuantCaracteresEspeciais_dois.setForeground(Color.WHITE);
		lblQuantCaracteresEspeciais_dois.setFont(new Font("Arial", Font.PLAIN, 20));
		lblQuantCaracteresEspeciais_dois.setBounds(12, 400, 206, 28);
		this.add(lblQuantCaracteresEspeciais_dois);
		
		JLabel lblFormaLetra_um = new JLabel("As letras que contém em sua senha tem");
		lblFormaLetra_um.setForeground(Color.WHITE);
		lblFormaLetra_um.setFont(new Font("Arial", Font.PLAIN, 20));
		lblFormaLetra_um.setBounds(12, 180, 369, 28);
		this.add(lblFormaLetra_um);
		
		JLabel lblFormaLetra_dois = new JLabel("que ser:");
		lblFormaLetra_dois.setForeground(Color.WHITE);
		lblFormaLetra_dois.setFont(new Font("Arial", Font.PLAIN, 20));
		lblFormaLetra_dois.setBounds(12, 208, 78, 28);
		this.add(lblFormaLetra_dois);
		
		JLabel lblPalavraPessoal = new JLabel("Deseja adicionar alguma palavra?");
		lblPalavraPessoal.setForeground(Color.WHITE);
		lblPalavraPessoal.setFont(new Font("Arial", Font.PLAIN, 20));
		lblPalavraPessoal.setBounds(12, 456, 302, 28);
		this.add(lblPalavraPessoal);
		
		rdbtnSoMaiusculas = new JRadioButton();
		rdbtnSoMaiusculas.setText("Só Maiúsculas");
		rdbtnSoMaiusculas.setForeground(new Color(255, 255, 255));
		rdbtnSoMaiusculas.setOpaque(false);
		rdbtnSoMaiusculas.setFont(new Font("Arial", Font.PLAIN, 18));
		rdbtnSoMaiusculas.setBounds(12, 248, 180, 24);
		this.add(rdbtnSoMaiusculas);
		
		rdbtnSoMinusculas = new JRadioButton();
		rdbtnSoMinusculas.setText("Só Minúsculas");
		rdbtnSoMinusculas.setForeground(new Color(255, 255, 255));
		rdbtnSoMinusculas.setOpaque(false);
		rdbtnSoMinusculas.setFont(new Font("Arial", Font.PLAIN, 18));
		rdbtnSoMinusculas.setBounds(12, 284, 180, 24);
		this.add(rdbtnSoMinusculas);
		
		rdbtnMaiusculasEMinusculas = new JRadioButton();
		rdbtnMaiusculasEMinusculas.setText("Maiúsculas e Minúsculas");
		rdbtnMaiusculasEMinusculas.setSelected(true);
		rdbtnMaiusculasEMinusculas.setForeground(new Color(255, 255, 255));
		rdbtnMaiusculasEMinusculas.setOpaque(false);
		rdbtnMaiusculasEMinusculas.setFont(new Font("Arial", Font.PLAIN, 18));
		rdbtnMaiusculasEMinusculas.setBounds(12, 320, 254, 24);
		this.add(rdbtnMaiusculasEMinusculas);
		
		rdbtnPalavraNao = new JRadioButton();
		rdbtnPalavraNao.setText("Não");
		rdbtnPalavraNao.setForeground(new Color(255, 255, 255));
		rdbtnPalavraNao.setOpaque(false);
		rdbtnPalavraNao.setSelected(true);
		rdbtnPalavraNao.setFont(new Font("Arial", Font.PLAIN, 18));
		rdbtnPalavraNao.setBounds(12, 490, 63, 24);
		this.add(rdbtnPalavraNao);
		
		rdbtnPalavraSim = new JRadioButton();
		rdbtnPalavraSim.setText("Sim");
		rdbtnPalavraSim.setForeground(new Color(255, 255, 255));
		rdbtnPalavraSim.setOpaque(false);
		rdbtnPalavraSim.setFont(new Font("Arial", Font.PLAIN, 18));
		rdbtnPalavraSim.setBounds(107, 490, 63, 24);
		this.add(rdbtnPalavraSim);
		
		textFieldQuantLetras = new JTextField();
		textFieldQuantLetras.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldQuantLetras.setForeground(new Color(255, 255, 255));
		textFieldQuantLetras.setBorder(new LineBorder(Color.WHITE));
		textFieldQuantLetras.setCaretColor(Color.WHITE);
		textFieldQuantLetras.setFont(new Font("Arial", Font.PLAIN, 20));
		textFieldQuantLetras.setOpaque(false);
		textFieldQuantLetras.setBounds(303, 32, 78, 36);
		this.add(textFieldQuantLetras);
		textFieldQuantLetras.setColumns(10);
		
		textFieldQuantNumeros = new JTextField();
		textFieldQuantNumeros.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldQuantNumeros.setForeground(new Color(255, 255, 255));
		textFieldQuantNumeros.setBorder(new LineBorder(Color.WHITE));
		textFieldQuantNumeros.setCaretColor(Color.WHITE);
		textFieldQuantNumeros.setFont(new Font("Arial", Font.PLAIN, 20));
		textFieldQuantNumeros.setOpaque(false);
		textFieldQuantNumeros.setColumns(10);
		textFieldQuantNumeros.setBounds(303, 116, 78, 36);
		this.add(textFieldQuantNumeros);
		
		textFieldQuantCaracteresEspeciais = new JTextField();
		textFieldQuantCaracteresEspeciais.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldQuantCaracteresEspeciais.setForeground(new Color(255, 255, 255));
		textFieldQuantCaracteresEspeciais.setBorder(new LineBorder(Color.WHITE));
		textFieldQuantCaracteresEspeciais.setCaretColor(Color.WHITE);
		textFieldQuantCaracteresEspeciais.setFont(new Font("Arial", Font.PLAIN, 20));
		textFieldQuantCaracteresEspeciais.setOpaque(false);
		textFieldQuantCaracteresEspeciais.setColumns(10);
		textFieldQuantCaracteresEspeciais.setBounds(303, 392, 78, 36);
		this.add(textFieldQuantCaracteresEspeciais);
		
		textFieldPalavraPessoal = new JTextField();
		textFieldPalavraPessoal.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if(rdbtnPalavraSim.isSelected()){
					textFieldPalavraPessoal.setEditable(true);
				}else {
					textFieldPalavraPessoal.setEditable(false);
				}
			}
		});
		textFieldPalavraPessoal.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				
			}
		});
		textFieldPalavraPessoal.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldPalavraPessoal.setForeground(new Color(255, 255, 255));
		textFieldPalavraPessoal.setBorder(new LineBorder(Color.WHITE));
		textFieldPalavraPessoal.setCaretColor(Color.WHITE);
		textFieldPalavraPessoal.setFont(new Font("Arial", Font.PLAIN, 20));
		textFieldPalavraPessoal.setOpaque(false);
		textFieldPalavraPessoal.setColumns(10);
		textFieldPalavraPessoal.setBounds(201, 484, 180, 36);
		this.add(textFieldPalavraPessoal);
		
		textFieldSenhaGerada = new JTextField();
		textFieldSenhaGerada.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldSenhaGerada.setForeground(new Color(255, 255, 255));
		textFieldSenhaGerada.setBorder(new LineBorder(Color.WHITE));
		textFieldSenhaGerada.setCaretColor(Color.WHITE);
		textFieldSenhaGerada.setFont(new Font("Arial", Font.PLAIN, 20));
		textFieldSenhaGerada.setOpaque(false);
		textFieldSenhaGerada.setColumns(10);
		textFieldSenhaGerada.setBounds(201, 554, 180, 36);
		this.add(textFieldSenhaGerada);
		
		JButton btnGerarSenha = new JButtonPersonalizado(Color.decode("#1E3663"), Color.decode("#133E8C"), 5, 5);
		btnGerarSenha.setText("GERAR SENHA");
		btnGerarSenha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnGerarSenha.addMouseListener(new MouseAdapter() {
			@Override
		    public void mouseEntered(MouseEvent e) {
				efeitoMouseOver(btnGerarSenha);
		    }

		    @Override
		    public void mouseExited(MouseEvent e) {
		    	efeitoMouseExit(btnGerarSenha);
		    }
		});
		btnGerarSenha.setBorder(null);
		btnGerarSenha.setFont(new Font("Arial", Font.PLAIN, 20));
		btnGerarSenha.setBounds(12, 548, 180, 48);
		this.add(btnGerarSenha);
		
		JButton btnSalvarSenha = new JButtonPersonalizado(Color.decode("#2060D2"), Color.decode("#2060D2"), 0, 0);
		btnSalvarSenha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnSalvarSenha.setText("SALVAR");
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
		btnSalvarSenha.setBorder(new LineBorder(Color.WHITE));
		btnSalvarSenha.setFont(new Font("Arial", Font.PLAIN, 16));
		btnSalvarSenha.setBounds(281, 596, 100, 36);
		this.add(btnSalvarSenha);
		
		lblAvisoSenha_Um = new JLabel("");
		lblAvisoSenha_Um.setForeground(Color.WHITE);
		lblAvisoSenha_Um.setFont(new Font("Arial", Font.PLAIN, 16));
		lblAvisoSenha_Um.setBounds(40, 604, 197, 20);
		this.add(lblAvisoSenha_Um);
		
		lblAvisoSenha_Dois = new JLabel("A senha deve ter um tamanho entre 8 e 30.");
		lblAvisoSenha_Dois.setForeground(new Color(255, 255, 255, 0));
		lblAvisoSenha_Dois.setFont(new Font("Arial", Font.PLAIN, 16));
		lblAvisoSenha_Dois.setBounds(12, 640, 369, 20);
		this.add(lblAvisoSenha_Dois);
		
		formaDaLetra = new ButtonGroup();
		formaDaLetra.add(rdbtnSoMaiusculas);
		formaDaLetra.add(rdbtnSoMinusculas);
		formaDaLetra.add(rdbtnMaiusculasEMinusculas);
		
		palavraPessoal = new ButtonGroup();
		palavraPessoal.add(rdbtnPalavraNao);
		palavraPessoal.add(rdbtnPalavraSim);
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

	public JTextField getTextFieldQuantLetras() {
		return textFieldQuantLetras;
	}

	public void setTextFieldQuantLetras(JTextField textFieldQuantLetras) {
		this.textFieldQuantLetras = textFieldQuantLetras;
	}

	public JTextField getTextFieldQuantNumeros() {
		return textFieldQuantNumeros;
	}

	public void setTextFieldQuantNumeros(JTextField textFieldQuantNumeros) {
		this.textFieldQuantNumeros = textFieldQuantNumeros;
	}

	public JTextField getTextFieldQuantCaracteresEspeciais() {
		return textFieldQuantCaracteresEspeciais;
	}

	public void setTextFieldQuantCaracteresEspeciais(JTextField textFieldQuantCaracteresEspeciais) {
		this.textFieldQuantCaracteresEspeciais = textFieldQuantCaracteresEspeciais;
	}

	public JTextField getTextFieldPalavraPessoal() {
		return textFieldPalavraPessoal;
	}

	public void setTextFieldPalavraPessoal(JTextField textFieldPalavraPessoal) {
		this.textFieldPalavraPessoal = textFieldPalavraPessoal;
	}

	public JTextField getTextFieldSenhaGerada() {
		return textFieldSenhaGerada;
	}

	public void setTextFieldSenhaGerada(JTextField textFieldSenhaGerada) {
		this.textFieldSenhaGerada = textFieldSenhaGerada;
	}

	public JRadioButton getRdbtnSoMaiusculas() {
		return rdbtnSoMaiusculas;
	}

	public void setRdbtnSoMaiusculas(JRadioButton rdbtnSoMaiusculas) {
		this.rdbtnSoMaiusculas = rdbtnSoMaiusculas;
	}

	public JRadioButton getRdbtnSoMinusculas() {
		return rdbtnSoMinusculas;
	}

	public void setRdbtnSoMinusculas(JRadioButton rdbtnSoMinusculas) {
		this.rdbtnSoMinusculas = rdbtnSoMinusculas;
	}

	public JRadioButton getRdbtnMaiusculasEMinusculas() {
		return rdbtnMaiusculasEMinusculas;
	}

	public void setRdbtnMaiusculasEMinusculas(JRadioButton rdbtnMaiusculasEMinusculas) {
		this.rdbtnMaiusculasEMinusculas = rdbtnMaiusculasEMinusculas;
	}

	public JRadioButton getRdbtnPalavraSim() {
		return rdbtnPalavraSim;
	}

	public void setRdbtnPalavraSim(JRadioButton rdbtnPalavraSim) {
		this.rdbtnPalavraSim = rdbtnPalavraSim;
	}

	public JRadioButton getRdbtnPalavraNao() {
		return rdbtnPalavraNao;
	}

	public void setRdbtnPalavraNao(JRadioButton rdbtnPalavraNao) {
		this.rdbtnPalavraNao = rdbtnPalavraNao;
	}

	public ButtonGroup getFormaDaLetra() {
		return formaDaLetra;
	}

	public void setFormaDaLetra(ButtonGroup formaDaLetra) {
		this.formaDaLetra = formaDaLetra;
	}

	public ButtonGroup getPalavraPessoal() {
		return palavraPessoal;
	}

	public void setPalavraPessoal(ButtonGroup palavraPessoal) {
		this.palavraPessoal = palavraPessoal;
	}
	
}
