/**
 * 
 */
package at.bamgbala.newspaper.servicejpa;

import org.springframework.beans.factory.annotation.Autowired;

import at.bamgbala.newspaper.domain.Article;
import at.bamgbala.newspaper.domain.Author;
import at.bamgbala.newspaper.jparepository.ArticleJpaRepository;

/**
 * @author abideen
 * 
 */
public class ArticleManagementService implements ServiceJPA {
	@Autowired
	private ArticleJpaRepository articleRepository;

	public void createNewArticle(Author author, String title, String text) {
		Article ar = new Article(author, title, text);
		articleRepository.persist(ar);
	}

	public Article findArticleById(long id) {
		return articleRepository.findById(id);
	}

}
