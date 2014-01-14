/**
 * 
 */
package at.bamgbala.newspaper.jparepository;

import java.util.List;
import at.bamgbala.newspaper.domain.Comment;

/**
 * @author abideen
 *
 */
public class CommentJpaRepository extends AbstractJPARepository<Comment> {
	
	@Override
	public List<Comment> findAll() {
		logger.debug("Listing all comments");
		return entityManager.createQuery("SELECT * FROM c_comments",
				Comment.class).getResultList();
	}

	@Override
	public Comment findById(Long id) {
		return entityManager.find(Comment.class, id);
	}
}
