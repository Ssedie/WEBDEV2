package org.midterm.zed.CONTROLLER;

import jakarta.validation.Valid;
import org.midterm.zed.CLASS.Store;
import org.midterm.zed.DTO.StoreDTO;
import org.midterm.zed.SERVICE.StoreService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class StoreController {

    private final StoreService storeService;

    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }

    @GetMapping("/store")
    public List<Store> getStore() {
        return storeService.findAll();
    }

    @PostMapping("/store")
    public Store addStore(@Valid @RequestBody StoreDTO store) {
        return storeService.save(store);
    }

    @PostMapping("/store/{id}")
    public Store updateStore(@PathVariable int id, @Valid @RequestBody StoreDTO store) {

    }
}
