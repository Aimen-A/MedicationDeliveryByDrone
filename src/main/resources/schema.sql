--Table Creation-->
CREATE TABLE drone (
    id bigint NOT NULL AUTO_INCREMENT,
    update_date_time timestamp,
    create_date_time timestamp,
    weight_limit real,
    battery_capacity int,
    serial_no VARCHAR(100) UNIQUE,
    model int,
    state int,
    PRIMARY KEY (id)
);
CREATE TABLE medication (
    id bigint NOT NULL AUTO_INCREMENT,
    update_date_time timestamp,
    create_date_time timestamp,
    weight real,
    code VARCHAR(100) UNIQUE,
    name VARCHAR(50),
    image VARCHAR(100),
    PRIMARY KEY (id)
);
CREATE TABLE loaded_medication (
    id bigint NOT NULL AUTO_INCREMENT,
    update_date_time timestamp,
    create_date_time timestamp,
    is_active Boolean ,
    drone_id bigint,
    medication_id bigint,
    PRIMARY KEY (id),
    FOREIGN KEY (drone_id) REFERENCES drone (id),
    FOREIGN KEY (medication_id) REFERENCES medication (id)
);
