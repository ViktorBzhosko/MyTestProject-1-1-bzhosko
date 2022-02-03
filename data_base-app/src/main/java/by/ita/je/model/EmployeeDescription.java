package by.ita.je.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;


import javax.persistence.*;
import java.time.LocalDate;
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
@Table(name = "EMPLOYEE_DESCRIPTION")
public class EmployeeDescription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String firstName;
    private String position;
    private int yearsOld;
    private boolean marriage;
    private boolean driverLicence;
    private long salary;
    private ZonedDateTime employmentDate;

    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @ManyToMany(mappedBy = "employeeDescriptionList", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Manufacturer> manufacturerList;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private Places places;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeDescription that = (EmployeeDescription) o;
        return id == that.id && yearsOld == that.yearsOld
                && marriage == that.marriage
                && driverLicence == that.driverLicence
                && salary == that.salary && Objects.equals(firstName, that.firstName)
                && Objects.equals(position, that.position) && Objects.equals(employmentDate, that.employmentDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, position, yearsOld, marriage, driverLicence, salary, employmentDate);
    }
}



