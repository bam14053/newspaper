package at.bamgbala.newspaper.repository;
import java.util.Iterator;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import at.bamgbala.newspaper.domain.RegularUser;

@ContextConfiguration(classes = RepositoryTestConfiguration.class)
public class RegularUserRepositoryTest extends AbstractJUnit4SpringContextTests{
	@Autowired
	RegularUserRepository regularUserRepository;

	@After
	public void tearDown() throws Exception {
		regularUserRepository.deleteAll();
	}

	@Test
	public void test() {
		RegularUser user1 = new RegularUser("Abideen", "Bamgbala", "abi", "password", "abi@hotmail.com");
		RegularUser user2 = new RegularUser("Anil", "Guel", "gue", "passw2", "gue@hotmail.com");
		RegularUser user3 = new RegularUser("Loa", "Mol", "asd", "wdsds", "adsas@hotmail.com");
		regularUserRepository.save(user1);
		regularUserRepository.save(user2);
		regularUserRepository.save(user3);
		
		//When
		Iterator<RegularUser> findAll = regularUserRepository.findAll().iterator();
		
		//Then
		Assert.assertEquals(3, regularUserRepository.count());
		Assert.assertEquals(user1, findAll.next());
		Assert.assertEquals(user2, findAll.next());
		Assert.assertEquals(user3, findAll.next());
		
	}

}
