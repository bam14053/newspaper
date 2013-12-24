package at.bamgbala.newspaper.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.mysema.query.jpa.impl.JPAQuery;

import at.bamgbala.newspaper.domain.Article;
import at.bamgbala.newspaper.domain.ArticleRead;
import at.bamgbala.newspaper.domain.Author;
import at.bamgbala.newspaper.repository.ArticleRepositoryCustom;

public class ArticleRepositoryImpl implements ArticleRepositoryCustom{
	@PersistenceContext
	EntityManager entityManager;

	@Override
	public List<Article> findWithQueryDsl(Author author) {
		JPAQuery query = new JPAQuery(entityManager);
		return null;
//		QArticle article = QArticle.article;
		
//		query.from(article).where(article.author.eq(author));
//		return query.list(article);
	}

	@Override
	public List<Article> findWithJqlQuery(Author author) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Article> findWithCriteriaApi(Author author) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
