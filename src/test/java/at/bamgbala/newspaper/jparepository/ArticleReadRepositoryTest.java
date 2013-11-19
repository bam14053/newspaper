package at.bamgbala.newspaper.jparepository;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import at.bamgbala.newspaper.domain.Article;
import at.bamgbala.newspaper.domain.ArticleRead;

public class ArticleReadRepositoryTest extends AbstractJPARepositoryTest {
	ArticleReadRepository articleReadRepository = new ArticleReadRepository();
	UserRepository userRepository = new UserRepository();	
	ArticleRepository articleRepository = new ArticleRepository();
	
	@Before
	public void setUp() {
		super.setUp();
		//Initialzing all neccessary repos
		articleReadRepository.setEntityManager(entityManager);
		articleRepository.setEntityManager(entityManager);
		userRepository.setEntityManager(entityManager);
	}

	@Test
	public void testFindByIdLong() {
	}

}
