package com.zed.prelimss.controller;

import com.zed.prelimss.Class.Employee;
import com.zed.prelimss.repository.EmployeeRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EmployeeController {

    EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("employees", employeeRepository.findAll());
        return "index";
    }

    @GetMapping("/new")
    public String newEmployee(Model model) {
        model.addAttribute("employees", new Employee());
        return "new";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") @Valid Employee employee) {

        employee = new Employee();
        employee.setName(employee.getName());
        employee.setEmail(employee.getEmail());
        employeeRepository.save(employee);
        return "redirect:/";
    }

    @GetMapping("/edit")
    public String editEmployee(@RequestParam int id, Model model) {

        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee with id " + id + " not found"));

        Employee employee1 = new Employee();
        employee1.setName(employee.getName());
        employee1.setEmail(employee.getEmail());

        model.addAttribute("employees", employeeRepository.findAll());
        return "edit";
    }

    @PostMapping("/update")
    public String updateEmployee(@ModelAttribute("employee") @Valid Employee employee) {

        employee = new Employee();
        employee.setName(employee.getName());
        employee.setEmail(employee.getEmail());

        employeeRepository.save(employee);
        return "redirect:/";
    }

}
