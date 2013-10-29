/**
 * 
 */
package at.bamgbala.newspaper.repository;

import java.util.HashMap;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author abideen
 *
 */
public class PersistenceFactory {
	private EntityManagerFactory entitymf;
	private EntityManager entityManager;
	private HashMap<Class<?>, AnyRepo> repo = new HashMap<>();
	
	public void setup(){
		entitymf = Persistence.createEntityManagerFactory("Newspaper");
		entityManager = entitymf.createEntityManager();
		entityManager.getTransaction().begin();		
	}
	
	public void close(){
		if (entityManager != null)
            entityManager.getTransaction().commit();
		if (entityManager != null)
            entityManager.close();
		if (entitymf != null)
            entitymf.close();
	}
	
	public UserRepository userRepo(){
		if(!repo.containsKey(UserRepository.class))
			repo.put(UserRepository.class, new UserRepository(entityManager));
		return (UserRepository) repo.get(UserRepository.class);
	}
	
	
}
