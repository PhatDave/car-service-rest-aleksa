package hr.neos.carservicerestaleksa.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "cars")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "car_sequence")
    @SequenceGenerator(name = "car_sequence", allocationSize = 10)
    private Long id;

    @Enumerated
    private ManufacturerModel manufacturerModel;

    @Column
    private Long productionYear;

    @Column
    private String registration;

    @Column
    private String color;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User user;
}
