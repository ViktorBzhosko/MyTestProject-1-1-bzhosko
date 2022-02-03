drop table if exists LAPTOP;
drop table if exists MANUFACTURER;
drop table if exists PRINTER;
drop table if exists EMPLOYEE_DESCRIPTION;
drop table if exists PLACES;
drop table if exists MANUFACTURER_EMPLOYEE;

CREATE TABLE MANUFACTURER
(
    id                     bigserial,
    name_of_company        varchar,
    location_city          varchar,
    stuff_number           INT,
    tax_number             INT,
    foreign_capital        BOOLEAN,
    number_of_stockholders INT,
    date_of_creation       date,
    PRIMARY KEY (id)
);

CREATE TABLE LAPTOP
(
    laptop_id         bigserial,
    name              varchar,
    weight_kg         double precision,
    serial_number     INT,
    name_of_processor varchar,
    usb_charging      BOOLEAN,
    touch_pad         BOOLEAN,
    sales_date        date,
    manufacturer_id   bigint,
    PRIMARY KEY (laptop_id),
    FOREIGN KEY (manufacturer_id) REFERENCES MANUFACTURER (id)
);

CREATE TABLE PRINTER
(
    id                   bigserial,
    name                 varchar,
    colour               varchar,
    serial_number        INT,
    price                double precision,
    wifi_direct          BOOLEAN,
    colour_print         BOOLEAN,
    laptop_laptop_id     bigint,
    laptop_id            bigint,
    production_date_time date,
    PRIMARY KEY (id),
    FOREIGN KEY (laptop_id) REFERENCES LAPTOP (laptop_id)
);

CREATE TABLE PLACES
(
    id            bigserial,
    place_of_sale varchar(40),
    PRIMARY KEY (id)
);

CREATE TABLE EMPLOYEE_DESCRIPTION
(
    id              bigserial,
    first_name      varchar,
    position        varchar,
    years_old       INT,
    marriage        BOOLEAN,
    driver_licence  BOOLEAN,
    salary          INT,
    employment_date date,
    places_id       bigint,
    PRIMARY KEY (id),
    FOREIGN KEY (places_id) REFERENCES PLACES (id)
);
ALTER TABLE PLACES
    ADD COLUMN employee_description_id bigint REFERENCES EMPLOYEE_DESCRIPTION (id);

CREATE TABLE MANUFACTURER_EMPLOYEE
(
    id                      bigint NOT NULL,
    employee_description_id bigint NOT NULL,
    PRIMARY KEY (id, employee_description_id),
    FOREIGN KEY (id) REFERENCES MANUFACTURER (id),
    FOREIGN KEY (employee_description_id) REFERENCES EMPLOYEE_DESCRIPTION (id)
);