/**
 * 
 */
package at.bamgbala.newspaper.domain;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import at.bamgbala.newspaper.Ensure;

/**
 * @author abideen
 * The Users domain class, represents the users Table. 
 * This class is a super user of {@code Author} and {@code RegularUser}
 */
@MappedSuperclass
public class User implements Serializable {
	private static final long serialVersionUID = -913788033579975348L;
	
	@Id
	@NotNull
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id", nullable = false)	
	private long id;		
	
	@Size(max = 255)
	@NotNull
	@Column(name = "firstname", nullable = false, length = 255)
	private String firstname;
	
	@Size(max = 255)
	@NotNull
	@Column(name = "surname", nullable = false, length = 255)
	private String surname;
	
	@Size(max = 255)
	@NotNull
	@Column(name = "username", nullable = false, length = 50)
	private String username;
	
	@Size(max = 255)
	@NotNull
	@Column(name = "password", nullable = false, length = 20)
	private String password;
	
	@Size(max = 255)
	@NotNull
	@Column(name = "email", nullable = false, length = 255)
	private String email;
	
	
	/**
	 * @param firstname
	 * @param surname
	 * @param username
	 * @param password
	 * @param email
	 */
	public User(String firstname, String surname, String username,
			String password, String email) {
		super();
		Ensure.notEmpty("firstname", firstname);
		Ensure.notEmpty("surname", surname);
		Ensure.notEmpty("username", username);
		Ensure.notEmpty("password", password);
		Ensure.notEmpty("email", email);
		this.firstname = firstname;
		this.surname = surname;
		this.username = username;
		this.password = password;
		this.email = email;
	}
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}
	/**
	 * @return the firstname
	 */
	public String getFirstname() {
		return firstname;
	}
	/**
	 * @param firstname the firstname to set
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	/**
	 * @return the surname
	 */
	public String getSurname() {
		return surname;
	}
	/**
	 * @param surname the surname to set
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the amountOfArticles
	 */
	
	
}
