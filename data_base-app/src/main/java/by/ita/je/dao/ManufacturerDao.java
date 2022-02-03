package by.ita.je.dao;

import by.ita.je.model.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManufacturerDao extends JpaRepository <Manufacturer,Long> {
}
