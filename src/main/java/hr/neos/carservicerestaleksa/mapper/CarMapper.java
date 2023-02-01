package hr.neos.carservicerestaleksa.mapper;

import hr.neos.carservicerestaleksa.dto.CarGetDto;
import hr.neos.carservicerestaleksa.dto.CarPostDto;
import hr.neos.carservicerestaleksa.entity.Car;
import hr.neos.carservicerestaleksa.entity.ManufacturerModel;
import hr.neos.carservicerestaleksa.service.UserService;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;


@Mapper(
        uses = {
                UserMapper.class,
        },
        builder = @Builder(disableBuilder = true)
)
public abstract class CarMapper {
    @Autowired
    private UserService userService;

    @Mapping(target = "manufacturerModel", ignore = true)
    public abstract Car toEntity(CarPostDto dto);

    @Mapping(source = "user", target = "owner")
    public abstract CarGetDto toDto(Car car);

    @AfterMapping
    public void mapEnumAndOwner(CarPostDto dto, @MappingTarget Car car) {
        car.setManufacturerModel(ManufacturerModel.values()[dto.getManufacturerModel().intValue()]);
        car.setUser(userService.getById(dto.getOwner()));
    }

}
