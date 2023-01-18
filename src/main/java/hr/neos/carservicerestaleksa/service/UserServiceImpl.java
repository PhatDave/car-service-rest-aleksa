package hr.neos.carservicerestaleksa.service;

import hr.neos.carservicerestaleksa.dto.UserGetDto;
import hr.neos.carservicerestaleksa.dto.UserPostDto;
import hr.neos.carservicerestaleksa.entity.User;
import hr.neos.carservicerestaleksa.mapper.UserMapper;
import hr.neos.carservicerestaleksa.repository.UserRepository;
import lombok.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<UserGetDto> getById(Long id){
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            UserGetDto userGetDto = userMapper.to_dto(user);
            return new ResponseEntity<>(userGetDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
