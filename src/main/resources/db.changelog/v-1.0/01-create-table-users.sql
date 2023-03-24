CREATE TABLE users
(
    id  serial PRIMARY KEY ,
    user_name TEXT,
    email TEXT,
    password TEXT,
    balance int,
    role TEXT,
    organization TEXT,

);