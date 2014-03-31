package at.bamgbala.newspaper.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import at.bamgbala.newspaper.domain.Article;
import at.bamgbala.newspaper.domain.Author;
import at.bamgbala.newspaper.domain.QArticle;

import com.mysema.query.jpa.impl.JPAQuery;

@ContextConfiguration(classes = RepositoryTestConfiguration.class)
public class WhenUsingQueryDslTest extends AbstractJUnit4SpringContextTests {
	@PersistenceContext
	EntityManager entityManager;

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

	@After
	public void teardown() {
		articleRepository.deleteAll();
		authorRepository.deleteAll();
	}

	@Before
	public void setup() {
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

	@Test
	public void testFindByAuthor() {
		Assert.assertEquals(3, articleRepository.count());
		JPAQuery query = new JPAQuery(entityManager);
		QArticle article = QArticle.article;

		// First query
		query.from(article).where(article.author.eq(author1));
		Article result = query.singleResult(article);

		Assert.assertNotNull(result);
		Assert.assertEquals(article1.getID(), result.getID());
	}

	@Test
	public void testFindByTitle() {
		JPAQuery query = new JPAQuery(entityManager);
		QArticle article = QArticle.article;

		query.from(article).where(article.title.eq("First Article"));

		Article result = query.singleResult(article);

		Assert.assertNotNull(result);
		Assert.assertEquals(article1.getID(), result.getID());
	}

}
