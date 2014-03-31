/**
 * 
 */
package at.bamgbala.newspaper.jparepository;

/**
 * @author abideen
 * 
 */
public interface PersistenceFactory {
	UserJpaRepository userRepository();

	ArticleJpaRepository articleRepository();

	ArticleReadJpaRepository articleReadRepository();

	CommentJpaRepository commentRepository();
}
