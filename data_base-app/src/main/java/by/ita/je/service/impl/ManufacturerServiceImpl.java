package by.ita.je.service.impl;

import by.ita.je.dao.ManufacturerDao;
import by.ita.je.exception.DataIsIncorrectException;
import by.ita.je.exception.DataNotFoundException;
import by.ita.je.model.Manufacturer;
import by.ita.je.service.IServiceManufacturer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.ZonedDateTime;
import java.util.List;

@Service
public class ManufacturerServiceImpl implements IServiceManufacturer {

    private final ManufacturerDao manufacturerDao;

    @Autowired
    public ManufacturerServiceImpl(ManufacturerDao manufacturerDao) {
        this.manufacturerDao = manufacturerDao;
    }

    @Override
    @Transactional
    public Manufacturer create(Manufacturer manufacturer) {
        if (manufacturer.getNameOfCompany() == null || manufacturer.getLocationCity() == null) {
            throw new DataIsIncorrectException();
        } else if (manufacturer.getTaxNumber() == 0) {
            throw new DataIsIncorrectException();
        }
        manufacturer.setForeignCapital(manufacturer.isForeignCapital());
        manufacturer.setDateOfCreation(ZonedDateTime.now());
        manufacturer.setNumberOfStockholders(1);
        manufacturer.setStuffNumber(50);
        return manufacturerDao.save(manufacturer);
    }

    @Override
    public List<Manufacturer> readAll() {
        List<Manufacturer> foundedManufacturers = manufacturerDao.findAll();
        if (!foundedManufacturers.isEmpty()) return foundedManufacturers;
        else throw new DataNotFoundException();

    }

    @Override
    public List<Manufacturer> readById(List<Long> ids) {
        List<Manufacturer> foundedManufacturers = manufacturerDao.findAllById(ids);
        if (!foundedManufacturers.isEmpty()) return foundedManufacturers;
        else throw new DataNotFoundException();

    }

    @Override
    @Transactional
    public Manufacturer update(Long id, Manufacturer manufacturer) {
        Manufacturer manufacturerFoundedById = manufacturerDao.findById(id).orElseThrow(DataNotFoundException::new);
        manufacturerFoundedById.setNameOfCompany(manufacturer.getNameOfCompany());
        manufacturerFoundedById.setLocationCity(manufacturer.getLocationCity());
        manufacturerFoundedById.setTaxNumber(manufacturer.getTaxNumber());
        manufacturerFoundedById.setForeignCapital(manufacturer.isForeignCapital());
        manufacturerFoundedById.setDateOfCreation(ZonedDateTime.now());
        manufacturerFoundedById.setNumberOfStockholders(manufacturer.getNumberOfStockholders());
        manufacturerFoundedById.setStuffNumber(manufacturer.getStuffNumber());
        return manufacturerDao.save(manufacturerFoundedById);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        try {
            manufacturerDao.deleteById(id);
        } catch (Exception ex) {
            throw new DataNotFoundException();
        }
    }
}
