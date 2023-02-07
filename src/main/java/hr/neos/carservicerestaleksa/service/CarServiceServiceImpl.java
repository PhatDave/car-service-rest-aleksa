package hr.neos.carservicerestaleksa.service;

import hr.neos.carservicerestaleksa.dto.CarServiceGetDto;
import hr.neos.carservicerestaleksa.dto.CarServicePostDto;
import hr.neos.carservicerestaleksa.entity.CarService;
import hr.neos.carservicerestaleksa.mapper.CarServiceMapper;
import hr.neos.carservicerestaleksa.repository.CarServiceRepository;
import hr.neos.carservicerestaleksa.validators.CarServiceValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class CarServiceServiceImpl implements CarServiceService {
    private final CarServiceRepository carServiceRepository;
    private final CarServiceMapper carServiceMapper;
    private final CarServiceValidator carServiceValidator;

    @Override
    public CarServiceGetDto add(CarServicePostDto dto) {
        carServiceValidator.validate(dto);
        CarService carService = carServiceMapper.toEntity(dto);
        carService = carServiceRepository.save(carService);
        return carServiceMapper.toDto(carService);
    }

    @Override
    public CarService getById(Long id) {
        return this.carServiceRepository.findById(id).orElseThrow(() -> new
                NoSuchElementException("No car service with id " + id + " exists"));
    }

}
