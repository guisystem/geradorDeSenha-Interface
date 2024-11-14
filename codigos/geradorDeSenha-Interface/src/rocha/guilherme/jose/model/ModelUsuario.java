package rocha.guilherme.jose.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity(name = "usuario")
public class ModelUsuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false, unique = true)
	private String nomeUsuario;
	
	@Column(nullable = false, unique = true)
	private String emailUsuario;

	@Column(nullable = false)
	private String senhaUsuario;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "usuario")
	private List<ModelSenhasSalvas> senhasSalvas = new ArrayList<>();
	
	public ModelUsuario() {

	}
	
	public ModelUsuario(int id, String nomeUsuario, String emailUsuario, String senhaUsuario) {
		this.id = id;
		this.nomeUsuario = nomeUsuario;
		this.emailUsuario = emailUsuario;
		this.senhaUsuario = senhaUsuario;
	}

	public ModelUsuario(String nomeUsuario, String emailUsuario, String senhaUsuario) {
		this.nomeUsuario = nomeUsuario;
		this.emailUsuario = emailUsuario;
		this.senhaUsuario = senhaUsuario;
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
			if(senha.getSenha().equals(senhas.getSenha())) {
				return true;
			}
		}
		
		return false;
	}
	
}
