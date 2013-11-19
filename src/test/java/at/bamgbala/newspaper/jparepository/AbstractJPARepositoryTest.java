/**
 * 
 */
package at.bamgbala.newspaper.jparepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author abideen
 * 
 */
public class AbstractJPARepositoryTest {
	protected final Logger logger = LoggerFactory.getLogger(getClass());
	protected EntityManagerFactory entityManagerFactory;
	protected EntityManager entityManager;

	@Before
	public void setUp() {
		entityManagerFactory = Persistence
				.createEntityManagerFactory("newspaperPU");
		entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() {
		if (entityManager != null)
			entityManager.getTransaction().commit();
		if (entityManager != null)
			entityManager.close();
		if (entityManagerFactory != null)
			entityManagerFactory.close();
	}

}
