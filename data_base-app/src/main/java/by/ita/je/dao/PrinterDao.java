package by.ita.je.dao;

import by.ita.je.model.Printer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrinterDao extends JpaRepository <Printer,Long> {
}
