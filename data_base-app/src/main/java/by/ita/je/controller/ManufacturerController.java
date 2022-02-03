package by.ita.je.controller;

import by.ita.je.dto.ManufacturerDto;
import by.ita.je.model.Manufacturer;
import by.ita.je.service.IServiceManufacturer;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/manufacturer")
public class ManufacturerController {

    private final ObjectMapper objectMapper;
    private final IServiceManufacturer manufacturerService;

    public ManufacturerController(ObjectMapper objectMapper, IServiceManufacturer manufacturerService) {
        this.objectMapper = objectMapper;
        this.manufacturerService = manufacturerService;
    }

    @ApiOperation("Create manufacturer only")
    @PostMapping("/create")
    public ManufacturerDto create(@RequestBody ManufacturerDto manufacturerDto) {
        final Manufacturer manufacturer = objectMapper.convertValue(manufacturerDto, Manufacturer.class);
        Manufacturer manufacturerCreated = manufacturerService.create(manufacturer);
        return objectMapper.convertValue(manufacturerCreated, ManufacturerDto.class);
    }

    @ApiOperation("Read all manufacturers")
    @GetMapping("/read/all")
    public List<ManufacturerDto> readAll() {
        List<Manufacturer> list = manufacturerService.readAll();
        return list.stream().map(manufacturer -> objectMapper.convertValue(manufacturer, ManufacturerDto.class))
                .collect(Collectors.toList());
    }

    @ApiOperation("Read by id")
    @GetMapping("/read")
    public List<ManufacturerDto> readById(@RequestBody List<Long> ids) {
        List<Manufacturer> listManufacturer = manufacturerService.readById(ids);
        return listManufacturer.stream().map(manufacturer -> objectMapper.convertValue(manufacturer, ManufacturerDto.class))
                .collect(Collectors.toList());
    }

    @ApiOperation("Update manufacturer")
    @PutMapping("/update")
    public ManufacturerDto update(@RequestParam(value = "id") Long id,
                                  @RequestBody ManufacturerDto manufacturerDto) {
        final Manufacturer manufacturer = objectMapper.convertValue(manufacturerDto, Manufacturer.class);
        Manufacturer update = manufacturerService.update(id, manufacturer);
        return objectMapper.convertValue(update, ManufacturerDto.class);
    }

    @ApiOperation("Delete manufacturer by id")
    @DeleteMapping(value = "/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        manufacturerService.deleteById(id);
    }
}
