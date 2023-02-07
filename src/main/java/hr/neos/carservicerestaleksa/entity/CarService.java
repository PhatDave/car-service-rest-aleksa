package hr.neos.carservicerestaleksa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "car_services")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CarService {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "car_service_sequence")
    @SequenceGenerator(name = "car_service_sequence", allocationSize = 10)
    private Long id;

    @DateTimeFormat(pattern = "dd-MM-yyyy HH:mm")
    @Column
    private Date dateAndTime;

    @Column
    private String employeeFirstName;

    @Column
    private String employeeLastName;

    @Column
    private String workDescription;

    @Column
    private Long price;

    @Column
    private boolean payment;

    @ManyToOne
    @JoinColumn(name = "carId")
    private Car car;

}
