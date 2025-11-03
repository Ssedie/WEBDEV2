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

    public Store save(StoreDTO storeDTO) {
        Store product = new Store();
        product.setName(storeDTO.getName());
        product.setDescription(storeDTO.getDescription());
        product.setStock(storeDTO.getStock());
        product.setUnit(storeDTO.getUnit());
        product.setPrice(storeDTO.getPrice());
        return repository.save(product);
    }

    public Store updateItem(Store product, StoreDTO storeDTO) {
        product.setName(storeDTO.getName());
        product.setDescription(storeDTO.getDescription());
        product.setStock(storeDTO.getStock());
        product.setUnit(storeDTO.getUnit());
        product.setPrice(storeDTO.getPrice());
        return repository.save(product);
    }

    public void deleteItem(int id) {
        repository.deleteById(id);
    }
}
