/**
 * 
 */
package at.bamgbala.newspaper.repository;

import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import at.bamgbala.newspaper.domain.Article;
import at.bamgbala.newspaper.domain.ArticleRead;
import at.bamgbala.newspaper.domain.RegularUser;

/**
 * @author abideen
 *
 */
@Repository
public interface ArticleReadRepository extends CrudRepository<ArticleRead, Long>{
	List<ArticleRead> findByArticle(Article article);
	List<ArticleRead> findByUser(RegularUser regularUser);
	List<ArticleRead> findByReadOn(GregorianCalendar date);
}