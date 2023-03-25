CREATE TABLE users
(
    id  integer generated always as identity primary key ,
    user_name TEXT,
    email TEXT,
    password TEXT,
    balance int,
    roles TEXT,
    organization TEXT
);