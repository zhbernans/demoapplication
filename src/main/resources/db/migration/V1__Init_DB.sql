create table if not exists country
(
    id         serial primary key,
    short_name text not null,
    full_name  text not null,
    population bigint
);

create table if not exists region
(

    id         serial primary key,
    name       varchar not null,
    population bigint,
    country_id integer references country (id)
);

create table if not exists city
(
id         serial primary key,
name       varchar not null,
population bigint,
region_id  integer references region (id)
);

create table if not exists role
(
    id serial primary key,
    name varchar not null
);

create table if not exists account
(
    id serial primary key,
    username varchar not null,
    password varchar not null,
    role_id integer references role (id)
);
