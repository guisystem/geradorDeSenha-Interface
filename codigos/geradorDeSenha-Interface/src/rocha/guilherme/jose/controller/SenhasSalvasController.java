package rocha.guilherme.jose.controller;

import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;

import javax.persistence.EntityManager;
import javax.swing.JOptionPane;

import rocha.guilherme.jose.controller.helper.SenhasSalvasHelper;
import rocha.guilherme.jose.model.ModelSenhasSalvas;
import rocha.guilherme.jose.model.ModelUsuario;
import rocha.guilherme.jose.model.dao.SenhasSalvasDAO;
import rocha.guilherme.jose.model.dao.UsuarioDAO;
import rocha.guilherme.jose.servico.Criptografar;
import rocha.guilherme.jose.servico.JPAConnection;
import rocha.guilherme.jose.view.SalvarSenhaView;
import rocha.guilherme.jose.view.SenhasSalvasPanel;

public class SenhasSalvasController {

	private final SenhasSalvasPanel senhasSalvasPanel;
	private static SenhasSalvasHelper helper;
	private final EntityManager em;
	
	public SenhasSalvasController(SenhasSalvasPanel senhasSalvasPanel) {
		this.senhasSalvasPanel = senhasSalvasPanel;
		SenhasSalvasController.helper = new SenhasSalvasHelper(senhasSalvasPanel);
		this.em = new JPAConnection().getEntityManager();
	}

	public static void preencherTabela(ModelUsuario usuario) {
		helper.preencherTabela(usuario);
	}

	private ModelSenhasSalvas getSenhaSelecionada(ModelUsuario usuario) {
		int linha = getLinhaSelecionada();
		String senhaTabela = senhasSalvasPanel.getTableSenhas().getValueAt(linha, 0).toString();
		String senhaCriptografada = Criptografar.criptografar(senhaTabela);
		
		for(ModelSenhasSalvas senha: usuario.getSenhasSalvas()) {
			if(senhaCriptografada.equals(senha.getSenha())) {
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
		em.getTransaction().begin();
		
		UsuarioDAO usuarioDAO = new UsuarioDAO(em);
		SenhasSalvasDAO senhasSalvasDAO = new SenhasSalvasDAO(em);
		
		if(getLinhaSelecionada() != -1) {
			if(senhasSalvasPanel.exibeMensagemDecisao("Deseja excluir essa senha?") == 
					JOptionPane.YES_OPTION) {
				ModelSenhasSalvas senha = getSenhaSelecionada(usuario);
				usuario.excluirSenha(senha);
				
				ModelSenhasSalvas senhaExiste = em.find(ModelSenhasSalvas.class, senha.getId());
				senhasSalvasDAO.delete(senhaExiste);
				
				usuarioDAO.insertOrUpdate(usuario);
				preencherTabela(usuario);
			}
		}else{
			senhasSalvasPanel.exibeMensagemInformativa("Selecione a linha com a senha que deseja excluir");
		}
		
		em.getTransaction().commit();
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
		String senhaDescriptografada = Criptografar.descriptografar(senha.getSenha());
		StringSelection selecao = new StringSelection(senhaDescriptografada);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selecao, null);
		
		int linha = getLinhaSelecionada();
		helper.personalizarBotaoCopiado(linha);
	}
	
}
