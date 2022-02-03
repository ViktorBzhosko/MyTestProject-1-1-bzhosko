package by.ita.je.service.impl;

import by.ita.je.dao.EmployeeDescriptionDao;
import by.ita.je.exception.DataIsIncorrectException;
import by.ita.je.exception.DataNotFoundException;
import by.ita.je.model.EmployeeDescription;
import by.ita.je.service.IServiceEmployeeDescription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.ZonedDateTime;
import java.util.List;

@Service
public class EmployeeDescriptionServiceIml implements IServiceEmployeeDescription {

    private final EmployeeDescriptionDao employeeDescriptionDao;


    @Autowired
    public EmployeeDescriptionServiceIml(EmployeeDescriptionDao employeeDescriptionDao) {
        this.employeeDescriptionDao = employeeDescriptionDao;
    }

    @Override
    @Transactional
    public EmployeeDescription create(EmployeeDescription employeeDescription) {
        if (employeeDescription.getFirstName() == null || employeeDescription.getPosition() == null) {
            throw new DataIsIncorrectException();
        } else if (employeeDescription.getSalary() == 0) {
            throw new DataIsIncorrectException();
        }
        employeeDescription.setMarriage(employeeDescription.isMarriage());
        employeeDescription.setYearsOld(30);
        employeeDescription.setEmploymentDate(ZonedDateTime.now());
        employeeDescription.setDriverLicence(false);
        return employeeDescriptionDao.save(employeeDescription);
    }

    @Override
    public List<EmployeeDescription> readAll() {
        List<EmployeeDescription> foundedEmployeeDescription = employeeDescriptionDao.findAll();
        if (!foundedEmployeeDescription.isEmpty()) return foundedEmployeeDescription;
        else throw new DataNotFoundException();
    }

    @Override
    public List<EmployeeDescription> readById(List<Long> ids) {
        List<EmployeeDescription> foundedEmployeeDescription = employeeDescriptionDao.findAllById(ids);
        if (!foundedEmployeeDescription.isEmpty()) return foundedEmployeeDescription;
        else throw new DataNotFoundException();

    }

    @Override
    @Transactional
    public EmployeeDescription update(Long id, EmployeeDescription employeeDescription) {
        EmployeeDescription employeeDescriptionFoundedById = employeeDescriptionDao.findById(id).orElseThrow(DataNotFoundException::new);
        employeeDescriptionFoundedById.setFirstName(employeeDescription.getFirstName());
        employeeDescriptionFoundedById.setPosition(employeeDescription.getPosition());
        employeeDescriptionFoundedById.setSalary(employeeDescription.getSalary());
        employeeDescriptionFoundedById.setYearsOld(employeeDescription.getYearsOld());
        employeeDescriptionFoundedById.setEmploymentDate(ZonedDateTime.now());
        employeeDescriptionFoundedById.setMarriage(employeeDescription.isMarriage());
        employeeDescriptionFoundedById.setDriverLicence(employeeDescription.isDriverLicence());
        return employeeDescriptionDao.save(employeeDescriptionFoundedById);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        try {
            employeeDescriptionDao.deleteById(id);
        } catch (Exception ex) {
            throw new DataNotFoundException();
        }
    }
}
