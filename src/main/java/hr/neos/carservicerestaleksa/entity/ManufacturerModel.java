package hr.neos.carservicerestaleksa.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ManufacturerModel {
    BMW_X6("BMW", "X6"),
    MERCEDES_MAYBACH("Mercedes", "Maybach"),
    SEAT_IBIZA("Seat", "Ibiza"),
    FERRARI_MARANELLO("Ferrari", "Maranello"),
    GOLF_4("Golf", "4"),
    AUDI_B4("Audi", "B4"),
    SUBARU_IMPREZA("Subaru", "Impreza"),
    TOYOTA_AURIS("Toyota", "Auris"),
    FORD_FOCUS("Ford", "Focus"),
    HONDA_CIVIC("Honda", "Civic");

    private final String manufacturer;
    private final String model;

}
