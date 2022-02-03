package by.ita.je.dto;

import by.ita.je.model.EmployeeDescription;
import by.ita.je.model.enums.PlaceOfSale;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PlacesDto {

    private Long id;

    @Enumerated(EnumType.STRING)
    private PlaceOfSale placeOfSale;
    private EmployeeDescription employeeDescription;

}
