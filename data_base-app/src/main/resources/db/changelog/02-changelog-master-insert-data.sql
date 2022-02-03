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