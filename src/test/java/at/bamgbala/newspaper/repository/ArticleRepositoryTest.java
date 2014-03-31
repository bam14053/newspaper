package at.bamgbala.newspaper.repository;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import at.bamgbala.newspaper.domain.Article;
import at.bamgbala.newspaper.domain.Author;

@ContextConfiguration(classes = RepositoryTestConfiguration.class)
public class ArticleRepositoryTest extends AbstractJUnit4SpringContextTests {
	@Autowired
	ArticleRepository articleRepository;
	@Autowired
	AuthorRepository authorRepository;
	Author author1;
	Author author2;
	Author author3;
	Article article1;
	Article article2;
	Article article3;

	@Before
	public void setup() {
		articleRepository.deleteAll();
		author1 = new Author("Abideen", "Bamgbala", "abi", "password",
				"abi@hotmail.com");
		author2 = new Author("Anil", "Guel", "gue", "passw2", "gue@hotmail.com");
		author3 = new Author("Loa", "Mol", "asd", "wdsds", "adsas@hotmail.com");
		article1 = new Article(author1, "First Article", "hadha");
		;
		article2 = new Article(author2, "Second Article", "hadha2");
		article3 = new Article(author3, "Third Article", "hadha3");
		authorRepository.save(author1);
		authorRepository.save(author2);
		authorRepository.save(author3);
		articleRepository.save(article1);
		articleRepository.save(article2);
		articleRepository.save(article3);
	}

	@After
	public void tearDown() throws Exception {
		articleRepository.deleteAll();
		authorRepository.deleteAll();
	}

	@Test
	public void testQueryJpaQuery() {
		List<Article> result = articleRepository.findWithJqaQuery(author1);

		Assert.assertNotNull(result);
		Assert.assertEquals(article1.getID(), result.get(0).getID());
		Assert.assertEquals(author1.getId(), result.get(0).getAuthor().getId());
	}

	@Test
	public void testQueryDslQuery() {
		List<Article> result = articleRepository.findWithQueryDsl(author1);

		Assert.assertNotNull(result);
		Assert.assertEquals(article1.getID(), result.get(0).getID());
		Assert.assertEquals(author1.getId(), result.get(0).getAuthor().getId());
	}

	@Test
	public void testQueryCriteriaApi() {
		List<Article> result = articleRepository.findWithCriteriaApi(author1);

		Assert.assertNotNull(result);
		Assert.assertEquals(article1.getID(), result.get(0).getID());
		Assert.assertEquals(author1.getId(), result.get(0).getAuthor().getId());
	}

	@Test
	public void testFindByAuthor() {
		Assert.assertEquals(3, articleRepository.count());
		Assert.assertEquals(article1.getID(),
				articleRepository.findByAuthor(author1).get(0).getID());
		Assert.assertEquals(article2.getID(),
				articleRepository.findByAuthor(author2).get(0).getID());
		Assert.assertEquals(article3.getID(),
				articleRepository.findByAuthor(author3).get(0).getID());
	}

	@Test
	public void testFindByTitle() {
		Assert.assertEquals(article1.getID(),
				articleRepository.findByTitle("First Article").getID());
		Assert.assertEquals(article2.getID(),
				articleRepository.findByTitle("Second Article").getID());
		Assert.assertEquals(article3.getID(),
				articleRepository.findByTitle("Third Article").getID());
	}

}
