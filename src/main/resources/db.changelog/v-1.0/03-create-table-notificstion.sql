CREATE TABLE notification
(
    id  integer generated always as identity primary key,
    title TEXT,
    created_at TIMESTAMP,
    text TEXT,
);