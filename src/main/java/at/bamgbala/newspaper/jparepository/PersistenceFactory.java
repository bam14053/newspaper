/**
 * 
 */
package at.bamgbala.newspaper.jparepository;

/**
 * @author abideen
 *
 */
public interface PersistenceFactory {
	UserRepository userRepository();
	ArticleRepository articleRepository();
	ArticleReadRepository articleReadRepository();
	CommentRepository commentRepository();
}
