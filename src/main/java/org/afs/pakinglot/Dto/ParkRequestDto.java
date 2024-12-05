package org.afs.pakinglot.Dto;

public class ParkRequestDto {
    private String plateNumber;
    private String parkingBoyType;

    // Getters and Setters
    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getParkingBoyType() {
        return parkingBoyType;
    }

    public void setParkingBoyType(String parkingBoyType) {
        this.parkingBoyType = parkingBoyType;
    }
}