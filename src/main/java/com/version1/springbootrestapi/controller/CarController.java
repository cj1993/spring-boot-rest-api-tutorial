package com.version1.springbootrestapi.controller;

import com.version1.springbootrestapi.entity.Car;
import com.version1.springbootrestapi.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CarController {
    @Autowired
    private CarService carService;

    // Create -> POST
    @PostMapping("/car")
    public Car createCar(@RequestBody Car car) {
        return carService.createCar(car);
    }

    @PostMapping("/cars")
    public List<Car> createCars(@RequestBody List<Car> cars) {
        return carService.createCars(cars);
    }

    // Read   -> GET
    @GetMapping("/car/{id}")
    public Car getCar(@PathVariable int id) {
        return carService.readCar(id);
    }

    // Update -> PUT
    @PutMapping("/car")
    public Car updateCar(@RequestBody Car car) {
        return carService.updateCar(car);
    }

    // Delete -> DELETE
    @DeleteMapping("/car/{id}")
    public void deleteCar(@PathVariable int id) {
        carService.deleteCar(id);
    }
}
