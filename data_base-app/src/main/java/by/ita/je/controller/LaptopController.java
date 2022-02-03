package by.ita.je.controller;

import by.ita.je.dto.LaptopDto;
import by.ita.je.model.Laptop;
import by.ita.je.service.IServiceLaptop;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/laptop")
public class LaptopController {

    private final ObjectMapper objectMapper;
    private final IServiceLaptop laptopService;

    public LaptopController(ObjectMapper objectMapper, IServiceLaptop laptopService) {
        this.objectMapper = objectMapper;
        this.laptopService = laptopService;
    }

    @ApiOperation("Create laptop only")
    @PostMapping("/create")
    public LaptopDto create(@RequestBody LaptopDto laptopDto) {
        final Laptop laptop = objectMapper.convertValue(laptopDto, Laptop.class);
        Laptop laptopCreated = laptopService.create(laptop);
        return objectMapper.convertValue(laptopCreated, LaptopDto.class);
    }

    @ApiOperation("Read all laptops")
    @GetMapping("/read/all")
    public List<LaptopDto> readAll() {
        List<Laptop> list = laptopService.readAll();
        return list.stream().map(laptop -> objectMapper.convertValue(laptop, LaptopDto.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/read/{ids}")
    public LaptopDto readById(@PathVariable Long ids) {
        Laptop laptop = laptopService.readById(ids);
        return objectMapper.convertValue(laptop, LaptopDto.class);
    }

    @PutMapping("/update")
    public LaptopDto update(@RequestParam(value = "id") Long id,
                            @RequestBody LaptopDto laptopDto) {
        final Laptop laptop = objectMapper.convertValue(laptopDto, Laptop.class);
        Laptop update = laptopService.update(id, laptop);
        return objectMapper.convertValue(update, LaptopDto.class);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        laptopService.deleteById(id);
    }
}
