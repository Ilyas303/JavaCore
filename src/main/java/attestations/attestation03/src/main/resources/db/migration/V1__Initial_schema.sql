CREATE TABLE users (
                       id BIGSERIAL PRIMARY KEY,
                       username VARCHAR(50) NOT NULL,
                       password VARCHAR(100) NOT NULL,
                       email VARCHAR(100) NOT NULL UNIQUE,
                       phone VARCHAR(20),
                       deleted BOOLEAN DEFAULT FALSE
);

CREATE TABLE services (
                          id BIGSERIAL PRIMARY KEY,
                          name VARCHAR(100) NOT NULL,
                          description TEXT,
                          price DECIMAL(10, 2) NOT NULL,
                          duration INTEGER NOT NULL
);

CREATE TABLE orders (
                        id BIGSERIAL PRIMARY KEY,
                        user_id BIGINT REFERENCES users(id),
                        service_id BIGINT REFERENCES services(id),
                        order_time TIMESTAMP NOT NULL,
                        status VARCHAR(20) NOT NULL,
                        deleted BOOLEAN DEFAULT FALSE
);
