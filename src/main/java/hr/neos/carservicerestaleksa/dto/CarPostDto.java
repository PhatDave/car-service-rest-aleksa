package hr.neos.carservicerestaleksa.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CarPostDto {
    private Long owner;
    private Long manufacturerModel;
    private Long productionYear;
    private String registration;
    private String color;


}
