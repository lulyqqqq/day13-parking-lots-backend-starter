package org.afs.pakinglot.domain;

import org.afs.pakinglot.domain.exception.InvalidPlateNumberException;
import org.afs.pakinglot.domain.exception.UnrecognizedTicketException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ParkingManagerTest {

    private ParkingManager parkingManager;

    @BeforeEach
    void setUp() {
        parkingManager = new ParkingManager();
    }

    @Test
    void should_initializeParkingManager_withThreeParkingLotsAndThreeParkingBoys() {
        List<ParkingLot> parkingLots = parkingManager.getAllParkingLots();
        assertEquals(3, parkingLots.size());
        assertEquals("The Plaza Park", parkingLots.get(0).getName());
        assertEquals("City Mall Garage", parkingLots.get(1).getName());
        assertEquals("Office Tower Parking", parkingLots.get(2).getName());
    }

    @Test
    void should_returnAllParkingLots_when_getAllParkingLots() {
        List<ParkingLot> parkingLots = parkingManager.getAllParkingLots();
        assertEquals(3, parkingLots.size());
    }

    @Test
    void should_parkCarUsingCorrectParkingBoy_andReturnValidTicket_when_park() {
        String plateNumber = "AB-1234";
        Ticket ticket = parkingManager.parkCar(plateNumber, "StandardParkingBoy");
        assertNotNull(ticket);
        assertEquals(plateNumber, ticket.plateNumber());
    }

    @Test
    void should_fetchCarUsingTicket_andReturnCorrectCar_when_fetch() {
        String plateNumber = "AB-1234";
        Ticket ticket = parkingManager.parkCar(plateNumber, "StandardParkingBoy");
        Car fetchedCar = parkingManager.fetchCar(ticket);
        assertNotNull(fetchedCar);
        assertEquals(plateNumber, fetchedCar.plateNumber());
    }

    @Test
    void should_throwExceptionForInvalidPlateNumber_when_park() {
        String invalidPlateNumber = "INVALID";
        assertThrows(InvalidPlateNumberException.class, () -> {
            parkingManager.parkCar(invalidPlateNumber, "StandardParkingBoy");
        });
    }

    @Test
    void should_throwExceptionForUnrecognizedTicket_when_fetch() {
        Ticket invalidTicket = new Ticket("AB-1234", 1, 1);
        assertThrows(UnrecognizedTicketException.class, () -> {
            parkingManager.fetchCar(invalidTicket);
        });
    }
}