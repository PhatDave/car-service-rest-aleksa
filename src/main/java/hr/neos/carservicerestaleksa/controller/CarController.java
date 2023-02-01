package hr.neos.carservicerestaleksa.controller;

import hr.neos.carservicerestaleksa.dto.CarGetDto;
import hr.neos.carservicerestaleksa.dto.CarPostDto;
import hr.neos.carservicerestaleksa.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/car")
@RequiredArgsConstructor
public class CarController {
    private final CarService carService;

    @PostMapping("/add")
    private ResponseEntity<?> add(@RequestBody CarPostDto carPostDto) {
        CarGetDto savedCar = carService.add(carPostDto);
        return new ResponseEntity<>(savedCar, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    private ResponseEntity<CarGetDto> getById(@PathVariable Long id) {
        try {
            CarGetDto car = carService.getDtoById(id);
            return new ResponseEntity<>(car, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
