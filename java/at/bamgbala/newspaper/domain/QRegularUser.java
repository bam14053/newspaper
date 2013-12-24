package at.bamgbala.newspaper.domain;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QRegularUser is a Querydsl query type for RegularUser
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QRegularUser extends EntityPathBase<RegularUser> {

    private static final long serialVersionUID = -81941000;

    public static final QRegularUser regularUser = new QRegularUser("regularUser");

    public final QUser _super = new QUser(this);

    public final ListPath<ArticleRead, QArticleRead> articlesRead = this.<ArticleRead, QArticleRead>createList("articlesRead", ArticleRead.class, QArticleRead.class, PathInits.DIRECT2);

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

    public QRegularUser(String variable) {
        super(RegularUser.class, forVariable(variable));
    }

    public QRegularUser(Path<? extends RegularUser> path) {
        super(path.getType(), path.getMetadata());
    }

    public QRegularUser(PathMetadata<?> metadata) {
        super(RegularUser.class, metadata);
    }

}

