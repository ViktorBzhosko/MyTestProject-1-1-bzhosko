package by.ita.je.dao;

import by.ita.je.model.EmployeeDescription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeDescriptionDao extends JpaRepository<EmployeeDescription,Long> {
}
