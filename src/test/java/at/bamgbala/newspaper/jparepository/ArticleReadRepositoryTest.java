package at.bamgbala.newspaper.jparepository;

import org.junit.Before;
import org.junit.Test;

public class ArticleReadRepositoryTest extends AbstractJPARepositoryTest {
	ArticleReadJpaRepository articleReadRepository = new ArticleReadJpaRepository();
	UserJpaRepository userRepository = new UserJpaRepository();	
	ArticleJpaRepository articleRepository = new ArticleJpaRepository();
	
	@Override
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
