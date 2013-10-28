/**
 * 
 */
package at.bamgbala.newspaper.domain;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
/**
 * @author abideen
 *
 */
@Entity
@Table(name = "au_authors")
public class Author extends User {

	private static final long serialVersionUID = -8060876108716111805L;
	
	@OneToMany(targetEntity = Article.class, mappedBy = "author")
	private List<Article> articles ;	
	
	/**
	 * @param firstname
	 * @param surname
	 * @param username
	 * @param password
	 * @param email
	 */
	public Author(String firstname, String surname, String username,
			String password, String email) {
		super(firstname, surname, username, password, email);
		// TODO Auto-generated constructor stub
	}


	@Column(name = "amountOfArticles")
	private int amountOfArticles;
		
	
	/**
	 * @return The amount of articles the author has already written
	 */
	public int getAmountOfArticles() {
		return amountOfArticles;
	}	
	
}
