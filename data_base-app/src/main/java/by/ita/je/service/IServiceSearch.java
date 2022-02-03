package by.ita.je.service;

import by.ita.je.model.Laptop;

import java.util.List;

public interface IServiceSearch {

    List<Laptop> findByJPQL(String laptopName, String nameOfCompanyManufacturer);

}
