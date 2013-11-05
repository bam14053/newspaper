/**
 * 
 */
package at.bamgbala.newspaper.service;

/**
 * @author abideen
 *
 */
public interface ServiceFactory {
	UserManagementService userManagementService();
	ArticleManagementService articleManagementService();
	ArticleReadManagementService articleReadManagementService();
	CommentManagementService commentManagementService();
}
