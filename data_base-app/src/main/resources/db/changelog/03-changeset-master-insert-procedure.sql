CREATE PROCEDURE select_data()
    LANGUAGE SQL
AS $$
SELECT name_of_processor FROM laptop ;
SELECT name_of_company from manufacturer;
$$;
