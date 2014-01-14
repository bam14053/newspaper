package at.bamgbala.newspaper.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.mysema.query.jpa.impl.JPAQuery;

import at.bamgbala.newspaper.domain.Article;
import at.bamgbala.newspaper.domain.Author;
import at.bamgbala.newspaper.domain.QArticle;
import at.bamgbala.newspaper.repository.ArticleRepositoryCustom;

public class ArticleRepositoryImpl implements ArticleRepositoryCustom{
	@PersistenceContext
	EntityManager entityManager;

	@Override
	public List<Article> findWithQueryDsl(Author author) {
		JPAQuery query = new JPAQuery(entityManager);
		QArticle article = QArticle.article;		
		query.from(article).where(article.author.eq(author));
		return query.list(article);
	}

	@Override
	public List<Article> findWithJqaQuery(Author author) {
		return entityManager.createQuery("from Article where author = :author", Article.class).
				setParameter("author", author).
				getResultList();
	}

	@Override
	public List<Article> findWithCriteriaApi(Author author) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Article> query = builder.createQuery(Article.class);
        Root<Article> root = query.from(Article.class);
        Predicate buildingPredicate = builder.equal(root.get("author"), author);
        query.where(buildingPredicate);

        return entityManager.
                createQuery(query.select(root)).
                getResultList();
	}
	
	
}
