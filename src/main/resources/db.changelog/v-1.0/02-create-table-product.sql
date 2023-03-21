--таблица для списка товаров
CREATE TABLE product
(
    id  integer generated always as identity primary key,
    name TEXT,
    organization TEXT,
    description TEXT,
    price int,
    quantity int,
    discount int,
    categories TEXT,
    constraint fk_organization_id foreign key (organization) references organization (name)
);
-- Вспомогательная таблица для списка отзывов
CREATE TABLE product_list_of_reviews
(
    product_id  bigint,
    index       bigint,
    list_if_reviews text
);
-- Вспомогательная таблица для списка ключевых слов
CREATE TABLE product_list_of_keyword
(
    product_id  bigint,
    index       bigint,
    list_if_keyword text
);
-- Вспомогательная таблица для списка характеристик товара
CREATE TABLE product_list_of_specificstions
(
    product_id  bigint,
    index       bigint,
    list_if_specificstions text
);
-- Вспомогательная таблица для списка оценок товара
CREATE TABLE product_list_of_estimation
(
    product_id  bigint,
    index       bigint,
    list_if_estimation int
);