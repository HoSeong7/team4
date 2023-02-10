package com.keduit.helloworld.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QFavorites is a Querydsl query type for Favorites
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QFavorites extends EntityPathBase<Favorites> {

    private static final long serialVersionUID = 1691814799L;

    public static final QFavorites favorites = new QFavorites("favorites");

    public final NumberPath<Long> bookmarked = createNumber("bookmarked", Long.class);

    public final NumberPath<Long> bookmarker = createNumber("bookmarker", Long.class);

    public final NumberPath<Long> favoritesNum = createNumber("favoritesNum", Long.class);

    public QFavorites(String variable) {
        super(Favorites.class, forVariable(variable));
    }

    public QFavorites(Path<? extends Favorites> path) {
        super(path.getType(), path.getMetadata());
    }

    public QFavorites(PathMetadata metadata) {
        super(Favorites.class, metadata);
    }

}

