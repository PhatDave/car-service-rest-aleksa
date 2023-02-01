package hr.neos.carservicerestaleksa.validators;

import hr.neos.carservicerestaleksa.dto.UserPostDto;
import hr.neos.carservicerestaleksa.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserValidator {
    private final UserRepository userRepository;

    public void validate(UserPostDto dto) {
        validateFirstName(dto);
        validateLastName(dto);
        validateOIB(dto);
    }

    private void validateFirstName(UserPostDto dto) {
        if (dto.getFirstName() == null) {
            throw new IllegalStateException("First name not found.");
        }
    }

    private void validateLastName(UserPostDto dto) {
        if (dto.getLastName() == null) {
            throw new IllegalStateException("Last name not found.");
        }
    }

    private void validateOIB(UserPostDto dto) {
        validateOibExists(dto);
        validateOibIsUnique(dto);
    }

    private void validateOibExists(UserPostDto dto) {
        if (dto.getOib() == null) {
            throw new IllegalStateException("OIB not found.");
        }
    }

    private void validateOibIsUnique(UserPostDto dto) {
        if (userRepository.existsByOib(dto.getOib())) {
            throw new IllegalStateException("User with OIB " + dto.getOib() + " already exists");
        }
    }
}
