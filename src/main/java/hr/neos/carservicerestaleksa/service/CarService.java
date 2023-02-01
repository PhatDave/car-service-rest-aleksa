package hr.neos.carservicerestaleksa.service;

import hr.neos.carservicerestaleksa.dto.CarGetDto;
import hr.neos.carservicerestaleksa.dto.CarPostDto;
import hr.neos.carservicerestaleksa.entity.Car;

import java.util.List;

public interface CarService {
    CarGetDto add(CarPostDto dto);

    Car getById(Long id);

    CarGetDto getDtoById(Long id);

    List<Car> getAll();

    List<CarGetDto> getAllDto();

    void deleteById(Long id);
}
