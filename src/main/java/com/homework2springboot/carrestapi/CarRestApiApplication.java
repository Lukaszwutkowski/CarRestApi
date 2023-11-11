package com.homework2springboot.carrestapi;

import com.homework2springboot.carrestapi.model.Car;
import com.homework2springboot.carrestapi.model.Color;
import com.homework2springboot.carrestapi.repository.InMemoryCarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;


@SpringBootApplication
public class CarRestApiApplication implements CommandLineRunner {

    @Autowired
    private InMemoryCarRepository carRepository;

    public static void main(String[] args) {
        SpringApplication.run(CarRestApiApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Car car1 = new Car(1L,"Toyota", "BZ4X", Color.PEARL_WHITE);
        Car car2 = new Car(2L,"Lexus", "RZ450e", Color.EMERALD_GREEN);
        Car car3 = new Car(3L,"Mercedes-Benz", "EQB", Color.BLACK);
        Car car4 = new Car(4L,"Tesla", "Model Y", Color.MIDNIGHT_BLUE);
        Car car5 = new Car(5L,"Volkswagen", "ID4", Color.WHITE);
        Car car6 = new Car(6L,"Audi", "Q4 e-Tron", Color.WHITE);
        Car car7 = new Car(7L,"Tesla", "Model X", Color.BLACK);
        Car car8 = new Car(8L,"Mercedes-Benz", "EQE", Color.BLACK);
        Car car9 = new Car(9L,"Kia", "EV6", Color.MIDNIGHT_BLUE);
        Car car10 = new Car(10L,"Hyundai", "Ioniq 6", Color.DEEP_RED);

        List<Car> carsToSave = Arrays.asList(car1, car2, car3, car4, car5, car6, car7, car8, car9, car10);

        for (Car car : carsToSave) {
            carRepository.save(car);
        }
    }
}
