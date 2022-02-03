package by.ita.je.controller;

import by.ita.je.dto.LaptopDto;
import by.ita.je.model.Laptop;
import by.ita.je.service.IServiceBusiness;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@RestController
public class BusinessController {

    private final ObjectMapper objectMapper;
    private final IServiceBusiness serviceBusiness;

    public BusinessController(ObjectMapper objectMapper, IServiceBusiness serviceBusiness) {
        this.objectMapper = objectMapper;
        this.serviceBusiness = serviceBusiness;

    }

    @ApiOperation("Create laptop if no relationships")
    @PostMapping("/business")
    public LaptopDto create(@RequestBody LaptopDto laptopDto) {
        final Laptop convertValue = objectMapper.convertValue(laptopDto, Laptop.class);
        final Laptop laptopCreated = serviceBusiness.create(convertValue);
        return objectMapper.convertValue(laptopCreated, LaptopDto.class);
    }

    @ApiOperation("Update laptop relationships")
    @PutMapping("/business/{laptop_id}")
    public LaptopDto update(@PathVariable("laptop_id") Long id, @RequestBody LaptopDto laptopDto) {
        final Laptop laptop = objectMapper.convertValue(laptopDto, Laptop.class);
        final Laptop laptopUpdated = serviceBusiness.update(id, laptop);
        return objectMapper.convertValue(laptopUpdated, LaptopDto.class);
    }

    @ApiOperation("Read laptop by id with relationships")
    @GetMapping("/business/{ids}")
    public LaptopDto readById(@PathVariable Long ids) {
        final Laptop laptop = serviceBusiness.readById(ids);
        return objectMapper.convertValue(laptop, LaptopDto.class);
    }

    @ApiOperation("Delete laptop by id")
    @DeleteMapping("/business/{id}")
    public void delete(@PathVariable Long id) {
        serviceBusiness.delete(id);
    }
}
