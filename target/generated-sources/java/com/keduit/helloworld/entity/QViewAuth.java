package com.keduit.helloworld.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QViewAuth is a Querydsl query type for ViewAuth
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QViewAuth extends EntityPathBase<ViewAuth> {

    private static final long serialVersionUID = 1030359477L;

    public static final QViewAuth viewAuth = new QViewAuth("viewAuth");

    public final NumberPath<Long> boardCommentNum = createNumber("boardCommentNum", Long.class);

    public final StringPath viewid = createString("viewid");

    public final NumberPath<Long> viewMemberNum = createNumber("viewMemberNum", Long.class);

    public QViewAuth(String variable) {
        super(ViewAuth.class, forVariable(variable));
    }

    public QViewAuth(Path<? extends ViewAuth> path) {
        super(path.getType(), path.getMetadata());
    }

    public QViewAuth(PathMetadata metadata) {
        super(ViewAuth.class, metadata);
    }

}

