package at.bamgbala.newspaper.repository;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.mysema.query.jpa.impl.JPAQuery;

import at.bamgbala.newspaper.domain.Article;
import at.bamgbala.newspaper.domain.Author;

@ContextConfiguration(classes = RepositoryTestConfiguration.class)
public class WhenUsingQueryDslTest {
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
	
	@Before
	public void setup(){		
		author1 = new Author("Abideen", "Bamgbala", "abi", "password", "abi@hotmail.com");
		author2 = new Author("Anil", "Guel", "gue", "passw2", "gue@hotmail.com");
		author3 = new Author("Loa", "Mol", "asd", "wdsds", "adsas@hotmail.com");		
		article1 = new Article(author1, "First Article", "hadha");;
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
	}

	@Test
	public void testFindByTitle() {
		Assert.assertEquals(article1.getID(), articleRepository.findByTitle("First Article").getID());
		Assert.assertEquals(article2.getID(), articleRepository.findByTitle("Second Article").getID());
		Assert.assertEquals(article3.getID(), articleRepository.findByTitle("Third Article").getID());		
	}

}
