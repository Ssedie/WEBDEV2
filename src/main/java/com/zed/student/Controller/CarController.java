package com.zed.student.Controller;

import com.zed.student.Service.CarService;
import com.zed.student.Class.Car;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CarController {

    @Autowired
    CarService carService;

    @GetMapping("/")
    public String index(@RequestParam(defaultValue = "") String search, Model model) {
        List<Car> cars = carService.searchCar(search); // ✅ only keep this
        model.addAttribute("cars", cars);
        model.addAttribute("activeMenu", "home");
        return "index";
    }

    @GetMapping("/delete")
    public String deleteCar(@RequestParam int id) {
        carService.deleteCar(id);
        return "redirect:/";
    }

    @GetMapping("/new")
    public String add(Model model) {
        Car car = new Car();
        model.addAttribute("car", car);
        model.addAttribute("activeMenu", "new");

        model.addAttribute("types", new String[]{"Gasoline", "Diesel", "Electric", "Hybrid"});
        model.addAttribute("sizes", new String[]{"Automatic", "Manual"});
        return "new";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("car") @Valid Car car, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("types", new String[]{"Gasoline", "Diesel", "Electric", "Hybrid"});
            model.addAttribute("sizes", new String[]{"Automatic", "Manual"});
            return "new";
        }

        carService.addCar(car); // ✅ let service assign ID
        return "redirect:/";
    }

    @GetMapping("/edit")
    public String edit(@RequestParam int id, Model model) {
        Car c = carService.getCarById(id);
        if (c != null) {
            model.addAttribute("car", c);
            model.addAttribute("types", new String[]{"Gasoline", "Diesel", "Electric", "Hybrid"});
            model.addAttribute("sizes", new String[]{"Automatic", "Manual"});
            return "edit";
        }
        return "redirect:/";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("car") @Valid Car car, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("types", new String[]{"Gasoline", "Diesel", "Electric", "Hybrid"});
            model.addAttribute("sizes", new String[]{"Automatic", "Manual"});
            return "edit";
        }

        carService.updateCar(car.getId(), car);
        return "redirect:/";
    }

    @GetMapping("/car/{id}")
    public String view(@PathVariable int id, Model model) {
        Car c = carService.getCarById(id);
        model.addAttribute("car", c);
        return "view"; // create a simple view.html
    }
}
