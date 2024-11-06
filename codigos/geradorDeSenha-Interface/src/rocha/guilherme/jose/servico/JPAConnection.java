package rocha.guilherme.jose.servico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAConnection {

	 private static EntityManagerFactory emf;

	    public JPAConnection() {
	        if (emf == null) {
	            emf = Persistence.createEntityManagerFactory("mysql");
	        }
	    }
	    
	    public EntityManager getEntityManager() {
	            return emf.createEntityManager();
	    }

	    public JPAConnection(EntityManagerFactory factory) {
	        emf = factory;
	    }
}
