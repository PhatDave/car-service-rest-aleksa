package hr.neos.carservicerestaleksa.controller;

import hr.neos.carservicerestaleksa.dto.CarServiceGetDto;
import hr.neos.carservicerestaleksa.dto.CarServicePostDto;
import hr.neos.carservicerestaleksa.mapper.CarServiceMapper;
import hr.neos.carservicerestaleksa.service.CarServiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/car-service")
@RequiredArgsConstructor
public class CarServiceController {
    private final CarServiceService carServiceService;
    private final CarServiceMapper carServiceMapper;

    @PostMapping("/add")
    private ResponseEntity<?> add(@RequestBody CarServicePostDto carServicePostDto) {
        CarServiceGetDto savedCarService = carServiceService.add(carServicePostDto);
        return new ResponseEntity<>(savedCarService, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    private ResponseEntity<CarServiceGetDto> getById(@PathVariable Long id) {
        try {
            CarServiceGetDto carService = carServiceService.getDtoById(id);
            return new ResponseEntity<>(carService, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/all")
    private ResponseEntity<List<CarServiceGetDto>> getAllDto() {
        List<CarServiceGetDto> carServices = carServiceService.getAllDto();
        return new ResponseEntity<>(carServices, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Void> deleteById(@PathVariable Long id) {
        try {
            carServiceService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (EmptyResultDataAccessException emptyResultDataAccessException) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}/payment")
    private ResponseEntity<Void> updatePayment(@PathVariable Long id) {
        try {
            carServiceService.updatePayment(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
