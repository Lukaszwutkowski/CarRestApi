package com.homework2springboot.carrestapi.service;

import com.homework2springboot.carrestapi.model.Car;
import com.homework2springboot.carrestapi.repository.InMemoryCarRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class CarServiceImpl implements CarService{

    public final InMemoryCarRepository carRepository;

    @Override
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    @Override
    public Optional<Car> getCarById(long id) {
        return carRepository.findById(id);
    }

    @Override
    public List<Car> getCarsByColor(String color) {
        return carRepository.findByColor(color);
    }
}
