package rocha.guilherme.jose.controller;

import javax.persistence.EntityManager;
import javax.swing.JOptionPane;

import rocha.guilherme.jose.controller.helper.SalvarSenhaHelper;
import rocha.guilherme.jose.model.ModelSenhasSalvas;
import rocha.guilherme.jose.model.ModelUsuario;
import rocha.guilherme.jose.model.dao.SenhasSalvasDAO;
import rocha.guilherme.jose.model.dao.UsuarioDAO;
import rocha.guilherme.jose.servico.Criptografar;
import rocha.guilherme.jose.servico.JPAConnection;
import rocha.guilherme.jose.view.SalvarSenhaView;

public class SalvarSenhaController {

	private final SalvarSenhaView salvarSenhaView;
	private final SalvarSenhaHelper helper;
	private final EntityManager em;
	
	public SalvarSenhaController(SalvarSenhaView salvarSenhaView) {
		this.salvarSenhaView = salvarSenhaView;
		this.helper = new SalvarSenhaHelper(salvarSenhaView);
		this.em = new JPAConnection().getEntityManager();
	}

	public void preencherSenha(ModelSenhasSalvas senha) {
		helper.preencherSenha(senha);
	}
	
	public void salvarSenha(ModelUsuario usuario, ModelSenhasSalvas senha) {
		ModelSenhasSalvas senhaTela = helper.obterModelo();
		
		if(senhaTela.getDescricao().trim().isEmpty()) {
			if(salvarSenhaView.exibeMensagemDecisao("Deseja salvar a sua senha mesmo sem uma descrição?") ==
					JOptionPane.YES_OPTION) {
				atualizarOuSalvar(usuario, senha, senhaTela);
			}
		}else {
			atualizarOuSalvar(usuario, senha, senhaTela);
		}

		SenhasSalvasController.preencherTabela(usuario);
	}

	private void atualizarOuSalvar(ModelUsuario usuario, ModelSenhasSalvas senha, ModelSenhasSalvas senhaTela) {
		em.getTransaction().begin();
		
		UsuarioDAO usuarioDAO = new UsuarioDAO(em);
		SenhasSalvasDAO senhasSalvasDAO = new SenhasSalvasDAO(em);
		
		if(usuario.senhaJaExiste(senha)) {
			senha.setDescricao(senhaTela.getDescricao());
			senhasSalvasDAO.update(senha);
		}else {
			criptografarSenha(senhaTela);
			senhaTela.setUsuario(usuario);
			usuario.salvarSenha(senhaTela);
			senhasSalvasDAO.insert(senhaTela);
		}

		usuarioDAO.insertOrUpdate(usuario);
		salvarSenhaView.exibeMensagemInformativa("Senha salva com sucesso!");
		salvarSenhaView.dispose();
		
		em.getTransaction().commit();
	}

	private void criptografarSenha(ModelSenhasSalvas senhaTela) {
		senhaTela.setSenha(Criptografar.criptografar(senhaTela.getSenha()));
	}

	public void sair(SalvarSenhaView salvarSenhaView) {
		salvarSenhaView.dispose();
	}
	
}
