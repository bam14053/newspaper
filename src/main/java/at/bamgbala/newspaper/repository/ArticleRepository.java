/**
 * 
 */
package at.bamgbala.newspaper.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import at.bamgbala.newspaper.domain.Article;
import at.bamgbala.newspaper.domain.Author;

/**
 * @author abideen
 * 
 */
@Repository
public interface ArticleRepository extends ArticleRepositoryCustom,
		JpaRepository<Article, Long> {
	List<Article> findByAuthor(Author author);

	Article findByTitle(String title);
}