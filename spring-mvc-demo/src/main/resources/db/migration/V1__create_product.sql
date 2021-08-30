CREATE TABLE categories (
    id serial primary key,
    title text not null
);
CREATE TABLE product (
    id serial primary key,
    name text not null,
    price int not null,
    category_id int not null references categories (id)
);