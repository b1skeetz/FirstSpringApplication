create table Medicines(
                          id serial8 primary key,
                          name varchar(50) not null,
                          dateBuy date not null,
                          dateExpire date not null,
                          category int8,
                          description varchar(80) not null,
                          foreign key (category) references Categories (id)
);

create table Categories(
                           id serial8 primary key,
                           name varchar(20) not null
);

insert into Categories (name) values ('Таблетки'),
                                     ('Капсулы'),
                                     ('Сироп'),
                                     ('Мазь'),
                                     ('Наружнее применение');