package hr.neos.carservicerestaleksa.service;

import hr.neos.carservicerestaleksa.dto.*;
import hr.neos.carservicerestaleksa.entity.User;

import java.util.List;

public interface UserService {
    UserPostDto add (UserPostDto dto);

    User getById(Long id);

    UserGetDto getDtoById (Long id);

    List<User> getAll();

    List<UserGetDto> getAllDto();

    void deleteById (Long id);

}
