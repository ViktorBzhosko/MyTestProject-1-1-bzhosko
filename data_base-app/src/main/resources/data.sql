drop table if exists LAPTOP;
drop table if exists MANUFACTURER;
drop table if exists PRINTER;
drop table if exists EMPLOYEE_DESCRIPTION;
drop table if exists PLACES;
drop table if exists MANUFACTURER_EMPLOYEE;

CREATE TABLE MANUFACTURER
(
    id                     long NOT NULL AUTO_INCREMENT,
    name_of_company        varchar,
    location_city          varchar,
    stuff_number           INT,
    tax_number             INT,
    foreign_capital        BOOLEAN,
    number_of_stockholders INT,
    date_of_creation       datetime DEFAULT sysdate(),
    PRIMARY KEY (id)
);

CREATE TABLE LAPTOP
(
    laptop_id         long NOT NULL AUTO_INCREMENT,
    name              varchar,
    weight_kg         DOUBLE,
    serial_number     INT,
    name_of_processor varchar,
    usb_charging      BIT,
    touch_pad         BIT,
    sales_date        datetime DEFAULT sysdate(),
    manufacturer_id   long,
    PRIMARY KEY (laptop_id),
    FOREIGN KEY (manufacturer_id) REFERENCES MANUFACTURER (id)
);

CREATE TABLE PRINTER
(
    id                   long AUTO_INCREMENT,
    name                 varchar,
    colour               varchar,
    serial_number        INT,
    price                DOUBLE,
    wifi_direct          BIT,
    colour_print         BIT,
    laptop_laptop_id     long,
    laptop_id            long,
    production_date_time datetime DEFAULT sysdate(),
    PRIMARY KEY (id),
    FOREIGN KEY (laptop_id) REFERENCES LAPTOP (laptop_id)
);

CREATE TABLE PLACES
(
    id            long NOT NULL AUTO_INCREMENT,
    place_of_sale varchar(40),
    PRIMARY KEY (id)
);

CREATE TABLE EMPLOYEE_DESCRIPTION
(
    id              long NOT NULL AUTO_INCREMENT,
    first_name      varchar,
    position        varchar,
    years_old       INT,
    marriage        BIT,
    driver_licence  BIT,
    salary          INT,
    employment_date datetime DEFAULT sysdate(),
    places_id       long,
    PRIMARY KEY (id),
    FOREIGN KEY (places_id) REFERENCES PLACES (id)
);
ALTER TABLE PLACES
    ADD COLUMN employee_description_id long REFERENCES EMPLOYEE_DESCRIPTION (id);

CREATE TABLE MANUFACTURER_EMPLOYEE
(
    id                      long NOT NULL,
    employee_description_id long NOT NULL,
    PRIMARY KEY (id, employee_description_id),
    FOREIGN KEY (id) REFERENCES MANUFACTURER (id),
    FOREIGN KEY (employee_description_id) REFERENCES EMPLOYEE_DESCRIPTION (id)
);

INSERT INTO MANUFACTURER (name_of_company, location_city, stuff_number, tax_number, foreign_capital,
                          number_of_stockholders, date_of_creation)
VALUES ('ASUSTeK', 'Shanghai', 40000, 2021, true, 5, now());
INSERT INTO MANUFACTURER (name_of_company, location_city, stuff_number, tax_number, foreign_capital,
                          number_of_stockholders, date_of_creation)
VALUES ('Lenovo Group', 'Beijing', 50000, 2022, true, 4, now());
INSERT INTO MANUFACTURER (name_of_company, location_city, stuff_number, tax_number, foreign_capital,
                          number_of_stockholders, date_of_creation)
VALUES ('Hp Inc.', 'Palo Alto', 45000, 2023, true, 3, now());

INSERT INTO LAPTOP (name, weight_kg, serial_number, name_of_processor, usb_charging, touch_pad, sales_date,
                    manufacturer_id)
VALUES ('ASUS', 2.2, 2020, 'AMD', false, true, now(), 1);
INSERT INTO LAPTOP (name, weight_kg, serial_number, name_of_processor, usb_charging, touch_pad, sales_date,
                    manufacturer_id)
VALUES ('Lenovo', 2.3, 2021, 'Intel', true, true, now(), 2);
INSERT INTO LAPTOP (name, weight_kg, serial_number, name_of_processor, usb_charging, touch_pad, sales_date,
                    manufacturer_id)
VALUES ('Hp', 2.4, 2019, 'AMD', true, true, now(), 3);
INSERT INTO LAPTOP (name, weight_kg, serial_number, name_of_processor, usb_charging, touch_pad, sales_date,
                    manufacturer_id)
