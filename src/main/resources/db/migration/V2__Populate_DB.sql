insert into country (short_name, full_name, population)
values ('MLD', 'Moldova', 15000000),
       ('ROM', 'Romania', 40000000),
       ('ITA', 'Italy', 30000000),
       ('FRA', 'France', 50000000),
       ('GER', 'Germany', 60000000);


insert into region (name, country_id, population)
values ('Drochia region', 1, 400000),
       ('Balti region', 1, 300000),
       ('Valachia', 2, 10000000),
       ('Transylvania', 2, 8000000),
       ('Sicily', 3, 6000000),
       ('Campagnia', 3, 11000000),
       ('Provence', 4, 7000000),
       ('Bavaria', 5, 17000000),
       ('Bavfewfewa', 5, 17000000);;

insert into city (name, region_id, population)
values ('Drochia', 1, 13000),
       ('Tarigrad', 1, 4000),
       ('Balti', 2, 100000),
       ('Bucharest', 3, 1800000),
       ('Ploesti', 3, 225000),
       ('Deva', 4, 60000),
       ('Alba lulia', 4, 65000),
       ('Catania', 5, 320000),
       ('Messina', 5, 250000),
       ('Naples', 6, 3000000),
       ('Salerno', 6, 1100000),
       ('Marseille', 7, 1600000),
       ('Avignon', 7, 91000),
       ('Munich', 8, 1500000);


insert into role(name)
values ('Admin'),
       ('User');

insert into account(username, password, role_id)
values ('admin1', 'admin1pass', 1),
       ('admin2', 'admin2pass', 1),
       ('user1', 'user1pass', 2),
       ('user2', 'user2pass', 2);