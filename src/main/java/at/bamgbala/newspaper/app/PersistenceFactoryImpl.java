/**
 * 
 */
package at.bamgbala.newspaper.app;

import java.util.HashMap;

import javax.persistence.EntityManager;

import at.bamgbala.newspaper.jparepository.AnyRepo;
import at.bamgbala.newspaper.jparepository.ArticleReadRepository;
import at.bamgbala.newspaper.jparepository.ArticleRepository;
import at.bamgbala.newspaper.jparepository.CommentRepository;
import at.bamgbala.newspaper.jparepository.PersistenceFactory;
import at.bamgbala.newspaper.jparepository.UserRepository;

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
		UserRepository userRepository = new UserRepository();
		userRepository.setEntityManager(entityManager);
		repos.put(UserRepository.class, userRepository);
		
		ArticleRepository articleRepository = new ArticleRepository();
		articleRepository.setEntityManager(entityManager);
		repos.put(ArticleRepository.class, articleRepository);
		
		CommentRepository commentRepository = new CommentRepository();
		commentRepository.setEntityManager(entityManager);
		repos.put(CommentRepository.class, commentRepository);
		
		ArticleReadRepository articleReadRepository = new ArticleReadRepository();
		articleReadRepository.setEntityManager(entityManager);
		repos.put(ArticleReadRepository.class, articleReadRepository);
		
	}
	/* (non-Javadoc)
	 * @see at.bamgbala.newspaper.jparepository.PersistenceFactory#userRepository()
	 */
	@Override
	public UserRepository userRepository() {
		return (UserRepository)repos.get(UserRepository.class);
	}

	/* (non-Javadoc)
	 * @see at.bamgbala.newspaper.jparepository.PersistenceFactory#articleRepository()
	 */
	@Override
	public ArticleRepository articleRepository() {
		return (ArticleRepository)repos.get(ArticleRepository.class);
	}

	/* (non-Javadoc)
	 * @see at.bamgbala.newspaper.jparepository.PersistenceFactory#articleReadRepository()
	 */
	@Override
	public ArticleReadRepository articleReadRepository() {
		return (ArticleReadRepository)repos.get(ArticleReadRepository.class);
	}

	/* (non-Javadoc)
	 * @see at.bamgbala.newspaper.jparepository.PersistenceFactory#commentRepository()
	 */
	@Override
	public CommentRepository commentRepository() {
		return (CommentRepository)repos.get(CommentRepository.class);
	}

}
