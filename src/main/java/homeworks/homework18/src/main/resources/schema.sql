CREATE TABLE if not exists users (
    'id' BIGSERIAL PRIMARY KEY,
    'fio' VARCHAR
);

CREATE TABLE if not exists orders (
    'id' BIGSERIAL PRIMARY KEY,
    'user_id' numeric foreign key,
    'order_date' date,
    'count_of_orders' numeric,
    'user_discount' numeric
);