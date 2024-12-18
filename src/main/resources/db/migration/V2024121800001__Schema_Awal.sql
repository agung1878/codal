create table c_security_permission
(
    created          timestamp(6),
    modified         timestamp(6),
    id               varchar(36)  not null,
    permission_label varchar(100) not null,
    permission_value varchar(100) not null,
    created_by       varchar(255),
    modified_by      varchar(255),
    primary key (id)
);
create table c_security_role
(
    created     timestamp(6),
    modified    timestamp(6),
    name        varchar(15)  not null unique,
    id          varchar(36)  not null,
    description varchar(100),
    created_by  varchar(255),
    modified_by varchar(255),
    user_type   varchar(255) not null check (user_type in ('ADMIN', 'MEMBER')),
    primary key (id)
);
create table c_security_role_permission
(
    id_permission VARCHAR(36) not null,
    id_role       VARCHAR(36) not null,
    primary key (id_permission, id_role)
);
create table c_security_user
(
    active      boolean     not null,
    created     timestamp(6),
    modified    timestamp(6),
    phone       varchar(15) not null,
    id          varchar(36) not null,
    id_role     varchar(36) not null,
    email       varchar(50) not null,
    username    varchar(50) not null,
    created_by  varchar(255),
    modified_by varchar(255),
    primary key (id)
);
create table c_security_user_password
(
    created       timestamp(6),
    modified      timestamp(6),
    id_user       varchar(36)  not null,
    created_by    varchar(255),
    modified_by   varchar(255),
    user_password varchar(255) not null,
    primary key (id_user)
);
create table country
(
    created     timestamp(6),
    modified    timestamp(6),
    id          varchar(36) not null,
    code        varchar(255),
    created_by  varchar(255),
    modified_by varchar(255),
    name        varchar(255),
    primary key (id)
);
create table group_member
(
    created     timestamp(6),
    modified    timestamp(6),
    id          varchar(36)  not null,
    name        varchar(50)  not null,
    created_by  varchar(255),
    description varchar(255) not null,
    modified_by varchar(255),
    primary key (id)
);
create table group_membership
(
    is_admin        boolean     not null,
    created         timestamp(6),
    modified        timestamp(6),
    group_member_id varchar(36) not null,
    id              varchar(36) not null,
    member_id       varchar(36) not null,
    created_by      varchar(255),
    modified_by     varchar(255),
    primary key (id)
);
create table member
(
    created         timestamp(6),
    modified        timestamp(6),
    country_id      varchar(36) not null unique,
    id              varchar(36) not null,
    user_id         varchar(36) unique,
    first_name      varchar(50) not null,
    last_name       varchar(50) not null,
    work_place      varchar(100),
    address         varchar(255),
    bio             varchar(255),
    created_by      varchar(255),
    img_profile_url varchar(255),
    modified_by     varchar(255),
    primary key (id)
);
create table mutual
(
    created             timestamp(6),
    modified            timestamp(6),
    id                  varchar(36) not null,
    member_id           varchar(36) not null,
    mutual_member_id    varchar(36) not null,
    created_by          varchar(255),
    modified_by         varchar(255),
    relationship_status varchar(255) check (relationship_status in ('FRIEND', 'PARTNER', 'FAMILY', 'COLLEAGUE')),
    primary key (id)
);
alter table if exists c_security_role_permission
    add constraint FKnqcv2qdac1phe20qqnyi6n1n
    foreign key (id_permission)
    references c_security_permission;
alter table if exists c_security_role_permission
    add constraint FKg9os4isbs19ssfahravousxes
    foreign key (id_role)
    references c_security_role;
alter table if exists c_security_user
    add constraint FKe5ychpyk27l8vj47v36mrn0s1
    foreign key (id_role)
    references c_security_role;
alter table if exists c_security_user_password
    add constraint FK80arji7i1u0styufcy8b91it5
    foreign key (id_user)
    references c_security_user;
alter table if exists group_membership
    add constraint FKbwf8u8eygse1qnftgfd395a4a
    foreign key (group_member_id)
    references group_member;
alter table if exists group_membership
    add constraint FKtgwkrhvtwyun4a1j1lna033t6
    foreign key (member_id)
    references member;
alter table if exists member
    add constraint FKimgxpbvyco1xw2gw8nia3f9kv
    foreign key (country_id)
    references country;
alter table if exists member
    add constraint FKjor6snhrwpvmkd0n3romup0sh
    foreign key (user_id)
    references c_security_user;
alter table if exists mutual
    add constraint FKkkq0um0licb7fllafkafdr6e2
    foreign key (member_id)
    references member;
alter table if exists mutual
    add constraint FK2q40ijtgwx3y3egxqo4u2olv0
    foreign key (mutual_member_id)
    references member;