
CREATE TABLE IF NOT EXISTS users (
                                     id BIGINT PRIMARY KEY,
                                     fio VARCHAR
);

CREATE TABLE IF NOT EXISTS orders (
                                      id BIGINT PRIMARY KEY,
                                      user_id BIGINT NOT NULL,
                                      data_order DATE,
                                      number_orders BIGINT,
                                      buyer_discount BIGINT,
                                      CONSTRAINT fk_user FOREIGN KEY (user_id) REFERENCES users(id)
);

