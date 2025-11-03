package org.midterm.zed.API;


import jakarta.validation.Valid;
import org.midterm.zed.CLASS.Car;
import org.midterm.zed.CLASS.Store;
import org.midterm.zed.DTO.StoreDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiStoreController {
    private StoreService storeService;

    public ApiStoreController(StoreService storeService) {
        this.storeService = storeService;
    }

    @GetMapping("/cars")
    public List<Store> getInventory() {
        return storeService.findAll();
    }

    @PostMapping("/cars")
    public Store addItem(@Valid @RequestBody StoreDTO store) {
        return storeService.save(store);
    }

    @PutMapping("/cars/{id}")
    public Store updateItem(@PathVariable int id, @Valid @RequestBody StoreDTO store){
        Store updateItem = storeService.findById(id);
        if (updateItem == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Item with ID "+ id + " not found.");
        }
        return storeService.updateItem(updateItem, store);
    }

    @DeleteMapping("/cars/{id}")
    public void deleteItem(@PathVariable int id){
        if(storeService.findById(id) == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Car with ID "+ id + " not found.");
        }
        storeService.deleteCar(id);
    }

}
