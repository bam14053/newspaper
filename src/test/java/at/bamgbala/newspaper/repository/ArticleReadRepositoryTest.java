package at.bamgbala.newspaper.repository;

import java.util.GregorianCalendar;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import at.bamgbala.newspaper.domain.Article;
import at.bamgbala.newspaper.domain.ArticleRead;
import at.bamgbala.newspaper.domain.Author;
import at.bamgbala.newspaper.domain.RegularUser;
import at.bamgbala.newspaper.jparepository.UserRepository;

@ContextConfiguration(classes = RepositoryTestConfiguration.class)
public class ArticleReadRepositoryTest extends AbstractJUnit4SpringContextTests{
	@Autowired
	ArticleReadRepository articleReadRepository;	
	@Autowired
	ArticleRepository articleRepository;
	@Autowired
	RegularUserRepository regularUserRepository;
	@Autowired
	AuthorRepository authorRepository;
	
	
	Author user1;
	RegularUser user2;
	RegularUser user3;
	Article article1;
	ArticleRead articleRead;
	ArticleRead articleRead2;
	GregorianCalendar date = new GregorianCalendar();

	@Before
	public void setup(){
		user1 = new Author("Abideen", "Bamgbala", "abi", "password", "abi@hotmail.com");
		user2 = new RegularUser("Anil", "Guel", "gue", "passw2", "gue@hotmail.com");
		user3 = new RegularUser("Loa", "Mol", "asd", "wdsds", "adsas@hotmail.com");
		article1 = new Article(user1, "First Article", "hadha");		
		articleRead = new ArticleRead(article1,user2, date);
		articleRead2 = new ArticleRead(article1,user3, date);
		authorRepository.save(user1);
		regularUserRepository.save(user2);
		regularUserRepository.save(user3);
		articleRepository.save(article1);
		articleReadRepository.save(articleRead);
		articleReadRepository.save(articleRead2);
	}
	
	@After
	public void tearDown() throws Exception {
		articleReadRepository.deleteAll();
	}

	@Test
	public void testFindByArticle() {
		List<ArticleRead> result = articleReadRepository.findByArticle(article1);
		Assert.assertEquals(2, result.size());
	}

	@Test
	public void testFindByUser() {
		List<ArticleRead> result = articleReadRepository.findByUser(user2);
		Assert.assertEquals(1, result.size());
	}

	@Test
	public void testFindByReadOn() {
		List<ArticleRead> result = articleReadRepository.findByReadOn(date);
		Assert.assertEquals(2, result.size());
	}

}
