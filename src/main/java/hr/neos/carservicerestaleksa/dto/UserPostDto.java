package hr.neos.carservicerestaleksa.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserPostDto {
    private String firstName;
    private String lastName;
    private Long oib;
    private AddressDto address;
}
