package com.keduit.helloworld.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QPointAccount is a Querydsl query type for PointAccount
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPointAccount extends EntityPathBase<PointAccount> {

    private static final long serialVersionUID = -1054368187L;

    public static final QPointAccount pointAccount = new QPointAccount("pointAccount");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final NumberPath<Long> balance = createNumber("balance", Long.class);

    public final NumberPath<Long> charge = createNumber("charge", Long.class);

    public final NumberPath<Long> exchange = createNumber("exchange", Long.class);

    public final NumberPath<Long> memberNum = createNumber("memberNum", Long.class);

    public final NumberPath<Long> pointNum = createNumber("pointNum", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> regDate = _super.regDate;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updateDate = _super.updateDate;

    public QPointAccount(String variable) {
        super(PointAccount.class, forVariable(variable));
    }

    public QPointAccount(Path<? extends PointAccount> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPointAccount(PathMetadata metadata) {
        super(PointAccount.class, metadata);
    }

}

