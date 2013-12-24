package at.bamgbala.newspaper.domain;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QArticleRead is a Querydsl query type for ArticleRead
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QArticleRead extends EntityPathBase<ArticleRead> {

    private static final long serialVersionUID = 1586007069;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QArticleRead articleRead = new QArticleRead("articleRead");

    public final QArticle article;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final ComparablePath<java.util.GregorianCalendar> readOn = createComparable("readOn", java.util.GregorianCalendar.class);

    public final QRegularUser user;

    public QArticleRead(String variable) {
        this(ArticleRead.class, forVariable(variable), INITS);
    }

    public QArticleRead(Path<? extends ArticleRead> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QArticleRead(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QArticleRead(PathMetadata<?> metadata, PathInits inits) {
        this(ArticleRead.class, metadata, inits);
    }

    public QArticleRead(Class<? extends ArticleRead> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.article = inits.isInitialized("article") ? new QArticle(forProperty("article"), inits.get("article")) : null;
        this.user = inits.isInitialized("user") ? new QRegularUser(forProperty("user")) : null;
    }

}

