package rocha.guilherme.jose.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import rocha.guilherme.jose.controller.SenhasSalvasController;
import rocha.guilherme.jose.model.ModelUsuario;
import rocha.guilherme.jose.model.SenhaTableModel;

@SuppressWarnings("serial")
public class SenhasSalvasPanel extends JPanel {

	private JTable tableSenhas;
	private SenhaTableModel tableModel = new SenhaTableModel();
	private SenhasSalvasController controller;
	private ModelUsuario usuario;
	
	/**
	 * Create the panel.
	 */
	public SenhasSalvasPanel(ModelUsuario usuario) {
		this.usuario = usuario;
		controller = new SenhasSalvasController(this);
		
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
		tableSenhas.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 1 || e.getClickCount() == 2) {
					if (tableSenhas.getSelectedColumn() == 2 && 
							"COPIAR".equals(tableSenhas.getValueAt(tableSenhas.getSelectedRow(), 2))) {
						controller.copiarSenha(usuario);
					}
				}
			}
		});
		tableSenhas.addMouseMotionListener(new MouseMotionListener() {
		    @Override
		    public void mouseMoved(MouseEvent e) {
		    	if(tableSenhas.getRowCount() > 0 && tableSenhas.columnAtPoint(e.getPoint())==2) {
		    		tableSenhas.setCursor(new Cursor(Cursor.HAND_CURSOR));
		    	}else{
		    		tableSenhas.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); 
		    	}
		    }

		    @Override
		    public void mouseDragged(MouseEvent e) {

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
		
		iniciar();
	}
	
	private void iniciar() {
		controller.preencherTabela(usuario);
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
