package com.zed.prelimss.repository;

import com.zed.prelimss.Class.Employee;
import org.springframework.data.jpa.repository.JpaRepository;



public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

}
