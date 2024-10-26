package rocha.guilherme.jose.controller;

import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;

import javax.swing.JOptionPane;

import rocha.guilherme.jose.controller.helper.SenhasSalvasHelper;
import rocha.guilherme.jose.model.ModelSenhasSalvas;
import rocha.guilherme.jose.model.ModelUsuario;
import rocha.guilherme.jose.model.dao.SenhasSalvasDAO;
import rocha.guilherme.jose.model.dao.UsuarioDAO;
import rocha.guilherme.jose.view.SalvarSenhaView;
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

	public void excluirSenha(ModelUsuario usuario) {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		SenhasSalvasDAO senhasSalvasDAO = new SenhasSalvasDAO();
		
		if(getLinhaSelecionada() != -1) {
			if(senhasSalvasPanel.exibeMensagemDecisao("Deseja excluir essa senha?") == 
					JOptionPane.YES_OPTION) {
				ModelSenhasSalvas senha = getSenhaSelecionada(usuario);
				usuario.excluirSenha(senha);
				senhasSalvasDAO.delete(senha);
				usuarioDAO.update(usuario);
				preencherTabela(usuario);
			}
		}else{
			senhasSalvasPanel.exibeMensagemInformativa("Selecione a linha com a senha que deseja excluir");
		}
	}

	public void editarDescricao(ModelUsuario usuario) {
		if(getLinhaSelecionada() != -1) {
			ModelSenhasSalvas senha = getSenhaSelecionada(usuario);
			irParaTelaDeSalvarSenha(usuario, senha);
		}else{
			senhasSalvasPanel.exibeMensagemInformativa("Selecione a linha com a descrição que deseja editar");
		}
		
	}
	
	private void irParaTelaDeSalvarSenha(ModelUsuario usuario, ModelSenhasSalvas senha) {
		SalvarSenhaView salvarSenhaView = new SalvarSenhaView(usuario, senha);
		salvarSenhaView.setResizable(false);
		salvarSenhaView.setLocationRelativeTo(null);
		salvarSenhaView.setVisible(true);
		
	}

	public void copiarSenha(ModelUsuario usuario) {
		ModelSenhasSalvas senha = getSenhaSelecionada(usuario);
		StringSelection selecao = new StringSelection(senha.getSenha());
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selecao, null);
		
		int linha = getLinhaSelecionada();
		helper.personalizarBotaoCopiado(linha);
	}
	
}
