package hr.neos.carservicerestaleksa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    @Column
    private String country;

    @Column
    private String city;

    @Column
    private Long postalNumber;

    @Column
    private String street;

    @Column
    private Long streetNumber;
}
