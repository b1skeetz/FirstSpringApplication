create table Medicines(
                          id serial8 primary key,
                          name varchar(50) not null,
                          date_buy date not null,
                          date_expire date not null,
                          category_id int8,
                          description varchar(80) not null,
                          foreign key (category_id) references Categories (id)
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

insert into Medicines (name, date_buy, date_expire, category_id, description) values ('Тонзилотрен', '2023-12-05', '2027-12-01', 1, 'Гомеопатические для горла'),
                                                                                   ('Нафтизин', '2023-10-21', '2025-04-01', 5, 'Капли в нос для снятия отёка');