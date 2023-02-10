package com.keduit.helloworld.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QMessage is a Querydsl query type for Message
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMessage extends EntityPathBase<Message> {

    private static final long serialVersionUID = 395415359L;

    public static final QMessage message = new QMessage("message");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final StringPath content = createString("content");

    public final NumberPath<Long> memberGet = createNumber("memberGet", Long.class);

    public final NumberPath<Long> memberGive = createNumber("memberGive", Long.class);

    public final NumberPath<Long> messageNum = createNumber("messageNum", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> regDate = _super.regDate;

    public final StringPath title = createString("title");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updateDate = _super.updateDate;

    public final StringPath url = createString("url");

    public final NumberPath<Long> view = createNumber("view", Long.class);

    public QMessage(String variable) {
        super(Message.class, forVariable(variable));
    }

    public QMessage(Path<? extends Message> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMessage(PathMetadata metadata) {
        super(Message.class, metadata);
    }

}

