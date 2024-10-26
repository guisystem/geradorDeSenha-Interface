package rocha.guilherme.jose.controller;

import javax.swing.JOptionPane;

import rocha.guilherme.jose.controller.helper.SalvarSenhaHelper;
import rocha.guilherme.jose.model.ModelSenhasSalvas;
import rocha.guilherme.jose.model.ModelUsuario;
import rocha.guilherme.jose.model.dao.SenhasSalvasDAO;
import rocha.guilherme.jose.model.dao.UsuarioDAO;
import rocha.guilherme.jose.view.SalvarSenhaView;

public class SalvarSenhaController {

	private SalvarSenhaView salvarSenhaView;
	private SalvarSenhaHelper helper;
	
	public SalvarSenhaController(SalvarSenhaView salvarSenhaView) {
		this.salvarSenhaView = salvarSenhaView;
		this.helper = new SalvarSenhaHelper(salvarSenhaView);
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
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		SenhasSalvasDAO senhasSalvasDAO = new SenhasSalvasDAO();
		
		if(usuario.senhaJaExiste(senha)) {
			senha.setDescricao(senhaTela.getDescricao());
			senhasSalvasDAO.update(senha);
			usuarioDAO.update(usuario);
		}else {
			senhaTela.setUsuario(usuario);
			usuario.salvarSenha(senhaTela);
			senhasSalvasDAO.insert(senhaTela);
			usuarioDAO.update(usuario);
		}

		salvarSenhaView.exibeMensagemInformativa("Senha salva com sucesso!");
		salvarSenhaView.dispose();
	}

	public void sair(SalvarSenhaView salvarSenhaView) {
		salvarSenhaView.dispose();
	}
	
}
