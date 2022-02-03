package by.ita.je.model;

import by.ita.je.model.enums.PlaceOfSale;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;


import javax.persistence.*;
import java.util.Objects;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Table(name = "PLACES")
public class Places {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private PlaceOfSale placeOfSale;

    @OneToOne
    @JsonBackReference
    private EmployeeDescription employeeDescription;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Places places = (Places) o;
        return Objects.equals(id, places.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
