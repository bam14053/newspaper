/**
 * 
 */
package at.bamgbala.newspaper.repository;

import java.util.List;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import at.bamgbala.newspaper.domain.User;

/**
 * @author abideen
 * 
 */
public class UserRepository implements AnyRepo{
	private final Logger logger = LoggerFactory.getLogger(getClass());
	private final EntityManager entityManager;

	public UserRepository(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public List<User> findAll() {
		logger.debug("Listing all users");
		return entityManager.createQuery("SELECT * FROM u_users, au_authors",
				User.class).getResultList();
	}

	public User findById(Long id) {
		return entityManager.find(User.class, id);
	}

	public void persist(User user) {
		try{
			entityManager.persist(user);
			logger.info("Persisted the user with the ID:" + user.getId());
		}catch(EntityExistsException e){
			logger.error("Error persisting user: "+user.getId());
		}
	}

}
