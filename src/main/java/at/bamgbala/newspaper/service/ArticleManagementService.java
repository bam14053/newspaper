/**
 * 
 */
package at.bamgbala.newspaper.service;

import at.bamgbala.newspaper.domain.Article;
import at.bamgbala.newspaper.domain.Author;
import at.bamgbala.newspaper.jparepository.ArticleRepository;

/**
 * @author abideen
 *
 */
public class ArticleManagementService {
	private ArticleRepository articleRepository;
	
	public void createNewArticle(Author author, String title, String text){
		Article ar = new Article(author, title, text);
		articleRepository.persist(ar);
	}
	
	public Article findArticleById(long id){
		return articleRepository.findById(id);
	}

}
