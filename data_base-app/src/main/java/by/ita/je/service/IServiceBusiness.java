package by.ita.je.service;

import by.ita.je.model.Laptop;
import com.fasterxml.jackson.databind.JsonNode;

import java.util.List;

public interface IServiceBusiness {

    Laptop create(Laptop laptop);

    Laptop readById(Long id);

    Laptop update(Long id, Laptop laptop);

    void delete(Long id);

}
