--  таблица для списка организаций
CREATE TABLE organization
(
    name TEXT primary key,
    title TEXT,
    logotipe TEXT,
    status boolean
);
-- Вспомогательная таблица для списка продуктов организации
CREATE TABLE list_if_products
(
    product_id  bigint,
    index       bigint,
    list_if_products text
);