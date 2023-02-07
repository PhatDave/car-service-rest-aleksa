package hr.neos.carservicerestaleksa.mapper;


import hr.neos.carservicerestaleksa.dto.CarServiceGetDto;
import hr.neos.carservicerestaleksa.dto.CarServicePostDto;
import hr.neos.carservicerestaleksa.entity.CarService;

import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;


@Mapper(
        uses = {
                CarMapper.class,
        },
        builder = @Builder(disableBuilder = true))
public abstract class CarServiceMapper {
    @Autowired
    private hr.neos.carservicerestaleksa.service.CarService carService;

    @Mapping(target = "car", ignore = true)
    public abstract CarService toEntity(CarServicePostDto dto);

    public abstract CarServiceGetDto toDto(CarService carService);

    @AfterMapping
    public void mapCar(CarServicePostDto dto, @MappingTarget CarService carServiceTarget){
        carServiceTarget.setCar(carService.getById(dto.getCar()));
    }
}