VALUES ('Hp', 2.4, 2019, 'AMD', true, true, now(), 3);
INSERT INTO LAPTOP (name, weight_kg, serial_number, name_of_processor, usb_charging, touch_pad, sales_date,
                    manufacturer_id)
VALUES ('Hp', 2.4, 2019, 'AMD', true, true, now(), 3);
INSERT INTO LAPTOP (name, weight_kg, serial_number, name_of_processor, usb_charging, touch_pad, sales_date,
                    manufacturer_id)
VALUES ('Hp', 2.4, 2019, 'AMD', true, true, now(), 3);
INSERT INTO LAPTOP (name, weight_kg, serial_number, name_of_processor, usb_charging, touch_pad, sales_date,
                    manufacturer_id)
VALUES ('Hp', 2.4, 2019, 'AMD', true, true, now(), 3);
INSERT INTO LAPTOP (name, weight_kg, serial_number, name_of_processor, usb_charging, touch_pad, sales_date,
                    manufacturer_id)
VALUES ('Hp', 2.4, 2019, 'AMD', true, true, now(), 3);
INSERT INTO LAPTOP (name, weight_kg, serial_number, name_of_processor, usb_charging, touch_pad, sales_date,
                    manufacturer_id)
VALUES ('Hp', 2.2, 2019, 'AMD', true, true, now(), 3);
INSERT INTO LAPTOP (name, weight_kg, serial_number, name_of_processor, usb_charging, touch_pad, sales_date,
                    manufacturer_id)
VALUES ('Hp', 2.6, 2019, 'AMD', true, true, now(), 3);
INSERT INTO LAPTOP (name, weight_kg, serial_number, name_of_processor, usb_charging, touch_pad, sales_date,
                    manufacturer_id)
VALUES ('Hp', 2.5, 2019, 'AMD', true, true, now(), 3);
INSERT INTO LAPTOP (name, weight_kg, serial_number, name_of_processor, usb_charging, touch_pad, sales_date,
                    manufacturer_id)
VALUES ('Hp', 2.4, 2019, 'AMD', true, true, now(), 3);
INSERT INTO LAPTOP (name, weight_kg, serial_number, name_of_processor, usb_charging, touch_pad, sales_date,
                    manufacturer_id)
VALUES ('Hp', 2.3, 2019, 'AMD', true, true, now(), 3);
INSERT INTO LAPTOP (name, weight_kg, serial_number, name_of_processor, usb_charging, touch_pad, sales_date,
                    manufacturer_id)
VALUES ('Hp', 2.5, 2019, 'AMD', true, true, now(), 3);


INSERT INTO PRINTER(name, colour, serial_number, price, wifi_direct, colour_print, laptop_id,
                    production_date_time)
VALUES ('Hp', 'black', 1227, 100.5, false, true, 1, now());
INSERT INTO PRINTER(name, colour, serial_number, price, wifi_direct, colour_print, laptop_id,
                    production_date_time)
VALUES ('Epson', 'black', 1533, 120.3, true, true, 2, now());
INSERT INTO PRINTER(name, colour, serial_number, price, wifi_direct, colour_print, laptop_id,
                    production_date_time)
VALUES ('Canon', 'white', 1229, 113.5, true, true, 3, now());

INSERT INTO PLACES(place_of_sale)
VALUES ('THE21VEK');
INSERT INTO PLACES(place_of_sale)
VALUES ('THE5ELEMENT');
INSERT INTO PLACES(place_of_sale)
VALUES ('ELECTROSILA');

INSERT INTO EMPLOYEE_DESCRIPTION (first_name, position, years_old, marriage, driver_licence, salary,
                                  employment_date, places_id)
VALUES ('Viktor', 'Salesman', 25, false, true, 700, now(), 1);
INSERT INTO EMPLOYEE_DESCRIPTION (first_name, position, years_old, marriage, driver_licence, salary,
                                  employment_date, places_id)
VALUES ('Andrey', 'Salesman', 28, true, true, 800, now(), 2);
INSERT INTO EMPLOYEE_DESCRIPTION (first_name, position, years_old, marriage, driver_licence, salary,
                                  employment_date, places_id)
VALUES ('Sergey', 'Manager', 30, true, true, 1000, now(), 3);

UPDATE PLACES
SET employee_description_id = 1
WHERE id = 1;
UPDATE PLACES
SET employee_description_id = 2
WHERE id = 2;
UPDATE PLACES
SET employee_description_id = 3
WHERE id = 3;

INSERT INTO MANUFACTURER_EMPLOYEE (id, employee_description_id)
VALUES (1, 1);
INSERT INTO MANUFACTURER_EMPLOYEE (id, employee_description_id)
VALUES (2, 2);
INSERT INTO MANUFACTURER_EMPLOYEE (id, employee_description_id)
VALUES (3, 3);

