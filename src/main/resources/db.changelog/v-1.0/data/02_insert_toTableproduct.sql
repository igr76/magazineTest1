-- Заполнение таблицы товаров
INSERT INTO product(
    id   , name , organization,  description, price, quantity, discount, categories )
VALUES
    ('ТВ1','IBM1','Good1',1111,2,15,'SHOES'),
    ('ТВ2','IBM1','Good1',1221,2,15,'SHOES'),
    ('ТВ3','IBM1','Good1',1141,2,15,'SHOES');

-- Вспомогательная таблица для списка отзывов
INSERT INTO public.product_list_of_reviews(
    shelter_id, index, list_if_reviews)
VALUES
    (1, 1, 'Нравится1'),
    (1, 2, 'Нравится2'),
    (1, 3, 'Нравится3');

-- Вспомогательная таблица для списка ключевых слов
INSERT INTO public.product_list_of_keyword(
    shelter_id, index, list_if_keyword)
VALUES
    (1, 1, 'телевизор1'),
    (1, 2, 'телевизор2'),
    (1, 3, 'телевизор3');

-- Вспомогательная таблица для списка характеристик товара
INSERT INTO public.product_list_of_specificstions(
    shelter_id, index, list_if_specificstions)
VALUES
    (1, 1, 'Новый1'),
    (1, 2, 'Новый2'),
    (1, 3, 'Новый3');

-- Вспомогательная таблица для списка оценок товара
INSERT INTO public.product_list_of_estimation(
    shelter_id, index, list_if_estimation)
VALUES
    (1, 1, 'Хороший1'),
    (1, 2, 'Хороший1'),
    (1, 3, 'Хороший1');