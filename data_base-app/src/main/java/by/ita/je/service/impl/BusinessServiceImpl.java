package by.ita.je.service.impl;

import by.ita.je.model.*;
import by.ita.je.model.enums.PlaceOfSale;
import by.ita.je.service.IServiceBusiness;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class BusinessServiceImpl implements IServiceBusiness {

    private final LaptopServiceImpl laptopService;
    private final PrinterServiceImpl printerService;
    private final EmployeeDescriptionServiceIml employeeDescriptionServiceIml;
    private final ManufacturerServiceImpl manufacturerService;


    @Override
    @Transactional
    public Laptop create(Laptop laptop) {
        createIfNoRelationsLaptopToPrinters(laptop);
        createIfNoRelationsLaptopsToPlaces(laptop);
        return laptopService.create(laptop);
    }

    @Transactional
    public void createIfNoRelationsLaptopsToPlaces(Laptop laptop) {
        if (Objects.isNull(laptop.getManufacturer())) {
            laptop.setManufacturer(createManufacturer());
        }
        if (Objects.isNull(laptop.getManufacturer().getEmployeeDescriptionList())) {
            laptop.getManufacturer().setEmployeeDescriptionList(createEmployeeWithPlaces());
        }
    }

    @Transactional
    public void createIfNoRelationsLaptopToPrinters(Laptop laptop) {
        if (Objects.isNull(laptop.getPrinterList()) || laptop.getPrinterList().isEmpty()) {
            laptop.setPrinterList(Stream
                    .generate(this::createPrinter)
                    .limit(1)
                    .collect(Collectors.toList()));
        }
    }

    @Transactional
    public List<EmployeeDescription> createEmployeeWithPlaces() {
        EmployeeDescription employeeDescription = getEmployeeDescription();
        employeeDescription.setPlaces(Places.builder().placeOfSale(PlaceOfSale.THE21VEK).build());
        List<EmployeeDescription> createdEmployee = new LinkedList<>();
        createdEmployee.add(employeeDescription);
        return createdEmployee;
    }

    @Override
    public Laptop readById(Long ids) {
        return laptopService.readById(ids);
    }

    @Override
    @Transactional
    public Laptop update(Long id, Laptop laptop) {
        if (Objects.nonNull(laptop.getPrinterList())) {
            laptop.getPrinterList().forEach(printer -> printerService.update(printer.getId(), printer));
        }
        if (Objects.nonNull(laptop.getManufacturer())) {
            manufacturerService.update(laptop.getManufacturer().getId(), laptop.getManufacturer());
        }
        if (Objects.nonNull(laptop.getManufacturer().getEmployeeDescriptionList())) {
            for (EmployeeDescription employeeDescription : laptop.getManufacturer().getEmployeeDescriptionList()) {
                employeeDescriptionServiceIml.update(employeeDescription.getId(), employeeDescription);
            }
        }
        return laptopService.update(id, laptop);
    }

    @Override
    public void delete(Long id) {
        laptopService.deleteById(id);
    }

    private EmployeeDescription getEmployeeDescription() {
        return EmployeeDescription.builder()
                .firstName("Viktor")
                .position("driver")
                .yearsOld(30)
                .driverLicence(true)
                .salary(500)
                .employmentDate(ZonedDateTime.now())
                .build();
    }

    private Printer createPrinter() {
        return Printer.builder()
                .name("Hp")
                .serialNumber(147)
                .colourPrint(true)
                .price(new BigDecimal("121.5"))
                .colour("Black")
                .wifiDirect(true)
                .productionDateTime(ZonedDateTime.now())
                .build();
    }

    private Manufacturer createManufacturer() {
        return Manufacturer.builder()
                .nameOfCompany("Canon")
                .locationCity("NY")
                .taxNumber(1212)
                .foreignCapital(false)
                .dateOfCreation(ZonedDateTime.now())
                .numberOfStockholders(4)
                .stuffNumber(30000)
                .build();
    }
}
