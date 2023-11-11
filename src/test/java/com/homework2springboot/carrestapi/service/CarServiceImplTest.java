package com.homework2springboot.carrestapi.service;

import com.homework2springboot.carrestapi.repository.InMemoryCarRepository;
import com.homework2springboot.carrestapi.model.Car;
import com.homework2springboot.carrestapi.model.Color;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class CarServiceImplTest {


    private CarServiceImpl carService;

    private InMemoryCarRepository carRepository;

    @BeforeEach
    public void setUp(){
        carRepository = new InMemoryCarRepository();
        carService = new CarServiceImpl(carRepository);
    }

    @Test
    void it_should_return_all_cars() {
        //given
        carRepository.save(new Car(1L, "Toyota", "Prius Plus", Color.BLACK));
        carRepository.save(new Car(2L, "Lexus", "RZ 450e", Color.EMERALD_GREEN));

        //when
        List<Car> result = carService.getAllCars();

        //then
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("Toyota", result.get(0).mark());
        assertEquals("Lexus", result.get(1).mark());
    }

    @Test
    void it_should_return_car_by_id() {
        //given
        Car createdCar = new Car(1L, "Toyota", "Prius Plus", Color.BLACK);
        carRepository.save(createdCar);

        //when
        Optional<Car> result = carService.getCarById(createdCar.id());

        //then
        assertTrue(result.isPresent());
        assertEquals(1L, result.get().id());
        assertEquals("Toyota", result.get().mark());
    }

    @Test
    void it_should_give_all_cars_by_chosen_color() {

        //given
        Color color = Color.WHITE;
        carRepository.save(new Car(1L, "Toyota", "Prius Plus", color));
        carRepository.save(new Car(2L, "Lexus", "RZ 450e", color));

        //when
        List<Car> result = carService.getCarsByColor(String.valueOf(color));

        //then
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals(color, result.get(0).color());
        assertEquals(color, result.get(1).color());
    }
}