package com.thanhsu.crud.service;
import com.thanhsu.crud.entity.Product;
import com.thanhsu.crud.repository.ProductRepository;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import java.util.Optional;
@Service
public class ProductService {
    private final ProductRepository repository;
    public ProductService(ProductRepository repository) { this.repository = repository; }
    public Page<Product> search(String keyword, int page) {
        Pageable pageable = PageRequest.of(Math.max(page, 0), 5, Sort.by("id").ascending());
        return (keyword == null || keyword.isBlank()) ? repository.findAll(pageable) : repository.findByNameContainingIgnoreCaseOrIdContainingIgnoreCase(keyword.trim(), keyword.trim(), pageable);
    }
    public Optional<Product> findById(String id) { return repository.findById(id); }
    public boolean existsById(String id) { return repository.existsById(id); }
    public Product save(Product product) {
        if (product.getId() == null || product.getId().isBlank()) product.setId(nextId());
        return repository.save(product);
    }
    private String nextId() {
        // Find highest numeric ID by parsing all products (inefficient for large datasets, consider sequence table)
        return repository.findAll().stream()
                .map(Product::getId)
                .filter(id -> id != null && id.matches("P\\d{3,}"))
                .map(id -> Integer.parseInt(id.substring(1)))
                .max(Integer::compareTo)
                .map(max -> String.format("P%03d", max + 1))
                .orElse("P001");
    }
    public void deleteById(String id) { repository.deleteById(id); }
    public long count() { return repository.count(); }
    public long countLowStock() { return repository.countByQuantityLessThan(20); }
    public Page<Product> lowStock() { return repository.findByQuantityLessThan(20, PageRequest.of(0, 5, Sort.by("quantity").ascending())); }
}
