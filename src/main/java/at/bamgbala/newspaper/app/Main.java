/**
 * 
 */
package at.bamgbala.newspaper.app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import at.bamgbala.newspaper.jparepository.PersistenceFactory;
import at.bamgbala.newspaper.servicejpa.ServiceJpaFactory;

/**
 * @author abideen
 * 
 */
public class Main {
	private EntityManagerFactory entitymf;
	private EntityManager entityManager;
	private PersistenceFactory persistenceFactory;
	private ServiceJpaFactory serviceFactory;

	public Main() {
		entitymf = Persistence.createEntityManagerFactory("newspaper");
		entityManager = entitymf.createEntityManager();
		persistenceFactory = new PersistenceFactoryImpl(entityManager);
		serviceFactory = new ServiceFactoryImpl(persistenceFactory);
	}
	
	

	public void close() {
		if (entityManager != null)
			entityManager.getTransaction().commit();
		if (entityManager != null)
			entityManager.close();
		if (entitymf != null)
			entitymf.close();
	}

}
