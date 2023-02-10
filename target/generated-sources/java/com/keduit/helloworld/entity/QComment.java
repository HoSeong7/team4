package com.keduit.helloworld.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QComment is a Querydsl query type for Comment
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QComment extends EntityPathBase<Comment> {

    private static final long serialVersionUID = 390888855L;

    public static final QComment comment = new QComment("comment");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final NumberPath<Long> boardCommentNum = createNumber("boardCommentNum", Long.class);

    public final NumberPath<Long> boardNum = createNumber("boardNum", Long.class);

    public final NumberPath<Long> clikes = createNumber("clikes", Long.class);

    public final StringPath commentContent = createString("commentContent");

    public final NumberPath<Long> price = createNumber("price", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> regDate = _super.regDate;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updateDate = _super.updateDate;

    public final StringPath url = createString("url");

    public final StringPath viewpicture = createString("viewpicture");

    public QComment(String variable) {
        super(Comment.class, forVariable(variable));
    }

    public QComment(Path<? extends Comment> path) {
        super(path.getType(), path.getMetadata());
    }

    public QComment(PathMetadata metadata) {
        super(Comment.class, metadata);
    }

}

