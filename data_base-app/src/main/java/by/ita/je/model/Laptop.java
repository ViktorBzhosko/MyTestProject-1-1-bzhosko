package by.ita.je.model;

import lombok.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;


import javax.persistence.*;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@NamedQuery(name = "LaptopFindBy_HQL", query = "SELECT l FROM Laptop l " +
        "WHERE l.name =:laptopName and l.manufacturer.nameOfCompany =:nameOfCompanyManufacturer")
public class Laptop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "laptop_id")
    private long id;
    private String name;
    private BigDecimal weightKg;
    private int serialNumber;
    private String nameOfProcessor;
    private boolean usbCharging;
    private boolean touchPad;
    private ZonedDateTime salesDate;


    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "laptop_id")
    private List<Printer> printerList;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "manufacturer_id")
    private Manufacturer manufacturer;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Laptop laptop = (Laptop) o;
        return id == laptop.id && serialNumber == laptop.serialNumber
                && usbCharging == laptop.usbCharging && touchPad == laptop.touchPad && Objects.equals(name, laptop.name)
                && Objects.equals(weightKg, laptop.weightKg) && Objects.equals(nameOfProcessor, laptop.nameOfProcessor)
                && Objects.equals(salesDate, laptop.salesDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, weightKg, serialNumber, nameOfProcessor, usbCharging, touchPad, salesDate);
    }
}

