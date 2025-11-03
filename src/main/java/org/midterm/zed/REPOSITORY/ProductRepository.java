package org.midterm.zed.REPOSITORY;

import org.midterm.zed.CLASS.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
