/**
 * 
 */
package at.bamgbala.newspaper.jparepository;

import java.util.List;
import at.bamgbala.newspaper.domain.User;

/**
 * @author abideen
 * 
 */
public class UserRepository extends AbstractJPARepository<User>{

	@Override
	public List<User> findAll() {
		logger.debug("Listing all users");
		return entityManager.createQuery("SELECT * FROM u_users, au_authors",
				User.class).getResultList();
	}

	@Override
	public User findById(Long id) {
		return entityManager.find(User.class, id);
	}

}
