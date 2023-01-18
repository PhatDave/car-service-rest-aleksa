package hr.neos.carservicerestaleksa.service;

import hr.neos.carservicerestaleksa.dto.UserGetDto;
import hr.neos.carservicerestaleksa.dto.UserPostDto;
import hr.neos.carservicerestaleksa.entity.User;
import hr.neos.carservicerestaleksa.mapper.UserMapper;
import hr.neos.carservicerestaleksa.repository.UserRepository;
import lombok.*;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserPostDto add(UserPostDto dto){
        User user = userMapper.toEntity(dto);
        user = userRepository.save(user);
        return userMapper.toDto(user);
    }

    @Override
    public User getById(Long id){
        Optional<User> optionalUser = userRepository.findById(id);
        if(optionalUser.isPresent()){
            User user = optionalUser.get();
            return user;
        }else{
            throw new NoSuchElementException("No user with " + id + " exists.");
        }
    }

    @Override
    public UserGetDto getDtoById(Long id){
        return userMapper.to_dto(getById(id));
    }
}
