package org.midterm.zed.API;


import jakarta.validation.Valid;
import org.midterm.zed.CLASS.Product;
import org.midterm.zed.DTO.ProductDTO;
import org.midterm.zed.SERVICE.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = {"http://localhost:5500", "http://127.0.0.1:5500"})
public class ApiProductController {
    private final ProductService productService;

    public ApiProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public List<Product> getInventory() {
        return productService.findAll();
    }

    @PostMapping("/products")
    public Product addItem(@Valid @RequestBody ProductDTO store) {
        return productService.save(store);
    }

    @PutMapping("/products/{id}")
    public Product updateItem(@PathVariable int id, @Valid @RequestBody ProductDTO store){
        Product updateItem = productService.findById(id);
        if (updateItem == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Item with ID "+ id + " not found.");
        }
        return productService.updateItem(updateItem, store);
    }

    @DeleteMapping("/products/{id}")
    public void deleteItem(@PathVariable int id){
        if(productService.findById(id) == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Car with ID "+ id + " not found.");
        }
        productService.deleteItem(id);
    }

}
