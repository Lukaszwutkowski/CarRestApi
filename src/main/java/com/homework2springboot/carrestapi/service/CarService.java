package com.homework2springboot.carrestapi.service;

import com.homework2springboot.carrestapi.model.Car;

import java.util.List;
import java.util.Optional;

public interface CarService {

    List<Car> getAllCars();

    Optional<Car> getCarById(long id);

    List<Car> getCarsByColor(String color);

}
