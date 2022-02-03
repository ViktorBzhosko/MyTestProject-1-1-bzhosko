package by.ita.je.service.impl;

import by.ita.je.dao.PrinterDao;
import by.ita.je.exception.DataIsIncorrectException;
import by.ita.je.exception.DataNotFoundException;
import by.ita.je.model.Printer;
import by.ita.je.service.IServicePrinter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;

@Service
public class PrinterServiceImpl implements IServicePrinter {

    private final PrinterDao printerDao;

    @Autowired
    public PrinterServiceImpl(PrinterDao printerDao) {
        this.printerDao = printerDao;
    }

    @Override
    @Transactional
    public Printer create(Printer printer) {
        if (printer.getName() == null) {
            throw new DataIsIncorrectException();
        } else if (printer.getSerialNumber() == 0) {
            throw new DataIsIncorrectException();
        } else if (printer.getPrice().equals(BigDecimal.valueOf(0))) {
            throw new DataIsIncorrectException();
        }
        printer.setWifiDirect(printer.isWifiDirect());
        printer.setColour("Black");
        printer.setProductionDateTime(ZonedDateTime.now());
        printer.setColourPrint(true);
        return printerDao.save(printer);
    }

    @Override
    public List<Printer> readAll() {
        List<Printer> foundedPrinters = printerDao.findAll();
        if (!foundedPrinters.isEmpty()) return foundedPrinters;
        else throw new DataNotFoundException();
    }

    @Override
    public List<Printer> readById(List<Long> ids) {
        List<Printer> foundedPrinters = printerDao.findAllById(ids);
        if (!foundedPrinters.isEmpty()) return foundedPrinters;
        else throw new DataNotFoundException();
    }

    @Override
    @Transactional
    public Printer update(Long id, Printer printer) {
        Printer printerFoundedById = printerDao.findById(id).orElseThrow(DataNotFoundException::new);
        printerFoundedById.setName(printer.getName());
        printerFoundedById.setColour(printer.getColour());
        printerFoundedById.setSerialNumber(printer.getSerialNumber());
        printerFoundedById.setPrice(printer.getPrice());
        printerFoundedById.setProductionDateTime(ZonedDateTime.now());
        printerFoundedById.setColourPrint(printer.isColourPrint());
        printerFoundedById.setWifiDirect(printer.isWifiDirect());
        return printerDao.save(printerFoundedById);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        try {
            printerDao.deleteById(id);
        } catch (Exception exception) {
            throw new DataNotFoundException();
        }
    }
}
