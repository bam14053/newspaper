/**
 * 
 */
package at.bamgbala.newspaper.jparepository;

import java.util.List;
import at.bamgbala.newspaper.domain.Article;

/**
 * @author abideen
 *
 */
public class ArticleRepository extends AbstractJPARepository<Article> {

	@Override
	public List<Article> findAll() {
		logger.debug("Listing all articles");
		return entityManager.createQuery("SELECT a FROM Article a",
				Article.class).getResultList();
	}

	@Override
	public Article findById(Long id) {
		return entityManager.find(Article.class, id);
	}

}
