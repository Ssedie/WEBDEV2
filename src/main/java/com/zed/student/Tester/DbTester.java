package com.zed.student.Tester;

import com.zed.student.Class.Car;
import com.zed.student.Repository.CarRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DbTester implements CommandLineRunner {

    private final CarRepository carRepository;

    public DbTester(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public void run(String... args) throws Exception {
//        Car car = new Car();
//        car.setMake("Vios");
//        car.setYear(2017);
//        car.setMake("Toyota");
//        car.setColor("Grey");
//        carRepository.save(car);
//
//        carRepository.findAll().forEach(carRow -> {
//            System.out.println(carRow.getMake() + " " + carRow.getMake() + " " + carRow.getColor());
//        });

    }
}
