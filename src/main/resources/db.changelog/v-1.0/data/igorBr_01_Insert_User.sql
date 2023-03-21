INSERT INTO users (first_name, email,  password, balance, role, organization)
VALUES ('test_first_name1','test_email1',  'test_password_name1', '111111',
        'USER', 'IBM';

INSERT INTO users (email, first_name, password, balance, role, organization)
VALUES ('test_first_name2','test_email2',  'test_password_name2', '222222',
        'ADMIN', 'AS';

INSERT INTO users (email, first_name, password, balance, role, organization)
VALUES ('test_first_name3', 'test_email3', 'test_password_name3', '3333333',
        'USER', 'GTY';


--     id  serial PRIMARY KEY ,
--     email TEXT,
--     first_name TEXT,
--     last_name TEXT,
--     phone TEXT,
--     reg_date TIMESTAMP,
--     city TEXT,
--     image BYTEA