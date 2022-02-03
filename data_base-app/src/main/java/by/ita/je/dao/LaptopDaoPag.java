package by.ita.je.dao;

import by.ita.je.model.Laptop;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LaptopDaoPag extends PagingAndSortingRepository<Laptop,Long> {
}
