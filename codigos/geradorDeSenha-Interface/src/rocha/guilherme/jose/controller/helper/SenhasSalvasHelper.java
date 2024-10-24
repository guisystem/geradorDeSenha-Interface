package rocha.guilherme.jose.controller.helper;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import rocha.guilherme.jose.model.ModelSenhasSalvas;
import rocha.guilherme.jose.model.ModelUsuario;
import rocha.guilherme.jose.model.SenhaTableModel;
import rocha.guilherme.jose.view.SenhasSalvasPanel;

public class SenhasSalvasHelper {

	private SenhasSalvasPanel senhasSalvasPanel;

	public SenhasSalvasHelper(SenhasSalvasPanel senhasSalvasPanel) {
		this.senhasSalvasPanel = senhasSalvasPanel;
	}

	public void preencherTabela(ModelUsuario usuario) {
		SenhaTableModel tableModel = (SenhaTableModel) senhasSalvasPanel.getTableSenhas().getModel();
		    
	    tableModel.setNumRows(0);
	    
	    for (ModelSenhasSalvas senha : usuario.getSenhasSalvas()) {
	        tableModel.addRow(senha);
	    }
	}

	public void personalizarBotaoCopiado(int linha) {
		SenhaTableModel tableModel = (SenhaTableModel) senhasSalvasPanel.getTableSenhas().getModel();
		tableModel.setValueAt("COPIADO", linha, 2); 
		
	    Timer timer = new Timer(3000, new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	tableModel.setValueAt("COPIAR", linha, 2);
	        }
	    });
	    timer.setRepeats(false);
	    timer.start();
	}
	
}
