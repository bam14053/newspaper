/**
 * 
 */
package at.bamgbala.newspaper.jparepository;

import java.util.List;

import at.bamgbala.newspaper.domain.Author;
import at.bamgbala.newspaper.domain.RegularUser;
import at.bamgbala.newspaper.domain.User;

/**
 * @author abideen
 * 
 */
public class UserJpaRepository extends AbstractJPARepository<User> {

	@Override
	public List<User> findAll() {
		logger.debug("Listing all users");
		List<User> users = entityManager.createQuery(
				"SELECT u from RegularUser u", User.class).getResultList();
		users.addAll(entityManager.createQuery("SELECT a from Author a",
				User.class).getResultList());
		return users;
	}

	@Override
	public User findById(Long id) {
		User result = entityManager.find(Author.class, id);
		if (result != null)
			return result;
		else
			return entityManager.find(RegularUser.class, id);
	}

}
