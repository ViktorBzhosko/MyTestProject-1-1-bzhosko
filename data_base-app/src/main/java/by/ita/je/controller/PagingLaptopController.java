package by.ita.je.controller;

import by.ita.je.model.Laptop;
import by.ita.je.service.impl.LaptopPagingService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
@RequestMapping("/laptop/paging")
public class PagingLaptopController {

    private final LaptopPagingService laptopPagingService;

    @Autowired
    public PagingLaptopController(LaptopPagingService laptopPagingService) {
        this.laptopPagingService = laptopPagingService;
    }

    @ApiOperation("Create paging when read laptop")
    @GetMapping
    public ResponseEntity<List<Laptop>> getAllEmployees(Pageable pageable) {
        List<Laptop> list = laptopPagingService.getAllLaptops(pageable);

        return new ResponseEntity<>(list, new HttpHeaders(), HttpStatus.OK);
    }
}
