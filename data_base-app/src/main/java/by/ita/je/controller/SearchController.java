package by.ita.je.controller;

import by.ita.je.dto.FiltedDto;
import by.ita.je.dto.LaptopDto;
import by.ita.je.model.Laptop;
import by.ita.je.service.IServiceSearch;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class SearchController {

    private final ObjectMapper objectMapper;
    private final IServiceSearch service;


    public SearchController(ObjectMapper objectMapper, IServiceSearch service) {
        this.objectMapper = objectMapper;
        this.service = service;
    }

    @ApiOperation("Find laptops by JPQL query")
    @PostMapping(value = "/search/JPQL")
    public List<LaptopDto> findByJPQL(@RequestBody FiltedDto filtedDto) {
        List<Laptop> laptops = service.findByJPQL(filtedDto.getLaptopName(), filtedDto.getNameOfCompanyManufacturer());
        return laptops.stream()
                .map(laptop -> objectMapper.convertValue(laptop, LaptopDto.class))
                .collect(Collectors.toList());
    }
}
