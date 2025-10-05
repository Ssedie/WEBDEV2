package com.zed.student.Service;

import com.zed.student.Class.Car;
import com.zed.student.DTO.CarDTO;
import com.zed.student.Exemptions.ResourceNotFoundException;
import com.zed.student.Repository.CarRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {
    final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<Car> findAll() {
        return carRepository.findAll();
    }

    public Car save(CarDTO carDTO) {
        Car car = new Car();
        car.setMake(carDTO.getMake());
        car.setModel(carDTO.getModel());
        car.setYear(carDTO.getYear());
        car.setLicensePlateNumber(carDTO.getLicensePlateNumber());
        car.setColor(carDTO.getColor());
        car.setBodyType(carDTO.getBodyType());
        car.setEngineType(carDTO.getEngineType());
        car.setTransmission(carDTO.getTransmission());

        return carRepository.save(car);
    }
    
    public Car updateCar(int id, CarDTO carDTO){
        Car car = carRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Car", id));
        car.setMake(carDTO.getMake());
        car.setModel(carDTO.getModel());
        car.setYear(carDTO.getYear());
        car.setLicensePlateNumber(carDTO.getLicensePlateNumber());
        car.setColor(carDTO.getColor());
        car.setBodyType(carDTO.getBodyType());
        car.setEngineType(carDTO.getEngineType());
        car.setTransmission(carDTO.getTransmission());
        return carRepository.save(car);
    }

    public void deleteCar(int id) {
        carRepository.deleteById(id);
    }
}
