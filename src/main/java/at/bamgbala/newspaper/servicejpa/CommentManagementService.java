/**
 * 
 */
package at.bamgbala.newspaper.servicejpa;

import java.util.GregorianCalendar;

import at.bamgbala.newspaper.domain.Article;
import at.bamgbala.newspaper.domain.Author;
import at.bamgbala.newspaper.domain.Comment;
import at.bamgbala.newspaper.domain.RegularUser;
import at.bamgbala.newspaper.jparepository.CommentJpaRepository;

/**
 * @author abideen
 * 
 */
public class CommentManagementService {
	private CommentJpaRepository commentRepo;

	public void createNewComment(Article article, Author author,
			RegularUser user, String text, GregorianCalendar writtenOn) {
		Comment c;
		if (author == null)
			c = new Comment(article, user, text, writtenOn);
		else
			c = new Comment(article, author, text, writtenOn);
		commentRepo.persist(c);
	}

	public Comment findCommentById(long id) {
		return commentRepo.findById(id);
	}
}
