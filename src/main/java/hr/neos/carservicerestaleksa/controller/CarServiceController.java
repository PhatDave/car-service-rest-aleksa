package hr.neos.carservicerestaleksa.controller;

import hr.neos.carservicerestaleksa.dto.CarGetDto;
import hr.neos.carservicerestaleksa.dto.CarPostDto;
import hr.neos.carservicerestaleksa.dto.CarServiceGetDto;
import hr.neos.carservicerestaleksa.dto.CarServicePostDto;
import hr.neos.carservicerestaleksa.service.CarServiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/car-service")
@RequiredArgsConstructor
public class CarServiceController {
    private final CarServiceService carServiceService;

    @PostMapping("/add")
    private ResponseEntity<?> add(@RequestBody CarServicePostDto carServicePostDto) {
        CarServiceGetDto savedCarService = carServiceService.add(carServicePostDto);
        return new ResponseEntity<>(savedCarService, HttpStatus.CREATED);
    }
}
