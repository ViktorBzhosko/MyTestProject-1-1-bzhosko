package by.ita.je.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;


import javax.persistence.*;
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
@Table(name = "MANUFACTURER")
public class Manufacturer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nameOfCompany;
    private String locationCity;
    private int stuffNumber;
    private long taxNumber;
    private boolean foreignCapital;
    private int numberOfStockholders;
    private ZonedDateTime dateOfCreation;

    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @OneToMany(mappedBy = "manufacturer")
    @JsonIgnore
    private List<Laptop> laptopList;

    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "MANUFACTURER_EMPLOYEE",
            joinColumns = {@JoinColumn(name = "id")},
            inverseJoinColumns = {@JoinColumn(name = "employee_description_id")})
    private List<EmployeeDescription> employeeDescriptionList;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Manufacturer that = (Manufacturer) o;
        return id == that.id && stuffNumber == that.stuffNumber
                && taxNumber == that.taxNumber && foreignCapital == that.foreignCapital
                && numberOfStockholders == that.numberOfStockholders
                && Objects.equals(nameOfCompany, that.nameOfCompany)
                && Objects.equals(locationCity, that.locationCity)
                && Objects.equals(dateOfCreation, that.dateOfCreation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nameOfCompany, locationCity, stuffNumber, taxNumber, foreignCapital, numberOfStockholders, dateOfCreation);
    }
}
