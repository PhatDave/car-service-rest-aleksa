package hr.neos.carservicerestaleksa.controller;

import hr.neos.carservicerestaleksa.dto.UserGetDto;
import hr.neos.carservicerestaleksa.dto.UserPostDto;
import hr.neos.carservicerestaleksa.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/add")
    private ResponseEntity<?> add(@RequestBody UserPostDto userPostDto) {
        UserGetDto savedUser = userService.add(userPostDto);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    private ResponseEntity<UserGetDto> getById(@PathVariable Long id) {
        try {
            UserGetDto user = userService.getDtoById(id);
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/all")
    private ResponseEntity<List<UserGetDto>> getAllDto() {
        List<UserGetDto> users = userService.getAllDto();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Void> deleteById(@PathVariable Long id) {
        try {
            userService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (EmptyResultDataAccessException emptyResultDataAccessException) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
