-- Заполнение таблицы организаций
INSERT INTO organization(
    name   , title , logotipe,  status )
VALUES
    ('IBM','ТВ1','rt1',true),
    ('IBM2','ТВ2','rt2',true),
    ('IBM3','ТВ3','rt3',true);
-- Вспомогательная таблица для списка продуктов организации
INSERT INTO public.list_if_products(
    product_id, index, list_if_products)
VALUES
    (1, 1, 'mouse1'),
    (1, 2, 'mouse2'),
    (1, 3, 'mouse3');