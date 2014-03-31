/**
 * 
 */
package at.bamgbala.newspaper.jparepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author abideen
 * 
 */
public abstract class AbstractJPARepository<T> implements AnyRepo {
	protected final Logger logger = LoggerFactory.getLogger(getClass());

	public AbstractJPARepository() {
	}

	@PersistenceContext
	protected EntityManager entityManager;

	protected EntityManager entityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public abstract List<T> findAll();

	public abstract T findById(Long id);

	public void persist(T t) {
		logger.info("Persisiting the entity " + t.getClass().toString());
		entityManager.persist(t);
	}
}
