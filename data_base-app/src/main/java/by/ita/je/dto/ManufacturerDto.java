package by.ita.je.dto;

import by.ita.je.model.EmployeeDescription;
import by.ita.je.model.Laptop;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ManufacturerDto {

    private long id;
    private String nameOfCompany;
    private String locationCity;
    private long taxNumber;
    private boolean foreignCapital;
    private List<Laptop> laptopList;
    private List<EmployeeDescription> employeeDescriptionList;

    @Override
    public String toString() {
        return "ManufacturerDto{" +
                "nameOfCompany='" + nameOfCompany + '\'' +
                ", locationCity='" + locationCity + '\'' +
                ", taxNumber=" + taxNumber +
                ", foreignCapital=" + foreignCapital +
                '}';
    }
}
