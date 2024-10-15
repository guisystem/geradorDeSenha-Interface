package rocha.guilherme.jose.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import rocha.guilherme.jose.model.SenhaTableModel;

@SuppressWarnings("serial")
public class SenhasSalvasPanel extends JPanel {

	private JTable tableSenhas;
	private SenhaTableModel tableModel = new SenhaTableModel();
	
	/**
	 * Create the panel.
	 */
	public SenhasSalvasPanel() {
		
		this.setOpaque(false);
		this.setBounds(0, 158, 393, 694);
		this.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setOpaque(false);
		scrollPane.getViewport().setOpaque(false);
		scrollPane.setBorder(BorderFactory.createEmptyBorder());
		scrollPane.setBounds(12, 14, 369, 504);
		this.add(scrollPane);

		tableSenhas = new JTable();
		tableSenhas.setGridColor(Color.decode("#2060D2"));
		JTableHeader header = tableSenhas.getTableHeader();
		header.setDefaultRenderer(new JTableHeaderPersonalizado(Color.decode("#2060D2"), Color.decode("#2060D2")));
		header.setPreferredSize(new Dimension(header.getWidth(), 32));
		header.setReorderingAllowed(false);
		header.setResizingAllowed(false);
		tableSenhas.setDefaultRenderer(Object.class, new JTablePersonalizado(Color.decode("#141E30"), Color.decode("#243B55")));
		tableSenhas.setFont(new Font("Arial", Font.PLAIN, 16));
		tableSenhas.setRowHeight(32);
		tableSenhas.setModel(new DefaultTableModel(
			new Object[][] {
				
			},
			new String[] {
				"Senha", "Descrição", ""
			}
		){
			public boolean isCellEditable(int row, int column) {
				if(column != 9) {
					return false;
				}
				return super.isCellEditable(row, column);
			}
		});
		tableSenhas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableSenhas.getColumnModel().getColumn(0).setPreferredWidth(150);
		tableSenhas.getColumnModel().getColumn(1).setPreferredWidth(150);
		scrollPane.setViewportView(tableSenhas);
		tableSenhas.setModel(tableModel);
		
		JButton btnExcluirSenha = new JButtonPersonalizado(Color.decode("#1E3663"), Color.decode("#133E8C"), 10, 10);
		btnExcluirSenha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnExcluirSenha.setText("EXCLUIR");
		btnExcluirSenha.addMouseListener(new MouseAdapter() {
			@Override
		    public void mouseEntered(MouseEvent e) {
				efeitoMouseOver(btnExcluirSenha);
		    }

		    @Override
		    public void mouseExited(MouseEvent e) {
		    	efeitoMouseExit(btnExcluirSenha);
		    }
		});
		btnExcluirSenha.setFont(new Font("Arial", Font.PLAIN, 22));
		btnExcluirSenha.setBounds(12, 550, 150, 40);
		this.add(btnExcluirSenha);
		
		JButton btnEditar = new JButtonPersonalizado(Color.decode("#1E3663"), Color.decode("#133E8C"), 10, 10);
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnEditar.setText("EDITAR");
		btnEditar.addMouseListener(new MouseAdapter() {
			@Override
		    public void mouseEntered(MouseEvent e) {
				efeitoMouseOver(btnEditar);
		    }

		    @Override
		    public void mouseExited(MouseEvent e) {
		    	efeitoMouseExit(btnEditar);
		    }
		});
		btnEditar.setFont(new Font("Arial", Font.PLAIN, 22));
		btnEditar.setBounds(170, 550, 150, 40);
		this.add(btnEditar);
		
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
	
	public JTable getTableSenhas() {
		return tableSenhas;
	}

	public void setTableSenhas(JTable tableSenhas) {
		this.tableSenhas = tableSenhas;
	}
	
}
