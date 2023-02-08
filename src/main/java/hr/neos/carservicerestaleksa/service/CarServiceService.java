package hr.neos.carservicerestaleksa.service;


import hr.neos.carservicerestaleksa.dto.CarServiceGetDto;
import hr.neos.carservicerestaleksa.dto.CarServicePostDto;
import hr.neos.carservicerestaleksa.entity.CarService;

import java.util.List;

public interface CarServiceService {
    CarServiceGetDto add(CarServicePostDto dto);

    CarService getById(Long id);

    CarServiceGetDto getDtoById(Long id);

    List<CarService> getAll();

    List<CarServiceGetDto> getAllDto();

    void deleteById(Long id);

    CarService updatePayment(Long id);


}
