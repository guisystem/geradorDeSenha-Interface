package rocha.guilherme.jose.controller;

import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;

import rocha.guilherme.jose.controller.helper.SenhasSalvasHelper;
import rocha.guilherme.jose.model.ModelSenhasSalvas;
import rocha.guilherme.jose.model.ModelUsuario;
import rocha.guilherme.jose.view.SenhasSalvasPanel;

public class SenhasSalvasController {

	private SenhasSalvasPanel senhasSalvasPanel;
	private SenhasSalvasHelper helper;
	
	public SenhasSalvasController(SenhasSalvasPanel senhasSalvasPanel) {
		this.senhasSalvasPanel = senhasSalvasPanel;
		this.helper = new SenhasSalvasHelper(senhasSalvasPanel);
	}

	public void preencherTabela(ModelUsuario usuario) {
		helper.preencherTabela(usuario);
	}

	private ModelSenhasSalvas getSenhaSelecionada(ModelUsuario usuario) {
		int linha = getLinhaSelecionada();
		String senhaTabela = senhasSalvasPanel.getTableSenhas().getValueAt(linha, 0).toString();
		
		for(ModelSenhasSalvas senha: usuario.getSenhasSalvas()) {
			if(senhaTabela.equals(senha.getSenha())) {
				return senha;
			}
		}
		
		return null;
	}
	
	private int getLinhaSelecionada() {
		int linha = senhasSalvasPanel.getTableSenhas().getSelectedRow();
		return linha;
	}

	public void copiarSenha(ModelUsuario usuario) {
		ModelSenhasSalvas senha = getSenhaSelecionada(usuario);
		StringSelection selecao = new StringSelection(senha.getSenha());
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selecao, null);
		
		int linha = getLinhaSelecionada();
		helper.personalizarBotaoCopiado(linha);
	}
	
}
