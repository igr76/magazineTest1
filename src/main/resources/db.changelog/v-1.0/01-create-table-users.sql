CREATE TABLE users
(
    id  serial PRIMARY KEY ,
    userName TEXT,
    email TEXT,
    password TEXT,
    balance int,
    role TEXT,
    organization TEXT,

);