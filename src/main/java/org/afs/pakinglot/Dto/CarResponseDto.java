package org.afs.pakinglot.Dto;

public class CarResponseDto {
    private String plateNumber;

    public CarResponseDto(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    // Getter
    public String getPlateNumber() {
        return plateNumber;
    }
}