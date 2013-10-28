/**
 * 
 */
package at.bamgbala.newspaper.domain;

import java.io.Serializable;
import java.util.GregorianCalendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author abideen
 *
 */
@Entity
@Table(name = "c_comments")
public class Comment implements Serializable {
	private static final long serialVersionUID = -4272361214748737596L;

	@Id
	@NotNull
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	private long id;
	
	@ManyToOne(targetEntity = Article.class)
	@JoinColumn(name = "articleID")
	private Article article;
	
	@ManyToOne(targetEntity = User.class)
	@JoinColumn(name = "userID")
	private User user;
	
	@NotNull
	@Size(max = 200)
	@Column(name = "text", nullable = false, length = 200)
	private String text;
	
	@Column(name = "timespamp")
	private GregorianCalendar writtenOn;

	/**
	 * @param article
	 * @param user
	 * @param text
	 * @param writtenOn
	 */
	public Comment(Article article, User user, String text,
			GregorianCalendar writtenOn) {
		super();
		this.article = article;
		this.user = user;
		this.text = text;
		this.writtenOn = writtenOn;
	}
	
	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	/**
	 * @param text the text to set
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * @return the article
	 */
	public Article getArticle() {
		return article;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @return the writtenOn
	 */
	public GregorianCalendar getWrittenOn() {
		return writtenOn;
	}

	
}
