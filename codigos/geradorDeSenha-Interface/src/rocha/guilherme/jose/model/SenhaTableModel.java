package rocha.guilherme.jose.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public class SenhaTableModel extends AbstractTableModel{
	
	private List<ModelSenhasSalvas> senhas = new ArrayList<>();
	private String[] colunas = {"Senha", "Descrição", ""};
	private List<String> statusCopiar = new ArrayList<>();
	
	@Override
	public String getColumnName(int coluna) {
		return colunas[coluna];
	}
	
	@Override
	public int getRowCount() {
		if(senhas.isEmpty()) {
			return 0;
		}
		return senhas.size();
	}

	@Override
	public int getColumnCount() {
		return colunas.length;
	}

	@Override
	public Object getValueAt(int linha, int coluna) {
		
		switch(coluna) {
		
		case 0:
			return senhas.get(linha).getSenha();
		case 1:
			return senhas.get(linha).getDescricao();
		case 2:
            return statusCopiar.get(linha);
		}
		
		return null;
	}
	
	@Override
	public void setValueAt(Object dado, int linha, int coluna) {
		switch(coluna) {
		
		case 0:
			senhas.get(linha).setSenha((String) dado);
			break;
		case 1:
			senhas.get(linha).setDescricao((String) dado);
			break;
		case 2:
			try {
				statusCopiar.set(linha, (String) dado);
				break;
			} catch (IndexOutOfBoundsException e) {
				break;
			}
		}
		
		this.fireTableRowsUpdated(linha, linha);
	}
	
	public void addRow(ModelSenhasSalvas senha) {
		this.senhas.add(senha);
		this.statusCopiar.add("COPIAR");
		this.fireTableDataChanged();
	}
	
	public void setNumRows(int rowCount) {
        this.senhas.clear();
        this.statusCopiar.clear();
        this.fireTableDataChanged();
    }
	
	public void removeRow(int linha) {
		this.senhas.remove(linha);
		this.statusCopiar.remove(linha);
		this.fireTableRowsDeleted(linha, linha);
	}
	
	public ModelSenhasSalvas getSenha(int linha) {
		ModelSenhasSalvas senhaLinha = new ModelSenhasSalvas();
		senhaLinha.setSenha(senhas.get(linha).getSenha());
		senhaLinha.setDescricao(senhas.get(linha).getDescricao());
		
		return senhaLinha;
	}
	
}
