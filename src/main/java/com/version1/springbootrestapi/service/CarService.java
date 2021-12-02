package com.version1.springbootrestapi.service;

import com.version1.springbootrestapi.entity.Car;
import com.version1.springbootrestapi.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {
    @Autowired
    private CarRepository carRepository;

    // Create
    public Car createCar(Car car) {
        return carRepository.save(car);
    }

    public List<Car> createCars(List<Car> cars) {
        return carRepository.saveAll(cars);
    }

    // Read
    public Car readCar(int id) {
        return carRepository.findById(id).orElse(null);
    }

    // Update
    public Car updateCar(Car car) {
        Car carToUpdate = readCar(car.getId());

        if (carToUpdate == null) return null;

        carToUpdate.setBrand(car.getBrand());
        carToUpdate.setMileage(car.getMileage());
        carToUpdate.setPrice(car.getPrice());
        carToUpdate.setRegistration(car.getRegistration());

        return carRepository.save(carToUpdate);
    }

    // Delete
    public void deleteCar(int id) {
        carRepository.deleteById(id);
    }
}
