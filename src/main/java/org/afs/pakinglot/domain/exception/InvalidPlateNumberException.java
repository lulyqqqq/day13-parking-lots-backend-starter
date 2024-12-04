package org.afs.pakinglot.domain.exception;

public class InvalidPlateNumberException extends RuntimeException {
    public InvalidPlateNumberException(String message) {
        super(message);
    }
}