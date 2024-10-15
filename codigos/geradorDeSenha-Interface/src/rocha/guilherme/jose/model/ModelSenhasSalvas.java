package rocha.guilherme.jose.model;

import java.util.Objects;

public class ModelSenhasSalvas {

	private int id;
	private String senha;
	private String descricao;
	private ModelUsuario usuario;
	
	public ModelSenhasSalvas() {
	
	}
	
	public ModelSenhasSalvas(int id, String senha, String descricao, ModelUsuario usuario) {
		this.id = id;
		this.senha = senha;
		this.descricao = descricao;
		this.usuario = usuario;
	}

	public ModelSenhasSalvas(String senha, String descricao, ModelUsuario usuario) {
		this.senha = senha;
		this.descricao = descricao;
		this.usuario = usuario;
	}
	
	public ModelSenhasSalvas(String senha, String descricao) {
		this.senha = senha;
		this.descricao = descricao;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public ModelUsuario getUsuario() {
		return usuario;
	}

	public void setUsuario(ModelUsuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public int hashCode() {
		return Objects.hash(senha);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ModelSenhasSalvas other = (ModelSenhasSalvas) obj;
		return Objects.equals(senha, other.senha);
	}
	
}
