create table user (
    id       varchar(36)  not null primary key,
    email    varchar(255) not null,
    name     varchar(100) not null,
    password varchar(36)  not null
);

create table session (
    id      varchar(36) not null primary key,
    user_id varchar(36) not null references user (id)
);

create table document (
    id       varchar(36)  not null primary key,
    user_id  varchar(36)  not null references user (id),
    name     varchar(255) not null,
    contents blob         not null
);
