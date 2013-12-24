package at.bamgbala.newspaper.domain;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QAuthor is a Querydsl query type for Author
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QAuthor extends EntityPathBase<Author> {

    private static final long serialVersionUID = 1642791546;

    public static final QAuthor author = new QAuthor("author");

    public final QUser _super = new QUser(this);

    public final NumberPath<Integer> amountOfArticles = createNumber("amountOfArticles", Integer.class);

    public final ListPath<Article, QArticle> articles = this.<Article, QArticle>createList("articles", Article.class, QArticle.class, PathInits.DIRECT2);

    public final ListPath<Comment, QComment> comments = this.<Comment, QComment>createList("comments", Comment.class, QComment.class, PathInits.DIRECT2);

    //inherited
    public final StringPath email = _super.email;

    //inherited
    public final StringPath firstname = _super.firstname;

    //inherited
    public final NumberPath<Long> id = _super.id;

    //inherited
    public final StringPath password = _super.password;

    //inherited
    public final StringPath surname = _super.surname;

    //inherited
    public final StringPath username = _super.username;

    public QAuthor(String variable) {
        super(Author.class, forVariable(variable));
    }

    public QAuthor(Path<? extends Author> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAuthor(PathMetadata<?> metadata) {
        super(Author.class, metadata);
    }

}

