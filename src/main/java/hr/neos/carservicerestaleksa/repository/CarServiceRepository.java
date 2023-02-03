package hr.neos.carservicerestaleksa.repository;

import hr.neos.carservicerestaleksa.entity.CarService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarServiceRepository extends JpaRepository<CarService, Long> {
}
