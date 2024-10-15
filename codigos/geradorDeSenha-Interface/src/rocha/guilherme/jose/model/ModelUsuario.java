package rocha.guilherme.jose.model;

import java.util.ArrayList;
import java.util.List;

public class ModelUsuario {

	private int id;
	private String nomeUsuario;
	private String senhaUsuario;
	private String emailUsuario;
	private List<ModelSenhasSalvas> senhasSalvas = new ArrayList<>();
	
	public ModelUsuario() {

	}
	
	public ModelUsuario(int id, String nomeUsuario, String senhaUsuario, String emailUsuario) {
		this.id = id;
		this.nomeUsuario = nomeUsuario;
		this.senhaUsuario = senhaUsuario;
		this.emailUsuario = emailUsuario;
	}

	public ModelUsuario(String nomeUsuario, String senhaUsuario, String emailUsuario) {
		this.nomeUsuario = nomeUsuario;
		this.senhaUsuario = senhaUsuario;
		this.emailUsuario = emailUsuario;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getSenhaUsuario() {
		return senhaUsuario;
	}

	public void setSenhaUsuario(String senhaUsuario) {
		this.senhaUsuario = senhaUsuario;
	}
	
	public String getEmailUsuario() {
		return emailUsuario;
	}

	public void setEmailUsuario(String emailUsuario) {
		this.emailUsuario = emailUsuario;
	}

	public List<ModelSenhasSalvas> getSenhasSalvas() {
		return senhasSalvas;
	}

	public void setSenhasSalvas(List<ModelSenhasSalvas> senhasSalvas) {
		this.senhasSalvas = senhasSalvas;
	}

	public void salvarSenha(ModelSenhasSalvas senha) {
		this.getSenhasSalvas().add(senha);
	}

	public void excluirSenha(ModelSenhasSalvas senha) {
		this.senhasSalvas.remove(senha);
	}

	public boolean senhaJaExiste(ModelSenhasSalvas senha) {
		for(ModelSenhasSalvas senhas: this.senhasSalvas) {
			if(senha.equals(senhas)) {
				return true;
			}
		}
		
		return false;
	}
	
}
