package rocha.guilherme.jose.model.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import rocha.guilherme.jose.model.ModelUsuario;
import rocha.guilherme.jose.servico.Criptografar;

public class UsuarioDAO {

	private final EntityManager em;
	
	public UsuarioDAO(EntityManager em) {
		this.em = em;
	}
	
    public ModelUsuario insert(ModelUsuario usuario){
        em.persist(usuario);
        return usuario;
    }
    
    public ModelUsuario update(ModelUsuario usuario){
       em.merge(usuario);
       return usuario;
    }
    
    public ModelUsuario insertOrUpdate(ModelUsuario usuario) {
		if(usuario.getId() > 0) {
			return update(usuario);
		}
		
		return insert(usuario);
	}

    public void delete(ModelUsuario usuario){
        em.merge(usuario);
        em.remove(usuario);
    }
    
    public List<ModelUsuario> selectAll(){
    	String jpql = "SELECT u FROM usuario as u";
    	Query query = em.createQuery(jpql);
        return consulta(query);
    }
    
    public ModelUsuario selectPorNomeOuEmailESenha(ModelUsuario usuario) {
    	String jpql = "SELECT u FROM usuario AS u WHERE u.nomeUsuario = :pUsuario AND u.senhaUsuario = :pSenha OR "
    			+ "u.emailUsuario = :pEmail AND u.senhaUsuario = :pSenha";
    	Query query = em.createQuery(jpql);
    	
    	query.setParameter("pUsuario", usuario.getNomeUsuario());
    	query.setParameter("pEmail", usuario.getEmailUsuario());
    	query.setParameter("pSenha", Criptografar.criptografar(usuario.getSenhaUsuario()));
    	
    	return consulta(query).isEmpty() ? null : consulta(query).get(0);
    }
    
    public ModelUsuario selectPorNome(ModelUsuario usuario) {
    	String jpql = "SELECT u FROM usuario as u WHERE u.nomeUsuario = :pUsuario";
    	Query query = em.createQuery(jpql);
    	
    	query.setParameter("pUsuario", usuario.getNomeUsuario());
    	
    	return consulta(query).isEmpty() ? null : consulta(query).get(0);
    }
    
    @SuppressWarnings("unchecked")
	private List<ModelUsuario> consulta(Query query) {
		List<ModelUsuario> usuarios;
		
		try {
			usuarios = query.getResultList();
		}catch(NoResultException e) {
			usuarios = new ArrayList<>();
		}
		
		return usuarios;
		
	}
    
}
