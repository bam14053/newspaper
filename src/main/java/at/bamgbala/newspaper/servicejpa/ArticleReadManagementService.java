/**
 * 
 */
package at.bamgbala.newspaper.servicejpa;

import java.util.GregorianCalendar;

import at.bamgbala.newspaper.domain.Article;
import at.bamgbala.newspaper.domain.ArticleRead;
import at.bamgbala.newspaper.domain.RegularUser;
import at.bamgbala.newspaper.jparepository.ArticleReadJpaRepository;

/**
 * @author abideen
 * 
 */
public class ArticleReadManagementService {
	private ArticleReadJpaRepository articleReadRepository;

	public void articleRead(Article article, RegularUser user,
			GregorianCalendar readOn) {
		ArticleRead ar = new ArticleRead(article, user, readOn);
		articleReadRepository.persist(ar);
	}
}
