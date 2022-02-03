package by.ita.je.service;

import by.ita.je.model.EmployeeDescription;

import java.util.List;

public interface IServiceEmployeeDescription {

    EmployeeDescription create(EmployeeDescription employeeDescription);

    List<EmployeeDescription> readAll();

    List<EmployeeDescription> readById(List<Long> id);

    EmployeeDescription update(Long id, EmployeeDescription employeeDescription);

    void deleteById(Long id);
}
