create table users
(
    id         serial8 primary key,
    role       int2    not null,
    username   varchar not null,
    password   varchar not null,
    first_name varchar not null,
    last_name  varchar not null
);

insert into users (role, username, password, first_name, last_name)
values (0, 'admin', 'admin', 'Admin', 'Admin');

drop table medicines;
create table medicines
(
    id          serial8 primary key,
    category_id int8        not null,
    display     bool        not null,
    name        varchar(50) not null,
    date_buy    date        not null,
    date_expire date        not null,
    description varchar(80) not null,
    price       int4    not null,
    foreign key (category_id) references categories (id)
);

create table categories
(
    id   serial8 primary key,
    name varchar(20) not null
);

insert into categories (name)
values ('Таблетки'),
       ('Капсулы'),
       ('Сироп'),
       ('Капли'),
       ('Спрей');