package rocha.guilherme.jose.controller.helper;

import javax.persistence.EntityManager;

import rocha.guilherme.jose.model.ModelUsuario;
import rocha.guilherme.jose.model.dao.UsuarioDAO;
import rocha.guilherme.jose.view.CadastroUsuarioView;

public class CadastroUsuarioHelper {

	private final CadastroUsuarioView cadastroUsuarioView;

	public CadastroUsuarioHelper(CadastroUsuarioView cadastroUsuarioView) {
		this.cadastroUsuarioView = cadastroUsuarioView;
	}

	@SuppressWarnings("deprecation")
	public ModelUsuario obterModelo() {
		String nomeUsuario = cadastroUsuarioView.getTextFieldUsuario().getText();
		String emailUsuario = cadastroUsuarioView.getTextFieldEmail().getText();
		String senha = cadastroUsuarioView.getPasswordFieldSenha().getText();
		
		ModelUsuario usuario = new ModelUsuario(nomeUsuario, senha, emailUsuario);
		
		return usuario;
	}

	@SuppressWarnings("deprecation")
	public boolean verificarCampos() {
		if(cadastroUsuarioView.getTextFieldUsuario().getText().trim().isEmpty() ||
				cadastroUsuarioView.getTextFieldEmail().getText().trim().isEmpty() ||
				cadastroUsuarioView.getPasswordFieldSenha().getText().trim().isEmpty()) {
			return false;			
		}
		
		return true;
	}
	
	public boolean validarNomeUsuario(EntityManager em, ModelUsuario novoUsuario) {
		UsuarioDAO usuarioDAO = new UsuarioDAO(em);
		
		ModelUsuario usuarioExiste = usuarioDAO.selectPorNome(novoUsuario);
		
		if(usuarioExiste != null) {
			return false;
		}
		
		return true;
	}

	public boolean validarEmail() {
		if(cadastroUsuarioView.getTextFieldEmail().getText().trim().isEmpty()) return false;
		
		String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";

		if (!cadastroUsuarioView.getTextFieldEmail().getText().matches(emailRegex)) {
		    return false;
		} else if (!cadastroUsuarioView.getTextFieldEmail().getText().contains("gmail.com")) {
		    return false;
		}
		
		return true;
	}

	public boolean verificarEmailDisponivel(EntityManager em, ModelUsuario novoUsuario) {
		UsuarioDAO usuarioDAO = new UsuarioDAO(em);
		
		for(ModelUsuario usuarioBanco: usuarioDAO.selectAll()) {
			if(usuarioBanco.getEmailUsuario().equals(novoUsuario.getEmailUsuario())) {
				return false;				
			}
		}
		
		return true;
	}

	@SuppressWarnings("deprecation")
	public boolean validarSenha() {
		if(cadastroUsuarioView.getPasswordFieldSenha().getText().trim().length() < 8) return false;
		if(cadastroUsuarioView.getPasswordFieldSenha().getText().trim().isEmpty()) return false;
		return true;
	}

}
