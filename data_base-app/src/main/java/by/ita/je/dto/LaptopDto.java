package by.ita.je.dto;


import by.ita.je.model.Manufacturer;
import by.ita.je.model.Printer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class LaptopDto {

    private long id;
    private String name;
    private int serialNumber;
    private String nameOfProcessor;
    private boolean usbCharging;
    private List<Printer> printerList;
    private Manufacturer manufacturer;

    @Override
    public String toString() {
        return "LaptopDto{" +
                "name='" + name + '\'' +
                ", price=" + serialNumber +
                ", nameOfProcessor='" + nameOfProcessor + '\'' +
                ", usbCharging=" + usbCharging +
                '}';
    }
}
