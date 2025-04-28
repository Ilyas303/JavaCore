CREATE TABLE IF NOT EXISTS televisions (
                                           id SERIAL PRIMARY KEY,
                                           model VARCHAR(255),
                                           manufacturer VARCHAR(255),
                                           screen_size INTEGER,
                                           resolution_width INTEGER,
                                           resolution_height INTEGER,
                                           smart_tv BOOLEAN,
                                           price DECIMAL(10,2)
);