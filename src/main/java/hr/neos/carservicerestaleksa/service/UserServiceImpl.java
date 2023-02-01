package hr.neos.carservicerestaleksa.service;

import hr.neos.carservicerestaleksa.dto.UserGetDto;
import hr.neos.carservicerestaleksa.dto.UserPostDto;
import hr.neos.carservicerestaleksa.entity.User;
import hr.neos.carservicerestaleksa.mapper.UserMapper;
import hr.neos.carservicerestaleksa.repository.UserRepository;
import hr.neos.carservicerestaleksa.validators.UserValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final UserValidator userValidator;

    @Override
    public UserGetDto add(UserPostDto dto) {
        userValidator.validate(dto);
        User user = userMapper.toEntity(dto);
        user = userRepository.save(user);
        return userMapper.toDto(user);
    }

    @Override
    public User getById(Long id) {
        return this.userRepository.findById(id).orElseThrow(() -> new
                NoSuchElementException("No user with id " + id + " exists."));
    }

    @Override
    public UserGetDto getDtoById(Long id) {
        return userMapper.toDto(getById(id));
    }

    @Override
    public List<User> getAll() {
        return this.userRepository.findAll();
    }

    @Override
    public List<UserGetDto> getAllDto() {
        return userMapper.manyToDto(getAll());
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

}
