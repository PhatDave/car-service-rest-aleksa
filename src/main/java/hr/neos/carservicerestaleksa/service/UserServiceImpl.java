package hr.neos.carservicerestaleksa.service;

import hr.neos.carservicerestaleksa.dto.UserPostDto;
import hr.neos.carservicerestaleksa.entity.User;
import hr.neos.carservicerestaleksa.mapper.UserMapper;
import hr.neos.carservicerestaleksa.repository.UserRepository;
import lombok.*;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserPostDto add(UserPostDto dto){
        User user = userMapper.toEntity(dto);
        user = userRepository.save(user);
        return userMapper.toDto(user);
    }
}
