package by.ita.je.service;

import by.ita.je.model.Manufacturer;

import java.util.List;

public interface IServiceManufacturer {

    Manufacturer create(Manufacturer manufacturer);

    List<Manufacturer> readAll();

    List<Manufacturer> readById(List<Long> id);

    Manufacturer update(Long id, Manufacturer manufacturer);

    void deleteById(Long id);

}
