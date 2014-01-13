package at.bamgbala.newspaper.repository;

import java.util.Iterator;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import at.bamgbala.newspaper.domain.Author;

@ContextConfiguration(classes = RepositoryTestConfiguration.class)
public class AuthorRepositoryTest extends AbstractJUnit4SpringContextTests{
	@Autowired
	AuthorRepository authorRepository;

	@After
	public void tearDown() throws Exception {
		authorRepository.deleteAll();
	}
	
	@Before
	public void setup(){
		authorRepository.deleteAll();
	}
	
	@Test
	public void test() {
		Author user1 = new Author("Abideen", "Bamgbala", "abi", "password", "abi@hotmail.com");
		Author user2 = new Author("Anil", "Guel", "gue", "passw2", "gue@hotmail.com");
		Author user3 = new Author("Loa", "Mol", "asd", "wdsds", "adsas@hotmail.com");
		authorRepository.save(user1);
		authorRepository.save(user2);
		authorRepository.save(user3);
		
		//When
		Iterator<Author> authors = authorRepository.findAll().iterator();
		
		//Then
		Assert.assertEquals(3, authorRepository.count());
		Assert.assertEquals(authors.next().getFirstname(), user1.getFirstname());
		Assert.assertEquals(authors.next().getFirstname(), user2.getFirstname());
		Assert.assertEquals(authors.next().getFirstname(), user3.getFirstname());
	
	}

}
