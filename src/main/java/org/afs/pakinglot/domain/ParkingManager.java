package org.afs.pakinglot.domain;

import org.afs.pakinglot.domain.exception.InvalidPlateNumberException;
import org.afs.pakinglot.domain.exception.UnrecognizedTicketException;
import org.afs.pakinglot.domain.strategies.AvailableRateStrategy;
import org.afs.pakinglot.domain.strategies.MaxAvailableStrategy;
import org.afs.pakinglot.domain.strategies.SequentiallyStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class ParkingManager {
    private List<ParkingLot> parkingLots;
    private ParkingBoy standardParkingBoy;
    private ParkingBoy smartParkingBoy;
    private ParkingBoy superSmartParkingBoy;
    private static final Pattern PLATE_NUMBER_PATTERN = Pattern.compile("^[A-Z]{2}-\\d{4}$");

    public ParkingManager() {
        parkingLots = new ArrayList<>();
        parkingLots.add(new ParkingLot(1, "The Plaza Park", 9));
        parkingLots.add(new ParkingLot(2, "City Mall Garage", 12));
        parkingLots.add(new ParkingLot(3, "Office Tower Parking", 9));

        standardParkingBoy = new ParkingBoy(parkingLots, new SequentiallyStrategy());
        smartParkingBoy = new ParkingBoy(parkingLots, new MaxAvailableStrategy());
        superSmartParkingBoy = new ParkingBoy(parkingLots, new AvailableRateStrategy());
    }

    public ParkingManager(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
        standardParkingBoy = new ParkingBoy(parkingLots, new SequentiallyStrategy());
        smartParkingBoy = new ParkingBoy(parkingLots, new MaxAvailableStrategy());
        superSmartParkingBoy = new ParkingBoy(parkingLots, new AvailableRateStrategy());
    }

    public List<ParkingLot> getAllParkingLots() {
        return parkingLots;
    }

    public Ticket parkCar(String plateNumber, String parkingBoyType) {
        if (!isValidPlateNumber(plateNumber)) {
            throw new InvalidPlateNumberException("Invalid plate number: " + plateNumber);
        }
        Car car = new Car(plateNumber);
        ParkingBoy parkingBoy = getParkingBoy(parkingBoyType);
        return parkingBoy.park(car);
    }

    public Car fetchCar(Ticket ticket) {
        for (ParkingLot parkingLot : parkingLots) {
            if (parkingLot.contains(ticket)) {
                return parkingLot.fetch(ticket);
            }
        }
        throw new UnrecognizedTicketException();
    }

    private boolean isValidPlateNumber(String plateNumber) {
        return PLATE_NUMBER_PATTERN.matcher(plateNumber).matches();
    }

    private ParkingBoy getParkingBoy(String parkingBoyType) {
        return switch (parkingBoyType) {
            case "Standard" -> standardParkingBoy;
            case "Smart" -> smartParkingBoy;
            case "SuperSmart" -> superSmartParkingBoy;
            default -> throw new IllegalArgumentException("Invalid parking boy type: " + parkingBoyType);
        };
    }
}