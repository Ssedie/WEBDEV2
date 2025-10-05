package com.zed.student.Controller;

import com.zed.student.Class.Car;
import com.zed.student.DTO.CarDTO;
import com.zed.student.Exemptions.ResourceNotFoundException;
import com.zed.student.Repository.CarRepository;
import com.zed.student.Service.CarService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api")
public class CarRestController {

    private final CarService carservice;
    private final CarRepository carRepository;

    public CarRestController(CarService carservice, CarRepository carRepository) {
        this.carservice = carservice;
        this.carRepository = carRepository;
    }

    @GetMapping("/cars")
    public List<Car> findAll() {
        return carservice.findAll();
    }

    @PostMapping("/cars")
    public Car createCar(@RequestBody CarDTO car) {
        return carservice.save(car);
    }

    @PutMapping("cars/{id}")
    public Car updateCar(@PathVariable int id, @RequestBody CarDTO carDetails) {
        return carservice.save(carDetails);
    }

    @DeleteMapping("cars/{id}")
    public void deleteCar(@PathVariable int id) {
        if (!carRepository.existsById(id)){
            throw new ResourceNotFoundException("Car not found",id);
        }
        carservice.deleteCar(id);
    }
}
