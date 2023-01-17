package hr.neos.carservicerestaleksa.controller;

import hr.neos.carservicerestaleksa.dto.UserPostDto;
import hr.neos.carservicerestaleksa.entity.User;
import hr.neos.carservicerestaleksa.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/add")
    private ResponseEntity<?> add(@RequestBody UserPostDto userPostDto){
        UserPostDto savedUser = userService.add(userPostDto);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }
}
