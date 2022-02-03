package by.ita.je.service;

import by.ita.je.model.Printer;

import java.util.List;

public interface IServicePrinter {

    Printer create(Printer printer);

    List<Printer> readAll();

    List<Printer> readById(List<Long> id);

    Printer update(Long id, Printer printer);

    void deleteById(Long id);
}
