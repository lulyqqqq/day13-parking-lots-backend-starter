package org.afs.pakinglot.service;

import jakarta.annotation.Resource;
import org.afs.pakinglot.domain.ParkingLot;
import org.afs.pakinglot.repository.ParkingLotRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParkingLotService {

    @Resource
    private ParkingLotRepository parkingLotRepository;

    public List<ParkingLot> getAllParkingLots() {
        return parkingLotRepository.getAllParkingLots();
    }
}
