
-- Получить все товары
SELECT * FROM product;

-- Получить всех покупателей
SELECT * FROM customer;

-- Получить все заказы с информацией о товаре и покупателе
SELECT o.id, p.description, c.full_name, o.order_date, o.quantity, (p.price * o.quantity) AS total_price
FROM order_table o
         JOIN product p ON o.product_id = p.id
         JOIN customer c ON o.customer_id = c.id;

-- Получить заказы за конкретную дату (2024-01-20)
SELECT * FROM order_table WHERE order_date = '2024-01-20';

-- Получить топ-5 самых дорогих товаров
SELECT * FROM product ORDER BY price DESC LIMIT 5;



-- Обновить цену товара с id=1
UPDATE product SET price = 59999.99 WHERE id = 1;

-- Увеличить количество товара с id=2 на 10 единиц
UPDATE product SET quantity = quantity + 10 WHERE id = 2;

-- Изменить имя покупателя с id=3
UPDATE customer SET full_name = 'Сидорова Анна Дмитриевна' WHERE id = 3;

-- 3. Удаление данных

BEGIN;
DELETE FROM order_table WHERE product_id = 10;
DELETE FROM product WHERE id = 10;
COMMIT;

-- Удалить все заказы покупателя с id=5
DELETE FROM order_table WHERE customer_id = 5;

-- Удалить всех покупателей без заказов
DELETE FROM customer WHERE id NOT IN (SELECT DISTINCT customer_id FROM order_table);


-- Получить общую выручку по дням
SELECT order_date, SUM(p.price * o.quantity) AS daily_revenue
FROM order_table o
         JOIN product p ON o.product_id = p.id
GROUP BY order_date
ORDER BY order_date;

-- Получить покупателей, купивших товары дороже 20000
SELECT DISTINCT c.id, c.full_name
FROM customer c
         JOIN order_table o ON c.id = o.customer_id
         JOIN product p ON o.product_id = p.id
WHERE p.price > 20000;

-- Получить самый популярный товар (по количеству заказов)
SELECT p.id, p.description, COUNT(o.id) AS order_count
FROM product p
         JOIN order_table o ON p.id = o.product_id
GROUP BY p.id, p.description
ORDER BY order_count DESC
LIMIT 1;