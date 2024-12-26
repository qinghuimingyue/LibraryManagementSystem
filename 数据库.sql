create table book_info
(
    book_id          char(11)                   not null comment '书籍ID'
        primary key,
    book_name        varchar(150)               not null comment '书籍名',
    publishing       varchar(200)               not null comment '出版社',
    author           varchar(100)               not null comment '作者',
    status           varchar(10) default '在馆' not null comment '是否借出',
    intro            text                       null comment '简介',
    douban           int         default 0      null comment '豆瓣评分',
    review           text                       null comment '评论',
    publication_time date                       null comment '出版时间'
);

create table pending_librarian
(
    user_id        char(11)     not null comment '图书管理员ID'
        primary key,
    modify_project varchar(30)  not null comment '修改内容',
    user_name      varchar(100) null,
    gender         char(5)      null,
    birthday       date         null
)
    comment '未审核图书管理员信息';

create table user_information
(
    user_id         char(11)    not null comment '用户ID'
        primary key,
    user_name       varchar(50) not null comment '用户姓名',
    gender          char(5)     not null comment '性别',
    creat_date      date        not null comment '创建日期',
    birthday        date        null comment '出生日期',
    enrollment_date date        null,
    type            varchar(20) not null comment '身份'
);

create table borrowing_info
(
    book_id               char(11)      not null comment '图书ID',
    user_id               char(11)      not null comment '用户ID',
    borrow_date           datetime      not null comment '借出时间',
    estimated_return_date date          not null comment '预计归还时间',
    return_date           datetime      null comment '归还时间',
    status                int default 0 not null comment '审批状态，0未审批，1审批通过，-1为还书申请，-2为还书申请通过',
    primary key (book_id, user_id),
    constraint borrowing_info_book_info_book_id_fk
        foreign key (book_id) references book_info (book_id),
    constraint borrowing_info_user_information_user_id_fk
        foreign key (user_id) references user_information (user_id)
)
    comment '借阅信息';

create table collect_info
(
    user_id    char(11) not null,
    book_id    char(11) not null,
    creat_time datetime not null,
    primary key (user_id, book_id),
    constraint collect_info_book_info_book_id_fk
        foreign key (book_id) references book_info (book_id),
    constraint collect_info_user_information_user_id_fk
        foreign key (user_id) references user_information (user_id)
)
    comment '用户收藏记录';

create table password
(
    user_id  char(11)                     not null
        primary key,
    password varchar(30) default '123456' not null,
    constraint password_user_information_user_id_fk
        foreign key (user_id) references user_information (user_id)
)
    comment '密码表';


