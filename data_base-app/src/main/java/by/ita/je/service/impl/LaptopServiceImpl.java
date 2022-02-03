package by.ita.je.service.impl;

import by.ita.je.dao.LaptopDao;
import by.ita.je.exception.DataIsIncorrectException;
import by.ita.je.exception.DataNotFoundException;
import by.ita.je.model.EmployeeDescription;
import by.ita.je.model.Laptop;
import by.ita.je.service.IServiceLaptop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;

@Service
public class LaptopServiceImpl implements IServiceLaptop {

    private final LaptopDao laptopDao;

    @Autowired
    public LaptopServiceImpl(LaptopDao laptopDao) {
        this.laptopDao = laptopDao;
    }

    @Override
    @Transactional
    public Laptop create(Laptop laptop) {

        if (laptop.getName() == null || laptop.getNameOfProcessor() == null) {
            throw new DataIsIncorrectException();
        } else if (laptop.getSerialNumber() == 0) {
            throw new DataIsIncorrectException();
        }
        laptop.setUsbCharging(laptop.isUsbCharging());
        laptop.setWeightKg(new BigDecimal("2.2"));
        laptop.setSalesDate(ZonedDateTime.now());
        laptop.setTouchPad(true);
        return laptopDao.save(laptop);
    }

    @Override
    public List<Laptop> readAll() {
        List<Laptop> foundedLaptops = laptopDao.findAll();
        if (!foundedLaptops.isEmpty()) return foundedLaptops;
        else throw new DataNotFoundException();
    }

    @Override
    public Laptop readById(Long ids) {
        if (ids < 1) throw new DataIsIncorrectException();
        return laptopDao.findById(ids)
                .orElseThrow(DataNotFoundException::new);
    }

    @Override
    @Transactional
    public Laptop update(Long id, Laptop laptop) {
        Laptop laptopFoundedById = laptopDao.findById(id).orElseThrow(DataNotFoundException::new);
        laptopFoundedById.setName(laptop.getName());
        laptopFoundedById.setNameOfProcessor(laptop.getNameOfProcessor());
        laptopFoundedById.setSerialNumber(laptop.getSerialNumber());
        laptopFoundedById.setWeightKg(laptop.getWeightKg());
        laptopFoundedById.setSalesDate(ZonedDateTime.now());
        laptopFoundedById.setTouchPad(laptop.isTouchPad());
        laptopFoundedById.setUsbCharging(laptop.isUsbCharging());
        return laptopDao.save(laptopFoundedById);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        try {
            laptopDao.deleteById(id);
        } catch (Exception ex) {
            throw new DataNotFoundException();
        }
    }
}
