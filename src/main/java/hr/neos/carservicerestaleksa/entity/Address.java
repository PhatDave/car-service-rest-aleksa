package hr.neos.carservicerestaleksa.entity;

import jakarta.persistence.*;
import lombok.*;


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
    private int postalNumber;

    @Column
    private String street;

    @Column
    private int streetNumber;
}
