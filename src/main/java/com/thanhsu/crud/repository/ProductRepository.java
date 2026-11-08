package com.thanhsu.crud.repository;
import com.thanhsu.crud.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ProductRepository extends JpaRepository<Product, String> {
    Page<Product> findByNameContainingIgnoreCaseOrIdContainingIgnoreCase(String name, String id, Pageable pageable);
    Page<Product> findByQuantityLessThan(int quantity, Pageable pageable);
    long countByQuantityLessThan(int quantity);
}
