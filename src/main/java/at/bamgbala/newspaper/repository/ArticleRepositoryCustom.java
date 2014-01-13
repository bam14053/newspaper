package at.bamgbala.newspaper.repository;

import java.util.List;
import at.bamgbala.newspaper.domain.Article;
import at.bamgbala.newspaper.domain.Author;

public interface ArticleRepositoryCustom {
	List<Article> findWithQueryDsl(Author author);
    List<Article> findWithJqaQuery(Author author);	
    List<Article> findWithCriteriaApi(Author author);
}
