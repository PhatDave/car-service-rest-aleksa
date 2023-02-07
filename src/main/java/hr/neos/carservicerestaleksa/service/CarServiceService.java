package hr.neos.carservicerestaleksa.service;


import hr.neos.carservicerestaleksa.dto.CarServiceGetDto;
import hr.neos.carservicerestaleksa.dto.CarServicePostDto;
import hr.neos.carservicerestaleksa.entity.CarService;

public interface CarServiceService {
    CarServiceGetDto add(CarServicePostDto dto);

    CarService getById(Long id);
}
