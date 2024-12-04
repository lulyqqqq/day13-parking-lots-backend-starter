package org.afs.pakinglot.repository;

import org.afs.pakinglot.domain.ParkingLot;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ParkingLotRepository {
    List<ParkingLot> parkingLots = new ArrayList<>();

    public ParkingLotRepository() {
        parkingLots.add(new ParkingLot(1, "The Plaza Park", 9));
        parkingLots.add(new ParkingLot(2, "City Mall Garage", 12));
        parkingLots.add(new ParkingLot(3, "Office Tower Parking", 9));
    }

    public List<ParkingLot> getAllParkingLots() {
        return parkingLots;
    }
}
