package by.ita.je.model;

import lombok.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;


import javax.persistence.*;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Table(name = "PRINTER")
public class Printer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String colour;
    private int serialNumber;
    private BigDecimal price;
    private boolean wifiDirect;
    private boolean colourPrint;
    private ZonedDateTime productionDateTime;

    @ManyToOne(cascade = CascadeType.ALL)
    private Laptop laptop;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Printer printer = (Printer) o;
        return id == printer.id && serialNumber == printer.serialNumber
                && wifiDirect == printer.wifiDirect && colourPrint == printer.colourPrint
                && Objects.equals(name, printer.name) && Objects.equals(colour, printer.colour)
                && Objects.equals(price, printer.price) && Objects.equals(productionDateTime, printer.productionDateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, colour, serialNumber, price, wifiDirect, colourPrint, productionDateTime);
    }
}
