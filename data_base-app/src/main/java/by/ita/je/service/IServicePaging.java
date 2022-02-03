package by.ita.je.service;

import by.ita.je.model.Laptop;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IServicePaging {

    List<Laptop> getAllLaptops(Pageable pageable);
}
