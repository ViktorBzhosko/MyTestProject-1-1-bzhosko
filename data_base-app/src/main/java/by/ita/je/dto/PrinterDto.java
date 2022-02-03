package by.ita.je.dto;

import by.ita.je.model.Laptop;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PrinterDto {

    private long id;
    private String name;
    private int serialNumber;
    private BigDecimal price;
    private boolean wifiDirect;
    private Laptop laptop;

    @Override
    public String toString() {
        return "PrinterDto{" +
                "name='" + name + '\'' +
                ", serialNumber=" + serialNumber +
                ", price=" + price +
                ", wifiDirect=" + wifiDirect +
                '}';
    }
}
