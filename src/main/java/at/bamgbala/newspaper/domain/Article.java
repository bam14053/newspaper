package at.bamgbala.newspaper.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import at.bamgbala.newspaper.Ensure;

/**
 * @author abideen
 * The Article domain class, represents the a_articles table
 */
@Entity
@Table(name = "a_articles")
public class Article implements Serializable{
	private static final long serialVersionUID = 5384135838124701956L;
	
	@NotNull
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name = "articleID", nullable = false)
	private long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "writtenBy")
	private Author author;
	
	@OneToMany(targetEntity = Comment.class, mappedBy = "article")
	private List<Comment> comments;
	
	@OneToMany(targetEntity = ArticleRead.class, mappedBy = "article")
	private List<ArticleRead> articleRead;
	
	@Column(name = "title", length = 255)
	private String title;
	
	@Column(name = "text", length = 4000)
	private String text;

	/**
	 * @param author
	 * @param title
	 * @param text
	 */
	public Article(Author author, String title, String text) {
		super();
		Ensure.notNull("author", author);
		Ensure.notEmpty("title", title);
		Ensure.notEmpty("text", text);
		this.author = author;
		this.title = title;
		this.text = text;
	}

	protected Article(){
		
	}
	
	public long getID(){
		return id;
	}
	
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
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
	 * @return the author
	 */
	public Author getAuthor() {
		return author;
	}

	/**
	 * @return the comments
	 */
	public List<Comment> getComments() {
		return comments;
	}
	
}
