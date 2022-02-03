package by.ita.je.dto;

import by.ita.je.model.Manufacturer;
import by.ita.je.model.Places;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class EmployeeDescriptionDto {

    private long id;
    private String firstName;
    private String position;
    private boolean marriage;
    private long salary;
    private List<Manufacturer> manufacturerList;
    private Places places;

    @Override
    public String toString() {
        return "EmployeeDescriptionDto{" +
                "firstName='" + firstName + '\'' +
                ", position='" + position + '\'' +
                ", marriage=" + marriage +
                ", salary=" + salary +
                '}';
    }
}
