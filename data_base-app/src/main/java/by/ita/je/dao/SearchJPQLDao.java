package by.ita.je.dao;

import by.ita.je.model.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SearchJPQLDao extends JpaRepository<Laptop, Long> {
@Query(value = "SELECT l FROM Laptop l " +
        "WHERE l.name = :NAME and l.manufacturer.nameOfCompany = :NAME_OF_COMPANY")
    List<Laptop> findByJPQL(@Param("NAME") String laptopName,
                            @Param("NAME_OF_COMPANY") String nameOfCompanyManufacturer);
}

