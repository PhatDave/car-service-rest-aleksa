package hr.neos.carservicerestaleksa.service;

import hr.neos.carservicerestaleksa.dto.*;
import org.springframework.http.ResponseEntity;

public interface UserService {
    UserPostDto add (UserPostDto dto);
    ResponseEntity<UserGetDto> getById (Long id);
}
