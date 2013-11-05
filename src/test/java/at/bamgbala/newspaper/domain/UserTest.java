/**
 * 
 */
package at.bamgbala.newspaper.domain;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * @author abideen
 *
 */
public class UserTest {
	private EntityManager entityManager;
	private EntityManagerFactory entitymf;
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Before
	public void setup(){
		entitymf = Persistence.createEntityManagerFactory("newspaper");
		entityManager = entitymf.createEntityManager();
		entityManager.getTransaction().begin();
	}
	
	@After
	public void close(){
		if (entityManager != null)
            entityManager.getTransaction().commit();
		if (entityManager != null)
            entityManager.close();
		if (entitymf != null)
            entitymf.close();
	}
	
	@Test
	/**
	 * 	Create an author and a regular user and see whether it works 
	 */
	public void userTest(){		
		logger.info("Logging enabled");
		RegularUser ru = new RegularUser("Abideen", "Bamgbala", "abi", "hellO", "bam14053@hotmail.com");
		Author a = new Author("Abideen", "Bamgbala", "abi", "hellO", "bam14053@hotmail.com");
		entityManager.persist(a);
		entityManager.persist(ru);
		logger.info("Persisted the Users with id"+ru.getId()+" and "+a.getId());
	}
}
