package com.homework2springboot.carrestapi.service;

import com.homework2springboot.carrestapi.exceptions.CarNotFoundException;
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
        Optional<Car> car = carRepository.findById(id);
        if (car.isEmpty()){
            throw new CarNotFoundException("Car not found with id: " + id);
        }
        return car;
    }

    @Override
    public List<Car> getCarsByColor(String color) {
        return carRepository.findByColor(color);
    }

    @Override
    public void addNewCar(Car car) {
        carRepository.save(car);
    }
    @Override
    public void deleteCar(long id) {
        Optional<Car> carToDelete = carRepository.findById(id);
        if (carToDelete.isEmpty()){
            throw new CarNotFoundException("Car not found with id: " + id);
        } else {
            carRepository.delete(carToDelete.get().id());
        }
    }
    @Override
    public void updateCar(long id, Car updatedCar) {
        Optional<Car> existingCar = carRepository.findById(id);
        if (existingCar.isEmpty()){
            throw new CarNotFoundException("Car not found with id: " + id);
        } else {
            Car carToUpdate = existingCar.get();
            Car updatedRecord = new Car(
                    carToUpdate.id(),
                    updatedCar.mark(),
                    updatedCar.model(),
                    updatedCar.color()
            );
            carRepository.update(updatedRecord);
        }
    }
}
