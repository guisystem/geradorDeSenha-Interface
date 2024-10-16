package rocha.guilherme.jose.model.dao;

import java.util.ArrayList;

import rocha.guilherme.jose.model.ModelUsuario;

public class UsuarioDAO {

	/**
     * Insere um usuario dentro do banco de dados
     * @param usuario exige que seja passado um objeto do tipo usuario
     */
    public void insert(ModelUsuario usuario){
        BancoDeDados.usuarios.add(usuario);
    }
    
    /**
     * Atualiza um usuario no banco de dados
     * @param usuario
     * @return verdadeiro caso atualize o usuário e false caso nao
     */
    public boolean update(ModelUsuario usuario){
        
        for (int i = 0; i < BancoDeDados.usuarios.size(); i++) {
            if(idSaoIguais(BancoDeDados.usuarios.get(i),usuario)){
            	BancoDeDados.usuarios.set(i, usuario);
                return true;
            }
        }
        return false;      

    }
    
    /**
     * Deleta um usuario do banco de dados pelo id do usuario passado
     * @param usuario
     * @return verdadeiro caso remova o usuário e false caso nao
     */
    public boolean delete(ModelUsuario usuario){
        for (ModelUsuario usuarioLista : BancoDeDados.usuarios) {
            if(idSaoIguais(usuarioLista,usuario)){
            	BancoDeDados.usuarios.remove(usuarioLista);
                return true;
            }
        }
        return false;
    }
    
    /**
     * Retorna um arraylist com todos os usuarios do banco de dados
     * @return uma lista com todos os registros de usuario do banco
     */
    public ArrayList<ModelUsuario> selectAll(){
        return BancoDeDados.usuarios;
    }
    
    /**
     * Retorna um Objeto do tipo usuario se a funcao encontrar o usuario 
     * passado como parametro no banco, para considerar sao usado nome, email e senha
     * @param usuario
     * @return Usuario encontrado no banco de dados
     */
    public ModelUsuario selectPorNomeOuEmailESenha(ModelUsuario usuario){
        for (ModelUsuario usuarioLista : BancoDeDados.usuarios) {
            if(nomeOuEmailESenhaSaoIguais(usuarioLista,usuario)){
                return usuarioLista;
            }
        }
        return null;
    }
    
    /**
     * Retorna um usuario caso existe um nome de usuario já existente no banco
     * @param usuario
     * @return Usuario com nome de usuário igual no banco de dados
     */
    public ModelUsuario selectPorNome(ModelUsuario usuario) {
    	for (ModelUsuario usuarioCadastrado: BancoDeDados.usuarios) {
    		if(NomeUsuarioIguais(usuarioCadastrado, usuario)) {
    			return usuarioCadastrado;
    		}
    	}
    	
    	return null;
    }
    
    /**
     * Recebe dois objetos e verifica se sao iguais verificando o nome, email e senha
     * @param usuario
     * @param usuarioAPesquisar
     * @return verdadeiro caso sejam iguais e falso caso nao forem iguais
     */
    private boolean nomeOuEmailESenhaSaoIguais(ModelUsuario usuario, ModelUsuario usuarioAPesquisar) {
        return usuario.getNomeUsuario().equals(usuarioAPesquisar.getNomeUsuario()) && 
        		usuario.getSenhaUsuario().equals(usuarioAPesquisar.getSenhaUsuario()) ||
        		usuario.getEmailUsuario().equals(usuarioAPesquisar.getEmailUsuario()) &&
        		usuario.getSenhaUsuario().equals(usuarioAPesquisar.getSenhaUsuario());
    }
    
    /**
     * Recebe dois objetos e verifica se sao iguais verificando o nome de usuario
     * @param usuario
     * @param usuarioAPesquisar
     * @return verdadeiro caso sejam iguais e falso caso nao forem iguais
     */
    private boolean NomeUsuarioIguais(ModelUsuario usuario, ModelUsuario usuarioApesquisar) {
    	 if(usuario.getNomeUsuario().equals(usuarioApesquisar.getNomeUsuario())){
    		 return true;
    	 }
    	 
    	 return false;
    }
    
    /**
     * Compara se dois objetos tem a propriedade id igual
     * @param usuario
     * @param usuarioAComparar
     * @return verdadeiro caso os id forem iguais e falso se nao forem
     */
    private boolean idSaoIguais(ModelUsuario usuario, ModelUsuario usuarioAComparar) {
        return usuario.getId() == usuarioAComparar.getId();
    }
    
}
