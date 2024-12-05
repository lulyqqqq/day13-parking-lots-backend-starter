package org.afs.pakinglot.controller;

import org.afs.pakinglot.Dto.CarResponseDto;
import org.afs.pakinglot.Dto.ParkRequestDto;
import org.afs.pakinglot.domain.Car;
import org.afs.pakinglot.domain.ParkingLot;
import org.afs.pakinglot.domain.Ticket;
import org.afs.pakinglot.service.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class ParkingController {

    private final ParkingService parkingService;

    @Autowired
    public ParkingController(ParkingService parkingService) {
        this.parkingService = parkingService;
    }

    @GetMapping("/parkinglots")
    public List<ParkingLot> getAllParkingLots() {
        return parkingService.getAllParkingLots();
    }

    @PostMapping("/park")
    public Ticket parkCar(@RequestBody ParkRequestDto requestDto) {
        return parkingService.parkCar(requestDto.getPlateNumber(), requestDto.getParkingBoyType());
    }

    @PostMapping("/fetch")
    public CarResponseDto fetchCar(@RequestBody String plateNumber) {
        Car car = parkingService.fetchCar(plateNumber);
        return new CarResponseDto(car.plateNumber());
    }
}