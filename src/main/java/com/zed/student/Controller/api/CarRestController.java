package com.zed.student.Controller.api;

import com.zed.student.Class.Car;
import com.zed.student.DTO.CarDTO;
import com.zed.student.Repository.CarRepository;
import com.zed.student.Service.CarService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@CrossOrigin
@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api")
public class CarRestController {

    private final CarService carservice;
    private final CarRepository carRepository;

    public CarRestController(CarService carservice, CarRepository carRepository, CarService carService) {
        this.carservice = carservice;
        this.carRepository = carRepository;
    }

    @GetMapping("/cars")
    public List<Car> findAll() {
        return carservice.findAll();
    }


    @PostMapping("/cars")
    public Car createCar(@Valid @RequestBody CarDTO car) {
        return carservice.save(car);
    }

    @GetMapping("/cars/{id}")
    public Car getCarById(@PathVariable int id) {
        Car car = carservice.findById(id);
        if (car == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Car with Id: " + id + " does not exist");
        }
        return car;
    }

    @PutMapping("/cars/{id}")
    public Car updateCar(@PathVariable int id, @Valid @RequestBody CarDTO carDetails) {
        Car updatedCar = carservice.findById(id);
        if (updatedCar == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Car with Id: " + id + " does not exist");
        }
        return carservice.updateCar(id,carDetails);
    }

    @DeleteMapping("/cars/{id}")
    public void deleteCar(@PathVariable int id) {
        if (!carRepository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Car with Id: " + id + " does not exist");
        }
        carservice.deleteCar(id);
    }
}
