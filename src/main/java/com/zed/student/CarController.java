package com.zed.student;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;

@Controller
public class CarController {

    @Autowired
    CarService carService;

    @GetMapping("/")
    public String index(@RequestParam(defaultValue = "") String search, HttpSession session, Model model) {
//        List<CoffeeExam> coffeeList = coffeeService.searchCoffee(search);
//        model.addAttribute("coffees", coffeeList);
        //AppUser user = (AppUser) session.getAttribute("user");
        //if(user == null) {return "redirect:/logout";}

        model.addAttribute("car", carService.searchCar(search));
        model.addAttribute("activeMenu", "home");

        return "index";
    }

//    @GetMapping("/catalog")
//    public String catalog(Model model, HttpSession session) {
//        //AppUser user = (AppUser) session.getAttribute("user");
//        //if(user == null) {return "redirect:/logout";}
//        model.addAttribute("car", carService.getCars());
//        model.addAttribute("activeMenu", "catalog");
//        return "catalog";
//    }

    /**
     *
     * @param id - (int) id of the coffee
     * @return - deletes the coffee that is listed
     */
    @GetMapping("/delete")
    public String deleteCoffee(@RequestParam int id, HttpSession session) {
        //AppUser user = (AppUser) session.getAttribute("user");
        //if(user == null) {return "redirect:/logout";}
        carService.deleteCar(id);
        return "redirect:/";
    }

    /**
     *
     * @return - goes to the new html for the adding of new coffee
     */
    @GetMapping("/add")
    public String add(Model model, HttpSession session) {
        //AppUser user = (AppUser) session.getAttribute("user");
        //if(user == null) {return "redirect:/logout";}
        model.addAttribute("types", new String[]{"Frappe", "Espresso", "Americano", "Latte", "Cappuccino", "Mocha", "Flat White", "Iced Coffee"});
        model.addAttribute("sizes", new String[]{"Small", "Medium", "Large"});
        model.addAttribute("roastLevels", new String[]{"Light", "Medium", "Dark"});
        model.addAttribute("brewMethods", new String[]{"Drip", "French Press", "Espresso", "Filter"});

        Car car = new Car();
        model.addAttribute("car", car);
        model.addAttribute("activeMenu", "new");

        return "new";
    }


    @PostMapping("/save")
    public String save(@ModelAttribute("coffeeExam") @Valid Car car, BindingResult bindingResult, @RequestParam(value = "imageFile") MultipartFile coffeePicture, Model model, HttpSession session) {
        //AppUser user = (AppUser) session.getAttribute("user");
        //if(user == null) {return "redirect:/logout";}

        if (bindingResult.hasErrors()) {
            model.addAttribute("types", new String[]{"Frappe", "Espresso", "Americano", "Latte", "Cappuccino", "Mocha", "Flat White", "Iced Coffee"});
            model.addAttribute("sizes", new String[]{"Small", "Medium", "Large"});
            model.addAttribute("roastLevels", new String[]{"Light", "Medium", "Dark"});
            model.addAttribute("brewMethods", new String[]{"Drip", "French Press", "Espresso", "Filter"});
            return "new";
        }

        car.setId(carService.getId() + 1);

        /**
        // Handle image upload
        if (!coffeePicture.isEmpty()) {

            String contentType = coffeePicture.getContentType();
            if (!contentType.startsWith("image")) {
                System.out.println("File is not an image: " + coffeePicture.getOriginalFilename());
                bindingResult.rejectValue("coffeePicture", "error.coffeePicture", "The uploaded file is not an image.");
                return "new";
            }

            String path = "data/coffee_pictures/";
            File uploadFolder = new File(path);
            if (!uploadFolder.exists()) {
                uploadFolder.mkdirs();
            }

            String fileName = UUID.randomUUID() + coffeePicture.getOriginalFilename().substring(coffeePicture.getOriginalFilename().lastIndexOf("."));
            try {
                coffeePicture.transferTo(new File(uploadFolder.getAbsolutePath() + File.separator + fileName));
                coffeeExam.setCoffeePicture(fileName);
                System.out.println(coffeeExam.getCoffeePicture());
            } catch (IOException e) {
                System.out.println("File upload error: " + e.getMessage());
            }
        }**/


        carService.addCar(car);
        return "redirect:/";
    }

    /**
     *
     * @param id - (int) id of the coffee
     * @param model - used to display the properties of the coffee
     * @return - goes to the edit.html and allows the user to edit the desired property of the coffee
     */
    @GetMapping("/edit")
    public String edit(@RequestParam int id, Model model, HttpSession session) {
        //AppUser user = (AppUser) session.getAttribute("user");
        //if(user == null) {return "redirect:/logout";}
        Car c = carService.getCarById(id);
        if(c != null){
            model.addAttribute("car", c);
            model.addAttribute("types", new String[]{"Frappe", "Espresso", "Americano", "Latte", "Cappuccino", "Mocha", "Flat White", "Iced Coffee"});
            model.addAttribute("sizes", new String[]{"Small", "Medium", "Large"});
            model.addAttribute("roastLevels", new String[]{"Light", "Medium", "Dark"});
            model.addAttribute("brewMethods", new String[]{"Drip", "French Press", "Espresso", "Filter"});

            return "edit";
        }
        return "redirect:/";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("coffeeExam") @Valid Car car, BindingResult bindingResult, Model model, HttpSession session) {
        //AppUser user = (AppUser) session.getAttribute("user");
        //if(user == null) {return "redirect:/logout";}

        if (bindingResult.hasErrors()) {
            model.addAttribute("car", car);
            model.addAttribute("types", new String[]{"Frappe", "Espresso", "Americano", "Latte", "Cappuccino", "Mocha", "Flat White", "Iced Coffee"});
            model.addAttribute("sizes", new String[]{"Small", "Medium", "Large"});
            model.addAttribute("roastLevels", new String[]{"Light", "Medium", "Dark"});
            model.addAttribute("brewMethods", new String[]{"Drip", "French Press", "Espresso", "Filter"});
            return "edit";
        }

        Car c = carService.getCarById(car.getId());
        //if(c != null){coffeeExam.setCoffeePicture(c.getCoffeePicture());coffeeService.updateCoffee(coffeeExam.getId(), coffeeExam);}
        return "redirect:/";
    }

    @GetMapping("/coffee/{id}")
    public String view(@PathVariable int id, Model model, HttpSession session) {
        //AppUser user = (AppUser) session.getAttribute("user");
        //if(user == null) {return "redirect:/logout";}

        Car c = carService.getCarById(id);
        model.addAttribute("coffeeExam", c);
        return "coffee";
    }
}
