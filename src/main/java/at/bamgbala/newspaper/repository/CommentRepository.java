/**
 * 
 */
package at.bamgbala.newspaper.repository;

import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import at.bamgbala.newspaper.domain.Article;
import at.bamgbala.newspaper.domain.Author;
import at.bamgbala.newspaper.domain.Comment;
import at.bamgbala.newspaper.domain.User;

/**
 * @author abideen
 *
 */
public interface CommentRepository extends CrudRepository<Comment, Long> {
	List<Comment> findByArticle(Article article);
	List<Comment> findByUser(User user);
	List<Comment> findByAuthor(Author author);
	List<Comment> findByWrittenOn(GregorianCalendar date);
}