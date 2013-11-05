/**
 * 
 */
package at.bamgbala.newspaper.service;
import java.util.GregorianCalendar;

import at.bamgbala.newspaper.domain.Article;
import at.bamgbala.newspaper.domain.Author;
import at.bamgbala.newspaper.domain.Comment;
import at.bamgbala.newspaper.domain.RegularUser;
import at.bamgbala.newspaper.jparepository.CommentRepository;

/**
 * @author abideen
 *
 */
public class CommentManagementService {
	private CommentRepository commentRepo;
	
	public void createNewComment(Article article, Author author, RegularUser user, String text, GregorianCalendar writtenOn){		
		Comment c = new Comment(article, author, user, text, writtenOn);
		commentRepo.persist(c);
	}
	
	public Comment findCommentById(long id){
		return commentRepo.findById(id);
	}
}
