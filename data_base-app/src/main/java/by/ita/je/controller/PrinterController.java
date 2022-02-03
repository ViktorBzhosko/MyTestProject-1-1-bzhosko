package by.ita.je.controller;

import by.ita.je.dto.PrinterDto;
import by.ita.je.model.Printer;
import by.ita.je.service.IServicePrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/printer")
public class PrinterController {

    private final ObjectMapper objectMapper;

    private final IServicePrinter printerService;

    public PrinterController(ObjectMapper objectMapper, IServicePrinter printerService) {
        this.objectMapper = objectMapper;
        this.printerService = printerService;
    }

    @ApiOperation("Create printer")
    @PostMapping("/create")
    public PrinterDto create(@RequestBody PrinterDto printerDto) {
        final Printer printer = objectMapper.convertValue(printerDto, Printer.class);
        Printer printerCreated = printerService.create(printer);
        return objectMapper.convertValue(printerCreated, PrinterDto.class);
    }

    @ApiOperation("Read all printer")
    @GetMapping("/read/all")
    public List<PrinterDto> readAll() {
        List<Printer> list = printerService.readAll();
        return list.stream().map(printer -> objectMapper.convertValue(printer, PrinterDto.class))
                .collect(Collectors.toList());
    }

    @ApiOperation("Read by printer id")
    @GetMapping("/read")
    public List<PrinterDto> readById(@RequestBody List<Long> ids) {
        List<Printer> listPrinter = printerService.readById(ids);
        return listPrinter.stream().map(printer -> objectMapper.convertValue(printer, PrinterDto.class))
                .collect(Collectors.toList());
    }

    @ApiOperation("Update printer")
    @PutMapping("/update")
    public PrinterDto update(@RequestParam(value = "id") Long id, @RequestBody PrinterDto printerDto) {
        final Printer printer = objectMapper.convertValue(printerDto, Printer.class);
        Printer update = printerService.update(id, printer);
        return objectMapper.convertValue(update, PrinterDto.class);
    }

    @ApiOperation("Delete printer id")
    @DeleteMapping(value = "/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        printerService.deleteById(id);
    }
}
