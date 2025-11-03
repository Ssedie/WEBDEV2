package org.midterm.zed.SERVICE;

import org.midterm.zed.CLASS.Store;
import org.midterm.zed.DTO.StoreDTO;
import org.midterm.zed.REPOSITORY.StoreRepository;

import java.util.List;

public class StoreService {

    private final StoreRepository repository;

    public StoreService(StoreRepository repository) {
        this.repository = repository;
    }

    public List<Store> findAll() {
        return repository.findAll();
    }

    public Store findById(int id) {
        return repository.findById(id).orElse(null);
    }

    public Store save(StoreDTO productDTO) {
        Store product = new Store();
        product.setName(storeDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setStock(productDTO.getStock());
        product.setUnit(productDTO.getUnit());
        product.setPrice(productDTO.getPrice());
        return repository.save(product);
    }

    public Product updateProduct(Product product, ProductDTO productDTO) {
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setStock(productDTO.getStock());
        product.setUnit(productDTO.getUnit());
        product.setPrice(productDTO.getPrice());
        return repository.save(product);
    }

    public void deleteProduct(int id) {
        repository.deleteById(id);
    }
}
