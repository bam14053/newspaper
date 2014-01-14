/**
 * 
 */
package at.bamgbala.newspaper.servicejpa;

/**
 * @author abideen
 *
 */
public interface ServiceJpaFactory {
	UserManagementService userManagementService();
	ArticleManagementService articleManagementService();
	ArticleReadManagementService articleReadManagementService();
	CommentManagementService commentManagementService();
}
