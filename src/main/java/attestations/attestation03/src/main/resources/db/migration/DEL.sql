
DROP TABLE IF EXISTS orders, services, users;
DROP TABLE IF EXISTS databasechangelog, databasechangeloglock;




SELECT * FROM users;
SELECT * FROM services;
SELECT * FROM orders;


INSERT INTO users (id, username, password, email, phone, deleted)
VALUES (21,'kolya', '123', 'alt@mail.com', '+79161234567',false);


INSERT INTO services (id, name, description, price, duration)
VALUES (26,'michlen','235\110\85',12000,8) ;



INSERT INTO orders (ID, USER_ID, SERVICE_ID, ORDER_TIME, STATUS, DELETED)
VALUES (67,21,26,'2023-12-31','NEW',false) ;
