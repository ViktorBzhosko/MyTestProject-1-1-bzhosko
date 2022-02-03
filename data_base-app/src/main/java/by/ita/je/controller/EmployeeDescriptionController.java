package by.ita.je.controller;

import by.ita.je.dto.EmployeeDescriptionDto;
import by.ita.je.model.EmployeeDescription;
import by.ita.je.service.IServiceEmployeeDescription;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/employee")
public class EmployeeDescriptionController {

    private final ObjectMapper objectMapper;
    private final IServiceEmployeeDescription employeeDescriptionService;

    public EmployeeDescriptionController(ObjectMapper objectMapper, IServiceEmployeeDescription employeeDescriptionService) {
        this.objectMapper = objectMapper;
        this.employeeDescriptionService = employeeDescriptionService;
    }

    @ApiOperation("Create employee")
    @PostMapping("/create")
    public EmployeeDescriptionDto create(@RequestBody EmployeeDescriptionDto employeeDescriptionDto) {
        final EmployeeDescription employeeDescription = objectMapper.convertValue(employeeDescriptionDto, EmployeeDescription.class);
        EmployeeDescription employeeDescriptionCreated = employeeDescriptionService.create(employeeDescription);
        return objectMapper.convertValue(employeeDescriptionCreated, EmployeeDescriptionDto.class);
    }

    @ApiOperation("Read all employees")
    @GetMapping("/read/all")
    public List<EmployeeDescriptionDto> readAll() {
        List<EmployeeDescription> list = employeeDescriptionService.readAll();
        return list.stream().map(employeeDescription -> objectMapper.convertValue(employeeDescription, EmployeeDescriptionDto.class))
                .collect(Collectors.toList());
    }

    @ApiOperation("Read one employee by id")
    @GetMapping("/read")
    public List<EmployeeDescriptionDto> readById(@RequestBody List<Long> ids) {
        List<EmployeeDescription> listEmployeeDescription = employeeDescriptionService.readById(ids);
        return listEmployeeDescription.stream().map(employeeDescription -> objectMapper.convertValue(employeeDescription, EmployeeDescriptionDto.class))
                .collect(Collectors.toList());
    }

    @ApiOperation("Update employee")
    @PutMapping("/update")
    public EmployeeDescriptionDto update(@RequestParam(value = "id") Long id,
                                         @RequestBody EmployeeDescriptionDto employeeDescriptionDto) {
        final EmployeeDescription employeeDescription = objectMapper.convertValue(employeeDescriptionDto, EmployeeDescription.class);
        EmployeeDescription update = employeeDescriptionService.update(id, employeeDescription);
        return objectMapper.convertValue(update, EmployeeDescriptionDto.class);
    }

    @ApiOperation("Delete employee id")
    @DeleteMapping(value = "/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        employeeDescriptionService.deleteById(id);
    }
}


