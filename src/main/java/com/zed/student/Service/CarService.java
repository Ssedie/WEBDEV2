package com.zed.student.Service;

import com.zed.student.Class.Car;
import com.zed.student.DTO.CarDTO;
import com.zed.student.Repository.CarRepository;
import org.springframework.stereotype.Service;

@Service
public class CarService {
    final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public void save(CarDTO carDTO) {
        Car car = new Car();
        car.setMake(carDTO.getMake());
        car.setYear(carDTO.getYear());
        car.setLicensePlateNumber(carDTO.getLicensePlateNumber());
        car.setColor(carDTO.getColor());

        carRepository.save(car);
    }
}
