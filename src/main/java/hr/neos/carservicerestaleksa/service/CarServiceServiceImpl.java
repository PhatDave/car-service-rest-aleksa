package hr.neos.carservicerestaleksa.service;

import hr.neos.carservicerestaleksa.repository.CarServiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CarServiceServiceImpl implements CarServiceService{
    private final CarServiceRepository carServiceRepository;
}
