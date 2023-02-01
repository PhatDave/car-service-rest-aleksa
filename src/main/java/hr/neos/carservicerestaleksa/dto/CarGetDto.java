package hr.neos.carservicerestaleksa.dto;

import hr.neos.carservicerestaleksa.entity.ManufacturerModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CarGetDto {
    private Long id;
    private UserGetDto owner;
    private ManufacturerModel manufacturerModel;
    private Long productionYear;
    private String registration;
    private String color;
}
