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

/*
 * private Enti	tyManagerFactory entitymf;
	private EntityManager entityManager;
	private HashMap<Class<?>, AnyRepo> repo = new HashMap<>();
	
	public void setup(){
		entitymf = Persistence.createEntityManagerFactory("newspaper");
		entityManager = entitymf.createEntityManager();
		entityManager.getTransaction().begin();		
	}
	
	public void close(){
		if (entityManager != null)
            entityManager.getTransaction().commit();
		if (entityManager != null)
            entityManager.close();
		if (entitymf != null)
            entitymf.close();
	}
	
	public AnyRepo anyRepo(){
		if(!repo.containsKey(UserRepository.class))
			repo.put(UserRepository.class, new UserRepository(entityManager));
		return (UserRepository) repo.get(UserRepository.class);
	}

 */
