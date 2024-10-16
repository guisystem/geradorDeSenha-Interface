package rocha.guilherme.jose.model.dao;

import java.util.ArrayList;

import rocha.guilherme.jose.model.ModelGerarSenha;
import rocha.guilherme.jose.model.ModelSenhasSalvas;

public class SenhasSalvasDAO {

	/**
     * Insere uma senha dentro do banco de dados
     * @param usuario exige que seja passado um objeto do tipo senha
     */
	public void insert(ModelSenhasSalvas senha){
        BancoDeDados.senhas.add(senha);
    }
    
	/**
     * Atualiza uma senha no banco de dados
     * @param senha
     * @return verdadeiro caso atualize a senha e false caso nao
     */
    public boolean update(ModelSenhasSalvas senha){
        
        for (int i = 0; i < BancoDeDados.senhas.size(); i++) {
            if(idSaoIguais(BancoDeDados.senhas.get(i), senha)){
            	BancoDeDados.senhas.set(i, senha);
                return true;
            }
        }
        return false;      

    }
	
    /**
     * Deleta uma senha do banco de dados pelo id da senha passado
     * @param senha
     * @return verdadeiro caso remova a senha e false caso nao
     */
    public boolean delete(ModelSenhasSalvas senha){
        for (ModelSenhasSalvas senhaLista : BancoDeDados.senhas) {
            if(idSaoIguais(senhaLista, senha)){
            	BancoDeDados.senhas.remove(senhaLista);
                return true;
            }
        }
        return false;
    }

    /**
     * Retorna um arraylist com todas as senhas do banco de dados
     * @return uma lista com todos os registros de senha do banco
     */
    public ArrayList<ModelSenhasSalvas> selectAll(){
        return BancoDeDados.senhas;
    }
    
    /**
     * Retorna uma senha salva do banco de dados caso exista
     * @param senha
     * @return senha caso exista uma senha igual ou null se nao existir
     */
    public ModelSenhasSalvas senhaExiste(ModelGerarSenha senha){
        for (ModelSenhasSalvas senhaLista : BancoDeDados.senhas) {
            if(senhaSaoIguais(senhaLista, senha)){
                return senhaLista;
            }
        }
        return null;
    }
    
    /**
     * Recebe dois objetos e verifica se sao iguais verificando a senha
     * @param senha
     * @param senhaAComparar
     * @return verdadeiro caso sejam iguais e falso caso nao forem iguais
     */
    private boolean senhaSaoIguais(ModelSenhasSalvas senha, ModelGerarSenha senhaAComparar) {
        return senha.getSenha().equals(senhaAComparar.getSenhaGerada());
    }

    /**
     * Compara se dois objetos tem a propriedade id igual
     * @param senha
     * @param senhaAComparar
     * @return verdadeiro caso os id forem iguais e falso se nao forem
     */
    private boolean idSaoIguais(ModelSenhasSalvas senha, ModelSenhasSalvas senhaAComparar) {
        return senha.getId() == senhaAComparar.getId();
    }
}
