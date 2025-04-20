CREATE TABLE IF NOT EXISTS televisions (
                                           id SERIAL PRIMARY KEY,
                                           model VARCHAR(255) NOT NULL,
                                           manufacturer VARCHAR(255) NOT NULL,
                                           screen_size DOUBLE PRECISION,
                                           resolution_width INTEGER,
                                           resolution_height INTEGER,
                                           smart_tv BOOLEAN,
                                           price DOUBLE PRECISION
);


