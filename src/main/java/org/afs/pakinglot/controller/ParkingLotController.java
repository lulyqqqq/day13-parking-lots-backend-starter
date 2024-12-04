package org.afs.pakinglot.controller;

import jakarta.annotation.Resource;
import org.afs.pakinglot.domain.ParkingLot;
import org.afs.pakinglot.service.ParkingLotService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/parkinglots")
public class ParkingLotController {

    @Resource
    private ParkingLotService parkingLotService;

    @GetMapping
    public List<ParkingLot> getAllParkingLots() {
        return parkingLotService.getAllParkingLots();
    }
}
