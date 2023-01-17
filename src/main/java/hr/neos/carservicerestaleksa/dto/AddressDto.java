package hr.neos.carservicerestaleksa.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddressDto {
    private String country;
    private String city;
    private Long postalNumber;
    private String street;
    private Long streetNumber;
}
