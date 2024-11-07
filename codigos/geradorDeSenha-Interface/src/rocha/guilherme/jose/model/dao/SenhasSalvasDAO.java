package rocha.guilherme.jose.model.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import rocha.guilherme.jose.model.ModelGerarSenha;
import rocha.guilherme.jose.model.ModelSenhasSalvas;
import rocha.guilherme.jose.model.ModelUsuario;

public class SenhasSalvasDAO {

	private final EntityManager em;
	
	public SenhasSalvasDAO(EntityManager em) {
		this.em = em;
	}
	
	public ModelSenhasSalvas insert(ModelSenhasSalvas senha){
        em.persist(senha);
        return senha;
    }
	
	public ModelSenhasSalvas update(ModelSenhasSalvas senha){
		em.merge(senha);
		return senha;
	}
	
	public ModelSenhasSalvas insertOrUpdate(ModelSenhasSalvas senha) {
		if(senha.getId() > 0) {
			return update(senha);
		}
		
		return insert(senha);
	}
	
    public void delete(ModelSenhasSalvas senha){
    	em.merge(senha);
    	em.remove(senha);
    }

    public List<ModelSenhasSalvas> selectAll(ModelUsuario usuario){
       String jpql = "SELECT u FROM senhassalvas as u WHERE u.usuario = :pIdUsuario";
       Query query = em.createQuery(jpql);

       query.setParameter("pIdUsuario", usuario.getId());
   	
       return consulta(query);
    }

	public ModelSenhasSalvas senhaExiste(ModelGerarSenha senha){
        String jpql = "SELECT u FROM senhassalvas as u WHERE u.senha = :pSenha";
        Query query = em.createQuery(jpql);
        query.setParameter("pSenha", senha.getSenhaGerada());
        
        return consulta(query).isEmpty() ? null : consulta(query).get(0);
    }
    
	@SuppressWarnings("unchecked")
	private List<ModelSenhasSalvas> consulta(Query query) {
		List<ModelSenhasSalvas> senhasSalvas;
		
		try {
			senhasSalvas = query.getResultList();
		}catch(NoResultException e) {
			senhasSalvas = new ArrayList<>();
		}
		
		return senhasSalvas;
		
	}
}
