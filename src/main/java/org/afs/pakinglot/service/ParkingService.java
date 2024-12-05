package org.afs.pakinglot.service;

import org.afs.pakinglot.domain.*;
import org.afs.pakinglot.repository.ParkingLotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParkingService {
    private final ParkingManager parkingManager;

    @Autowired
    public ParkingService(ParkingLotRepository parkingLotRepository) {
        List<ParkingLot> parkingLots = parkingLotRepository.findAll();
        this.parkingManager = new ParkingManager(parkingLots);
    }

    public List<ParkingLot> getAllParkingLots() {
        return parkingManager.getAllParkingLots();
    }

    public Ticket parkCar(String plateNumber, String parkingBoyType) {
        return parkingManager.parkCar(plateNumber, parkingBoyType);
    }

    public Car fetchCar(String plateNumber) {
        Ticket ticket = parkingManager.getAllParkingLots().stream()
                .flatMap(parkingLot -> parkingLot.getTickets().stream())
                .filter(t -> t.plateNumber().equals(plateNumber))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Ticket not found for plate number: " + plateNumber));
        return parkingManager.fetchCar(ticket);
    }
}