/**
 * 
 */
package at.bamgbala.newspaper.app;

import at.bamgbala.newspaper.service.ArticleManagementService;
import at.bamgbala.newspaper.service.ArticleReadManagementService;
import at.bamgbala.newspaper.service.CommentManagementService;
import at.bamgbala.newspaper.service.ServiceFactory;
import at.bamgbala.newspaper.service.UserManagementService;

/**
 * @author abideen
 *
 */
public class ServiceFactoryImpl implements ServiceFactory {

	
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
