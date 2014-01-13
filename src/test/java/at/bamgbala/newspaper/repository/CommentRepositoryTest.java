package at.bamgbala.newspaper.repository;

import java.util.GregorianCalendar;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.ClassesKey;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import at.bamgbala.newspaper.domain.Article;
import at.bamgbala.newspaper.domain.Author;
import at.bamgbala.newspaper.domain.Comment;
import at.bamgbala.newspaper.domain.RegularUser;

@ContextConfiguration(classes = RepositoryTestConfiguration.class)
public class CommentRepositoryTest extends AbstractJUnit4SpringContextTests{
	@Autowired
	CommentRepository commentRepository;
	@Autowired
	AuthorRepository authorRepository;
	@Autowired
	ArticleRepository articleRepository;
	@Autowired
	RegularUserRepository regularUserRepository;
	
	Author author;
	Article article;
	RegularUser regularUser;
	
	@After
	public void tearDown() throws Exception {
		commentRepository.deleteAll();
	}

	@Before
	public void setup(){
		author = new Author("Abideen", "Bamgbala", "abi", "hello", "bam14053@hotmail.com");
		article = new Article(author, "First Article", "BALABLA");
		regularUser = new RegularUser("B", "A", "abi", "ok", "bam@homail.com");
		authorRepository.save(author);		
		regularUserRepository.save(regularUser);
		articleRepository.save(article);
		commentRepository.save(new Comment(article, regularUser, "That is a good text", new GregorianCalendar(2012, 3, 5)));
		commentRepository.save(new Comment(article, author, "Thanks, for comments", new GregorianCalendar(2012, 3, 5)));
		commentRepository.save(new Comment(article, regularUser, "That is a good text again", new GregorianCalendar(2012, 3, 5)));
		commentRepository.save(new Comment(article, regularUser, "That is a good text", new GregorianCalendar(2013, 3, 6)));
		commentRepository.save(new Comment(article, author, "Thanks, for comments", new GregorianCalendar(2013, 3, 6)));
		commentRepository.save(new Comment(article, regularUser, "That is a good text again", new GregorianCalendar(2013, 3, 6)));
	}
	
	@Test
	public void testFindByArticle() {
		List<Comment> result = commentRepository.findByArticle(article);
		Assert.assertEquals(6, result.size());
	}

	@Test
	public void testFindByUser() {
		List<Comment> result = commentRepository.findByUser(regularUser);
		Assert.assertEquals(4, result.size());
	}

	@Test
	public void testFindByAuthor() {
		List<Comment> result = commentRepository.findByAuthor(author);
		Assert.assertEquals(2, result.size());
	}

	@Test
	public void testFindByWrittenOn() {
		List<Comment> result = commentRepository.findByWrittenOn(new GregorianCalendar(2012, 3, 5));
		Assert.assertEquals(3, result.size());
		result = commentRepository.findByWrittenOn(new GregorianCalendar(2013, 3, 6));
		Assert.assertEquals(3, result.size());
	}

}
