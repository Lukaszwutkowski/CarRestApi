package com.homework2springboot.carrestapi.controller;

import com.homework2springboot.carrestapi.exceptions.CarNotFoundException;
import com.homework2springboot.carrestapi.model.Car;
import com.homework2springboot.carrestapi.service.CarServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/cars")
public class CarController {
    private CarServiceImpl carService;

    @Autowired
    public CarController(CarServiceImpl carService) {
        this.carService = carService;
    }

    @GetMapping
    public ResponseEntity<List<Car>> getCars(){
        List<Car> allCars = carService.getAllCars();
        return new ResponseEntity<>(allCars, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Car> getCarById(@PathVariable long id){
        Optional<Car> carById = carService.getCarById(id);
        return carById
                .map(car -> new ResponseEntity<>(car, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/color/{color}")
    public ResponseEntity<List<Car>> getCarsByColor(@PathVariable String color){
        List<Car> allCarsByColor = carService.getCarsByColor(color);
        return new ResponseEntity<>(allCarsByColor, HttpStatus.OK);
    }

    @PostMapping
    private ResponseEntity<Car> addNewCar(@RequestBody Car car){
        carService.addNewCar(car);
        return new ResponseEntity<>(car, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Car> updateExistingCar(@PathVariable long id, @RequestBody Car udatedCar) {
        try {
            carService.updateCar(id, udatedCar);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (CarNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Car> deleteCar(@PathVariable long id){
        try {
            carService.deleteCar(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (CarNotFoundException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
