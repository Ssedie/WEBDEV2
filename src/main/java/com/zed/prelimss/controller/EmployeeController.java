package com.zed.prelimss.controller;

import com.zed.prelimss.Class.Employee;
import com.zed.prelimss.DTO.EmployeeDTO;
import com.zed.prelimss.repository.EmployeeRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class   EmployeeController {

    EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping("/")
    public String index(Model model) {

        List<Employee> employees = employeeRepository.findAll();

        model.addAttribute("employees", employees);
        return "index";
    }

    @GetMapping("/new")
    public String newEmployee(Model model) {
        model.addAttribute("employees", new EmployeeDTO());
        return "new";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employees") @Valid EmployeeDTO employeeDTO, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("employees", employeeDTO);
            return "new";
        }

        if (employeeRepository.findByEmail(employeeDTO.getEmail()).isPresent()) {
            bindingResult.rejectValue("email", "error.employee", "Email already exists");
            return "new";
        }

        Employee employee1 = new Employee();
        employee1.setName(employeeDTO.getName());
        employee1.setEmail(employeeDTO.getEmail());
        employeeRepository.save(employee1);
        return "redirect:/";
    }

    @GetMapping("/edit")
    public String editEmployee(@RequestParam int id, Model model) {

        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee with id " + id + " not found"));

        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setId(employee.getId());
        employeeDTO.setName(employee.getName());
        employeeDTO.setEmail(employee.getEmail());
        model.addAttribute("employees", employeeDTO);
        return "edit";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam int id) {
        employeeRepository.deleteById(id);
        return "redirect:/";
    }

    @PostMapping("/update")
    public String updateEmployee(@ModelAttribute("employees") @Valid EmployeeDTO employeeDTO, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("employees", employeeDTO);
            return "edit";
        }

        if (employeeRepository.findByEmail(employeeDTO.getEmail()).isPresent()) {
            bindingResult.rejectValue("email", "error.employee", "Email already exists");
            return "edit";
        }

        Employee employee1 = employeeRepository.findById(employeeDTO.getId()).orElseThrow(() -> new RuntimeException("Employee with id " + employeeDTO.getId() + " not found"));
        employee1.setName(employeeDTO.getName());
        employee1.setEmail(employeeDTO.getEmail());

        employeeRepository.save(employee1);
        return "redirect:/";
    }

}
