package at.bamgbala.newspaper.jparepository;
import org.junit.Assert;
import org.junit.Test;

import at.bamgbala.newspaper.domain.Author;
import at.bamgbala.newspaper.domain.RegularUser;
import at.bamgbala.newspaper.domain.User;
/**
 * @author abideen
 *
 */
public class UserRepositoryTest extends AbstractJPARepositoryTest{
	
	@Test
	public void verifyFindByID(){
		// Creation of entitiy manager and repository
		UserJpaRepository userRepository = new UserJpaRepository();
		userRepository.setEntityManager(entityManager);
		
		//Repo should be empty
		Assert.assertNull(userRepository.findById(1l));
		Assert.assertEquals(0,userRepository.findAll().size());
		
		User u = new RegularUser("Abideen", "Bamgbala", "abi", "password", "abi@spengergasse.at");
		userRepository.persist(u);
		User u1 = new Author("Anil", "Guelcehre", "anil", "anilpass", "anil@anil.com");
		userRepository.persist(u1);
		
		//We assert that two users have been added
		Assert.assertEquals(2, userRepository.findAll().size());
		//Object should be not null
		Assert.assertNotNull(userRepository.findById(u.getId()));
		Assert.assertNotNull(userRepository.findById(u1.getId()));
		
		Assert.assertEquals(u, userRepository.findById(u.getId()));
		Assert.assertEquals(u1, userRepository.findById(u1.getId()));
	}
}
