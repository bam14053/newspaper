package at.bamgbala.newspaper.jparepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import at.bamgbala.newspaper.domain.Article;
import at.bamgbala.newspaper.domain.Author;
import at.bamgbala.newspaper.domain.User;

public class ArticleRepositoryTest extends AbstractJPARepositoryTest {
	ArticleRepository articleRepository = new ArticleRepository();
	UserRepository userRepository = new UserRepository();
	
	@Before
	public void setup(){
		super.setUp();	
		articleRepository.setEntityManager(entityManager);		
		//Because we need an author, we need to create a UserRepo too
		userRepository.setEntityManager(entityManager);		
	}
	
	@Test
	public void testFindByIdLong() {	
		//Create two authors and persist them
		User u = new Author("Abideen", "Bamgbala", "abi", "password", "abi@spengergasse.at");
		User u1 = new Author("Anil", "Guelcehre", "anil", "anilpass", "anil@anil.com");
		userRepository.persist(u);		
		userRepository.persist(u1);
	
		/*
		 * Articlerepo tests
		 */
		//Repo should be empty
		Assert.assertNull(articleRepository.findById(1l));
		Assert.assertEquals(0,articleRepository.findAll().size());
		
		
		Article a = new Article((Author)u, "Example","Example Article");
		articleRepository.persist(a);
		Article a1 = new Article((Author)u1, "Example","Example Article");
		articleRepository.persist(a1);
		
		//We assert that two articles have been added
		Assert.assertEquals(2, articleRepository.findAll().size());
		//Object should be not null
		Assert.assertNotNull(articleRepository.findById(a.getID()));
		Assert.assertNotNull(articleRepository.findById(a1.getID()));
		
		Assert.assertEquals(a, articleRepository.findById(a.getID()));
		Assert.assertEquals(a1, articleRepository.findById(a1.getID()));
	}

}
