package com.keduit.helloworld.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QCheckLike is a Querydsl query type for CheckLike
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCheckLike extends EntityPathBase<CheckLike> {

    private static final long serialVersionUID = -419568137L;

    public static final QCheckLike checkLike = new QCheckLike("checkLike");

    public final NumberPath<Long> checklikeId = createNumber("checklikeId", Long.class);

    public final NumberPath<Long> commentId = createNumber("commentId", Long.class);

    public final NumberPath<Long> likebool = createNumber("likebool", Long.class);

    public QCheckLike(String variable) {
        super(CheckLike.class, forVariable(variable));
    }

    public QCheckLike(Path<? extends CheckLike> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCheckLike(PathMetadata metadata) {
        super(CheckLike.class, metadata);
    }

}

