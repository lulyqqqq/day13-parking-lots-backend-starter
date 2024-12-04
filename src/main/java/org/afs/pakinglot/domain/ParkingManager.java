package org.afs.pakinglot.domain;

import java.util.ArrayList;
import java.util.List;

public class ParkingManager {
    private List<ParkingLot> parkingLots;

    public ParkingManager() {
        parkingLots = new ArrayList<>();
        parkingLots.add(new ParkingLot(1, "The Plaza Park", 9));
        parkingLots.add(new ParkingLot(2, "City Mall Garage", 12));
        parkingLots.add(new ParkingLot(3, "Office Tower Parking", 9));
    }

    public List<ParkingLot> getParkingLots() {
        return parkingLots;
    }
}