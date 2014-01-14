/**
 * 
 */
package at.bamgbala.newspaper.app;

import at.bamgbala.newspaper.jparepository.PersistenceFactory;
import at.bamgbala.newspaper.servicejpa.ArticleManagementService;
import at.bamgbala.newspaper.servicejpa.ArticleReadManagementService;
import at.bamgbala.newspaper.servicejpa.CommentManagementService;
import at.bamgbala.newspaper.servicejpa.ServiceJpaFactory;
import at.bamgbala.newspaper.servicejpa.UserManagementService;

/**
 * @author abideen
 *
 */
public class ServiceFactoryImpl implements ServiceJpaFactory {
	private PersistenceFactory persistenceFactory;
	
	public ServiceFactoryImpl(PersistenceFactory persistenceFactory){
		this.persistenceFactory = persistenceFactory;
	}
	
	/* (non-Javadoc)
	 * @see at.bamgbala.newspaper.service.ServiceFactory#userManagementService()
	 */
	@Override
	public UserManagementService userManagementService() {
		return new UserManagementService();
	}

	/* (non-Javadoc)
	 * @see at.bamgbala.newspaper.service.ServiceFactory#articleManagementService()
	 */
	@Override
	public ArticleManagementService articleManagementService() {
		return new ArticleManagementService();
	}

	/* (non-Javadoc)
	 * @see at.bamgbala.newspaper.service.ServiceFactory#articleReadManagementService()
	 */
	@Override
	public ArticleReadManagementService articleReadManagementService() {
		return new ArticleReadManagementService();
	}

	/* (non-Javadoc)
	 * @see at.bamgbala.newspaper.service.ServiceFactory#commentManagementService()
	 */
	@Override
	public CommentManagementService commentManagementService() {
		return new CommentManagementService();
	}

}
