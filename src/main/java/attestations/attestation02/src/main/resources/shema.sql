-- Создание таблицы товаров
CREATE TABLE IF NOT EXISTS product (
                                       id SERIAL PRIMARY KEY,
                                       description VARCHAR(255) NOT NULL,
                                       price DECIMAL(10, 2) NOT NULL,
                                       quantity INTEGER NOT NULL
);

-- Комментарии к таблице и колонкам (отдельные выражения)
COMMENT ON TABLE product IS 'Таблица товаров магазина';
COMMENT ON COLUMN product.description IS 'Наименование и описание товара';
COMMENT ON COLUMN product.price IS 'Стоимость товара за единицу';
COMMENT ON COLUMN product.quantity IS 'Количество товара на складе';

-- Таблица покупателей
CREATE TABLE IF NOT EXISTS customer (
                                        id SERIAL PRIMARY KEY,
                                        full_name VARCHAR(100) NOT NULL
);

COMMENT ON TABLE customer IS 'Таблица покупателей';
COMMENT ON COLUMN customer.full_name IS 'Полное имя покупателя';

-- Таблица заказов
CREATE TABLE IF NOT EXISTS order_table (
                                           id SERIAL PRIMARY KEY,
                                           product_id INTEGER NOT NULL,
                                           customer_id INTEGER NOT NULL,
                                           order_date DATE NOT NULL,
                                           quantity INTEGER NOT NULL,
                                           FOREIGN KEY (product_id) REFERENCES product(id),
                                           FOREIGN KEY (customer_id) REFERENCES customer(id)
);

COMMENT ON TABLE order_table IS 'Таблица заказов';
COMMENT ON COLUMN order_table.product_id IS 'ID товара';
COMMENT ON COLUMN order_table.customer_id IS 'ID покупателя';
COMMENT ON COLUMN order_table.order_date IS 'Дата заказа';
COMMENT ON COLUMN order_table.quantity IS 'Количество заказанного товара';

-- Заполнение таблиц тестовыми данными
INSERT INTO product (description, price, quantity) VALUES
                                                       ('Ноутбук ASUS VivoBook', 54999.99, 15),
                                                       ('Смартфон Xiaomi Redmi Note 11', 19999.90, 30),
                                                       ('Наушники Sony WH-1000XM4', 24999.00, 20),
                                                       ('Фитнес-браслет Xiaomi Mi Band 7', 3499.00, 50),
                                                       ('Монитор LG 27GL850', 42999.00, 10),
                                                       ('Клавиатура Logitech MX Keys', 8999.00, 25),
                                                       ('Мышь беспроводная Razer Basilisk', 5999.00, 40),
                                                       ('Внешний SSD Samsung T7 1TB', 10999.00, 18),
                                                       ('Роутер TP-Link Archer AX73', 12999.00, 12),
                                                       ('Игровая консоль PlayStation 5', 69999.00, 5);

INSERT INTO customer (full_name) VALUES
                                     ('Иванов Иван Иванович'),
                                     ('Петров Петр Петрович'),
                                     ('Сидорова Анна Михайловна'),
                                     ('Кузнецов Дмитрий Сергеевич'),
                                     ('Смирнова Елена Владимировна'),
                                     ('Васильев Андрей Николаевич'),
                                     ('Попова Ольга Игоревна'),
                                     ('Соколов Михаил Александрович'),
                                     ('Лебедева Татьяна Викторовна'),
                                     ('Козлов Артем Дмитриевич');

INSERT INTO order_table (product_id, customer_id, order_date, quantity) VALUES
                                                                            (1, 1, '2024-01-15', 1),
                                                                            (3, 2, '2024-01-16', 2),
                                                                            (5, 3, '2024-01-17', 1),
                                                                            (2, 4, '2024-01-18', 3),
                                                                            (4, 5, '2024-01-19', 5),
                                                                            (6, 6, '2024-01-20', 1),
                                                                            (7, 7, '2024-01-21', 2),
                                                                            (8, 8, '2024-01-22', 1),
                                                                            (9, 9, '2024-01-23', 1),
                                                                            (10, 10, '2024-01-24', 1);