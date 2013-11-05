/**
 * 
 */
package at.bamgbala.newspaper.jparepository;

import java.util.List;
import at.bamgbala.newspaper.domain.ArticleRead;

/**
 * @author abideen
 *
 */
public class ArticleReadRepository extends AbstractJPARepository<ArticleRead> {

	@Override
	public List<ArticleRead> findAll() {
		logger.debug("Listing all users");
		return entityManager.createQuery("SELECT * FROM ar_articleRead",
				ArticleRead.class).getResultList();
	}

	@Override
	public ArticleRead findById(Long id) {
		return entityManager.find(ArticleRead.class, id);
	}

}
