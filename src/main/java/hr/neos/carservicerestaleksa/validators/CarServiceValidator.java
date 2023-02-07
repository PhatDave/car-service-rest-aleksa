package hr.neos.carservicerestaleksa.validators;


import hr.neos.carservicerestaleksa.dto.CarServicePostDto;
import hr.neos.carservicerestaleksa.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class CarServiceValidator {
    private final CarService carService;

    public void validate(CarServicePostDto dto) {
        validateDateAndTime(dto);
        validateEmployeeFirstName(dto);
        validateEmployeeLastName(dto);
        validateWorkDescription(dto);
        validatePrice(dto);
        validateCar(dto);
    }

    private void validateDateAndTime(CarServicePostDto dto){
        if (dto.getDateAndTime() == null){
            throw new IllegalStateException("Date and time not found.");
        }
    }

    private void validateEmployeeFirstName(CarServicePostDto dto){
        if (dto.getEmployeeFirstName() == null){
            throw new IllegalStateException("Employee first name not found.");
        }
    }

    private void validateEmployeeLastName(CarServicePostDto dto){
        if(dto.getEmployeeLastName() == null){
            throw new IllegalStateException("Employee last name not found.");
        }
    }

    private void validateWorkDescription(CarServicePostDto dto){
        if(dto.getWorkDescription() == null){
            throw new IllegalStateException("Work description not found.");
        }
    }

    private void validatePrice(CarServicePostDto dto){
        if(dto.getPrice()==null){
            throw new IllegalStateException("Price not found.");
        }
    }

    private void validateCar(CarServicePostDto dto){
        validateCarExists(dto);
        validateCarEntityExists(dto);
    }

    private void validateCarExists(CarServicePostDto dto) {
        if (dto.getCar() == null) {
            throw new IllegalStateException("Car not found.");
        }
    }

    private void validateCarEntityExists(CarServicePostDto dto) {
        carService.getById(dto.getCar());
    }

}
