package org.midterm.zed.SERVICE;

import org.midterm.zed.CLASS.Product;
import org.midterm.zed.DTO.ProductDTO;
import org.midterm.zed.REPOSITORY.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public List<Product> findAll() {
        return repository.findAll();
    }

    public Product findById(int id) {
        return repository.findById(id).orElse(null);
    }

    public Product save(ProductDTO productDTO) {
        Product product = new Product();
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setStock(productDTO.getStock());
        product.setUnit(productDTO.getUnit());
        product.setPrice(productDTO.getPrice());
        return repository.save(product);
    }

    public Product updateItem(Product product, ProductDTO productDTO) {
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setStock(productDTO.getStock());
        product.setUnit(productDTO.getUnit());
        product.setPrice(productDTO.getPrice());
        return repository.save(product);
    }

    public void deleteItem(int id) {
        repository.deleteById(id);
    }
}
