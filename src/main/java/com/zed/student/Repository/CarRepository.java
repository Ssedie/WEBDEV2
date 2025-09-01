package com.zed.student.Repository;

import com.zed.student.Class.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface CarRepository extends JpaRepository<Car, Integer> {
}
