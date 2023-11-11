package com.homework2springboot.carrestapi.exceptions;

public class CarNotFoundException extends RuntimeException {
    public CarNotFoundException(String message){
        super(message);
    }
}
