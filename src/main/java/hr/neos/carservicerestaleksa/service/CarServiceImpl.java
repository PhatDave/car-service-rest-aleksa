package hr.neos.carservicerestaleksa.service;

import hr.neos.carservicerestaleksa.dto.CarGetDto;
import hr.neos.carservicerestaleksa.dto.CarPostDto;
import hr.neos.carservicerestaleksa.entity.Car;
import hr.neos.carservicerestaleksa.mapper.CarMapper;
import hr.neos.carservicerestaleksa.repository.CarRepository;
import hr.neos.carservicerestaleksa.validators.CarValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;
    private final CarMapper carMapper;
    private final CarValidator carValidator;

    @Override
    public CarGetDto add(CarPostDto dto) {
        carValidator.validate(dto);
        Car car = carMapper.toEntity(dto);
        car = carRepository.save(car);
        return carMapper.toDto(car);
    }

    @Override
    public Car getById(Long id) {
        return this.carRepository.findById(id).orElseThrow(() -> new
                NoSuchElementException("No car with id " + id + " exists."));
    }

    @Override
    public CarGetDto getDtoById(Long id) {
        return carMapper.toDto(getById(id));
    }

    @Override
    public List<Car> getAll() {
        return this.carRepository.findAll();
    }

    @Override
    public List<CarGetDto> getAllDto() {
        return carMapper.manyToDto(getAll());
    }

    @Override
    public void deleteById(Long id) {
        carRepository.deleteById(id);
    }

}
