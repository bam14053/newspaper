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

import at.bamgbala.newspaper.Ensure;

/**
 * @author abideen
 *
 */
@Entity
@Table(name = "ar_articleRead")
public class ArticleRead implements Serializable {
	private static final long serialVersionUID = 6786575474486292837L;


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
	
	@Column(name = "timestamp")
	private GregorianCalendar readOn;

	/**
	 * @param article
	 * @param user
	 * @param readOn
	 */
	public ArticleRead(Article article, RegularUser user,
			GregorianCalendar readOn) {
		super();
		Ensure.notNull("article", article);
		Ensure.notNull("user", user);
		Ensure.notNull("readOn", readOn);
		this.article = article;
		this.user = user;
		this.readOn = readOn;
	}
	
	protected ArticleRead(){
		
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
	public RegularUser getUser() {
		return user;
	}

	/**
	 * @return the readOn
	 */
	public GregorianCalendar getReadOn() {
		return readOn;
	}
	
}
