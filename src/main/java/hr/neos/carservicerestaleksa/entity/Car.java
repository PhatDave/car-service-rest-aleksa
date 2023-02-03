package hr.neos.carservicerestaleksa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

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
    @JoinColumn(name = "ownerId")
    private User user;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "car")
    private Set<CarService> carServices;

}
