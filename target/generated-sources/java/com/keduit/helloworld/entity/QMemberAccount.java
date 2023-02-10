package com.keduit.helloworld.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QMemberAccount is a Querydsl query type for MemberAccount
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMemberAccount extends EntityPathBase<MemberAccount> {

    private static final long serialVersionUID = 1447795563L;

    public static final QMemberAccount memberAccount = new QMemberAccount("memberAccount");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final NumberPath<Long> accountNum = createNumber("accountNum", Long.class);

    public final NumberPath<Long> memberBuyer = createNumber("memberBuyer", Long.class);

    public final NumberPath<Long> memberSeller = createNumber("memberSeller", Long.class);

    public final NumberPath<Long> payment = createNumber("payment", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> regDate = _super.regDate;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updateDate = _super.updateDate;

    public QMemberAccount(String variable) {
        super(MemberAccount.class, forVariable(variable));
    }

    public QMemberAccount(Path<? extends MemberAccount> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMemberAccount(PathMetadata metadata) {
        super(MemberAccount.class, metadata);
    }

}

