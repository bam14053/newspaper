package at.bamgbala.newspaper.repository;

import java.util.List;

import at.bamgbala.newspaper.domain.Article;
import at.bamgbala.newspaper.domain.ArticleRead;
import at.bamgbala.newspaper.domain.User;

public interface ArticleReadRepositoryCustom {
    List<ArticleRead> findWithQueryDsl(Article article);
    List<ArticleRead> findWithJqlQuery(Article article);	
    List<ArticleRead> findWithCriteriaApi(Article article);
}
