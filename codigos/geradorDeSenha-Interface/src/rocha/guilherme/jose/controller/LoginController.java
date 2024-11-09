package rocha.guilherme.jose.controller;

import javax.persistence.EntityManager;
import javax.swing.JOptionPane;

import rocha.guilherme.jose.controller.helper.LoginHelper;
import rocha.guilherme.jose.model.ModelUsuario;
import rocha.guilherme.jose.model.dao.UsuarioDAO;
import rocha.guilherme.jose.servico.JPAConnection;
import rocha.guilherme.jose.view.CadastroUsuarioView;
import rocha.guilherme.jose.view.LoginView;
import rocha.guilherme.jose.view.RedefinirSenhaView;
import rocha.guilherme.jose.view.SenhasView;

public class LoginController {

	private final LoginView loginView;
	private final LoginHelper helper;
	private final EntityManager em;
	
	public LoginController(LoginView loginView) {
		this.loginView = loginView;
		this.helper = new LoginHelper(loginView);
		this.em = new JPAConnection().getEntityManager();
	}

	public void entrarNoAplicativo() {
		ModelUsuario usuario = helper.obterModelo();
		
		UsuarioDAO usuarioDAO = new UsuarioDAO(em);
		ModelUsuario usuarioAutenticado = usuarioDAO.selectPorNomeOuEmailESenha(usuario);
		
		if(usuarioAutenticado != null) {
			irParaTelaInicial(usuarioAutenticado);
			loginView.dispose();
		}else {
			loginView.exibeMensagemInformativa("Usuário ou/e Senha inválidos");
		}
	}
	
	public void irParaTelaCadastro() {
		loginView.dispose();
		
		CadastroUsuarioView cadastroUsuarioView = new CadastroUsuarioView();
		cadastroUsuarioView.setLocationRelativeTo(null);
		cadastroUsuarioView.setResizable(false);
		cadastroUsuarioView.setVisible(true);
	}
	
	public void irParaTelaRedefinirSenha() {
		RedefinirSenhaView redefinirSenhaView = new RedefinirSenhaView();
		redefinirSenhaView.setLocationRelativeTo(null);
		redefinirSenhaView.setResizable(false);
		redefinirSenhaView.setVisible(true);
	}

	private void irParaTelaInicial(ModelUsuario usuario) {
		SenhasView telaInicial = new SenhasView(usuario);
		telaInicial.setLocationRelativeTo(null);
		telaInicial.setResizable(false);
		telaInicial.setVisible(true);
	}

	public void fecharAplicacao() {
		if(loginView.exibeMensagemDecisao("Deseja fechar a aplicação?") == 
				JOptionPane.YES_OPTION) {
			System.exit(0);
		}
		
	}

	
}
