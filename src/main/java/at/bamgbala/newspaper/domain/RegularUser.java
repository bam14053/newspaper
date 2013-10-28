/**
 * 
 */
package at.bamgbala.newspaper.domain;


import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author abideen
 *
 */
@Entity
@Table(name = "u_users")
public class RegularUser extends User {

	private static final long serialVersionUID = -8123012255704604565L;
	
	@OneToMany(mappedBy = "user")
	private List<Article> articlesRead;

	/**
	 * @param firstname
	 * @param surname
	 * @param username
	 * @param password
	 * @param email
	 */
	public RegularUser(String firstname, String surname, String username,
			String password, String email) {
		super(firstname, surname, username, password, email);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the articlesRead
	 */
	public List<Article> getArticlesRead() {
		return articlesRead;
	}
		
}
