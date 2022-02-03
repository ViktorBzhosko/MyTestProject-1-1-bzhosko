package by.ita.je.service;

import by.ita.je.model.Laptop;

import java.util.List;

public interface IServiceLaptop {

    Laptop create(Laptop laptop);

    List<Laptop> readAll();

    Laptop readById(Long id);

    Laptop update(Long id, Laptop laptop);

    void deleteById(Long id);

}
