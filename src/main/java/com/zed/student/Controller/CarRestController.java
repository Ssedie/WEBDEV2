package com.zed.student.Controller;

import com.zed.student.Class.Car;
import com.zed.student.Repository.CarRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api/cars")
public class CarRestController {

    private final CarRepository carRepository;

    public CarRestController(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @GetMapping
    public List<Car> getCars() {
        return carRepository.findAll();
    }

    @GetMapping("/{id}")
    public Car getCarById(@PathVariable int id) {
        return carRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Car not found"));
    }

    @PostMapping
    public Car createCar(@RequestBody Car car) {
        return carRepository.save(car);
    }

    @PutMapping("/{id}")
    public Car updateCar(@PathVariable int id, @RequestBody Car carDetails) {
        Car emp = carRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Car not found"));
        emp.setMake(carDetails.getMake());
        emp.setYear(carDetails.getYear());
        emp.setLicensePlateNumber(carDetails.getLicensePlateNumber());
        emp.setColor(carDetails.getColor());
        emp.setBodyType(carDetails.getBodyType());
        emp.setEngineType(carDetails.getEngineType());
        emp.setTransmission(carDetails.getTransmission());
        return carRepository.save(emp);
    }

    @DeleteMapping("/{id}")
    public void deleteCar(@PathVariable int id) {
        carRepository.deleteById(id);
    }
}
