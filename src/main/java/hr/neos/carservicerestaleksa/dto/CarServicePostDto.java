package hr.neos.carservicerestaleksa.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CarServicePostDto {
    private Date dateAndTime;
    private String employeeFirstName;
    private String employeeLastName;
    private String workDescription;
    private Long price;
    private Long car;
}
