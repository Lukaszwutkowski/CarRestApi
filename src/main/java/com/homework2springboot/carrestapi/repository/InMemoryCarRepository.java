package com.homework2springboot.carrestapi.repository;

import com.homework2springboot.carrestapi.model.Car;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class InMemoryCarRepository {

    private static final List<Car> carDatabase = new ArrayList<>();

    public List<Car> findAll(){
        return carDatabase;
    }

    public Optional<Car> findById(Long id){
        return carDatabase.stream()
                .filter(car -> Objects.equals(car.id(), id))
                .findFirst();
    }

    public List<Car> findByColor(String color) {
        color = color.toUpperCase().replace(" ", "_");
        String finalColor = color;
        return carDatabase.stream()
                .filter(car -> Objects.equals(car.color().toString(), finalColor))
                .collect(Collectors.toList());
    }

    public void save(Car car){
        carDatabase.add(car);
    }

    public void delete(long id){
        carDatabase.removeIf(car -> car.id() == id);
    }

    public void update(Car updatedCar) {
        Optional<Car> existingCar = findById(updatedCar.id());
        if (existingCar.isPresent()) {
            int index = carDatabase.indexOf(existingCar.get());
            carDatabase.set(index, updatedCar);
        }
    }
}
