package org.afs.pakinglot.domain;

import org.afs.pakinglot.domain.exception.InvalidPlateNumberException;
import org.afs.pakinglot.domain.strategies.ParkingStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class ParkingManager {
    private List<ParkingLot> parkingLots;
    private static final Pattern PLATE_NUMBER_PATTERN = Pattern.compile("^[A-Z]{2}-\\d{4}$");

    public ParkingManager() {
        parkingLots = new ArrayList<>();
        parkingLots.add(new ParkingLot(1, "The Plaza Park", 9));
        parkingLots.add(new ParkingLot(2, "City Mall Garage", 12));
        parkingLots.add(new ParkingLot(3, "Office Tower Parking", 9));
    }

    public List<ParkingLot> getParkingLots() {
        return parkingLots;
    }

    public Ticket parkCar(String plateNumber, ParkingStrategy strategy) {
        if (!isValidPlateNumber(plateNumber)) {
            throw new InvalidPlateNumberException("Invalid plate number: " + plateNumber);
        }
        Car car = new Car(plateNumber);
        ParkingLot selectedParkingLot = strategy.findParkingLot(parkingLots);
        return selectedParkingLot.park(car);
    }

    private boolean isValidPlateNumber(String plateNumber) {
        return PLATE_NUMBER_PATTERN.matcher(plateNumber).matches();
    }
}