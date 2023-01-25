package hr.neos.carservicerestaleksa.repository;

import hr.neos.carservicerestaleksa.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {
}
