/**
 * 
 */
package at.bamgbala.newspaper.app;

import java.util.HashMap;

import javax.persistence.EntityManager;

import at.bamgbala.newspaper.jparepository.AnyRepo;
import at.bamgbala.newspaper.jparepository.ArticleReadJpaRepository;
import at.bamgbala.newspaper.jparepository.ArticleJpaRepository;
import at.bamgbala.newspaper.jparepository.CommentJpaRepository;
import at.bamgbala.newspaper.jparepository.PersistenceFactory;
import at.bamgbala.newspaper.jparepository.UserJpaRepository;

/**
 * @author abideen
 *
 */
public class PersistenceFactoryImpl implements PersistenceFactory {
	private final HashMap<Class<?>, AnyRepo> repos = new HashMap<>();
	
	public PersistenceFactoryImpl(EntityManager entityManager){
		/*
		 * Initializing all repos
		 */
		UserJpaRepository userRepository = new UserJpaRepository();
		userRepository.setEntityManager(entityManager);
		repos.put(UserJpaRepository.class, userRepository);
		
		ArticleJpaRepository articleRepository = new ArticleJpaRepository();
		articleRepository.setEntityManager(entityManager);
		repos.put(ArticleJpaRepository.class, articleRepository);
		
		CommentJpaRepository commentRepository = new CommentJpaRepository();
		commentRepository.setEntityManager(entityManager);
		repos.put(CommentJpaRepository.class, commentRepository);
		
		ArticleReadJpaRepository articleReadRepository = new ArticleReadJpaRepository();
		articleReadRepository.setEntityManager(entityManager);
		repos.put(ArticleReadJpaRepository.class, articleReadRepository);
		
	}
	/* (non-Javadoc)
	 * @see at.bamgbala.newspaper.jparepository.PersistenceFactory#userRepository()
	 */
	@Override
	public UserJpaRepository userRepository() {
		return (UserJpaRepository)repos.get(UserJpaRepository.class);
	}

	/* (non-Javadoc)
	 * @see at.bamgbala.newspaper.jparepository.PersistenceFactory#articleRepository()
	 */
	@Override
	public ArticleJpaRepository articleRepository() {
		return (ArticleJpaRepository)repos.get(ArticleJpaRepository.class);
	}

	/* (non-Javadoc)
	 * @see at.bamgbala.newspaper.jparepository.PersistenceFactory#articleReadRepository()
	 */
	@Override
	public ArticleReadJpaRepository articleReadRepository() {
		return (ArticleReadJpaRepository)repos.get(ArticleReadJpaRepository.class);
	}

	/* (non-Javadoc)
	 * @see at.bamgbala.newspaper.jparepository.PersistenceFactory#commentRepository()
	 */
	@Override
	public CommentJpaRepository commentRepository() {
		return (CommentJpaRepository)repos.get(CommentJpaRepository.class);
	}

}
