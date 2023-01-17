package hr.neos.carservicerestaleksa.dto;

import lombok.*;

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
