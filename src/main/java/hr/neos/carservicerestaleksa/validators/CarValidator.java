package hr.neos.carservicerestaleksa.validators;

import hr.neos.carservicerestaleksa.dto.CarPostDto;
import hr.neos.carservicerestaleksa.entity.ManufacturerModel;;
import hr.neos.carservicerestaleksa.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CarValidator {
    private final UserService userService;

    public void validate(CarPostDto dto) {
        validateEnumEntryExists(dto);
        validateOwner(dto);
        validateManufacturerModel(dto);
        validateProductionYear(dto);
        validateRegistration(dto);
        validateColor(dto);

    }

    private void validateOwner(CarPostDto dto) {
        validateOwnerExists(dto);
        validateOwnerEntityExists(dto);
    }

    private void validateOwnerExists(CarPostDto dto) {
        if (dto.getOwner() == null) {
            throw new IllegalStateException("Owner not found.");
        }
    }

    private void validateOwnerEntityExists(CarPostDto dto) {
        userService.getById(dto.getOwner());
    }

    private void validateManufacturerModel(CarPostDto dto) {
        if (dto.getManufacturerModel() == null) {
            throw new IllegalStateException("Manufacturer model not found.");
        }
    }

    private void validateProductionYear(CarPostDto dto) {
        if (dto.getProductionYear() == null) {
            throw new IllegalStateException("Production year not found.");
        }
    }

    private void validateRegistration(CarPostDto dto) {
        if (dto.getRegistration() == null) {
            throw new IllegalStateException("Registration not found.");
        }
    }

    private void validateColor(CarPostDto dto) {
        if (dto.getColor() == null) {
            throw new IllegalStateException("Color not found.");
        }
    }

    private void validateEnumEntryExists(CarPostDto dto) {
        ManufacturerModel[] values = ManufacturerModel.values();
        if (dto.getManufacturerModel() < 0 || dto.getManufacturerModel() > values.length) {
            throw new IllegalStateException("Manufacturer model must be in range 0-" + values.length);
        }
    }

}
