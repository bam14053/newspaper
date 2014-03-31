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

import at.bamgbala.newspaper.Ensure;

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

	@ManyToOne(targetEntity = RegularUser.class)
	@JoinColumn(name = "userID")
	private RegularUser user;

	@ManyToOne(targetEntity = Author.class)
	@JoinColumn(name = "authorID")
	private Author author;

	@NotNull
	@Size(max = 200)
	@Column(name = "text", nullable = false, length = 200)
	private String text;

	@Column(name = "timespamp")
	private GregorianCalendar writtenOn;

	/**
	 * @param article
	 * @param author
	 * @param text
	 * @param writtenOn
	 */
	public Comment(Article article, Author author, String text,
			GregorianCalendar writtenOn) {
		super();
		Ensure.notNull("article", article);
		Ensure.notNull("author", author);
		Ensure.notEmpty("text", text);
		Ensure.notNull("writtenOn", writtenOn);
		this.article = article;
		this.author = author;
		this.text = text;
		this.writtenOn = writtenOn;
	}

	public Comment(Article article, RegularUser user, String text,
			GregorianCalendar writtenOn) {
		super();
		Ensure.notNull("article", article);
		Ensure.notNull("user", user);
		Ensure.notEmpty("text", text);
		Ensure.notNull("writtenOn", writtenOn);
		this.article = article;
		this.user = user;
		this.text = text;
		this.writtenOn = writtenOn;
	}

	protected Comment() {

	}

	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	/**
	 * @param text
	 *            the text to set
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
