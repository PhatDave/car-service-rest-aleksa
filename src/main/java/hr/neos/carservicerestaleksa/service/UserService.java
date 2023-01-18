package hr.neos.carservicerestaleksa.service;

import hr.neos.carservicerestaleksa.dto.*;
import hr.neos.carservicerestaleksa.entity.User;

public interface UserService {
    UserPostDto add (UserPostDto dto);

    User getById(Long id);

    UserGetDto getDtoById (Long id);

}
