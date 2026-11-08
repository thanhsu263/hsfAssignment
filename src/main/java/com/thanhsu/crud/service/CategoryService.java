package com.thanhsu.crud.service;
import com.thanhsu.crud.entity.Category;
import com.thanhsu.crud.repository.CategoryRepository;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class CategoryService {
    private final CategoryRepository repository;
    public CategoryService(CategoryRepository repository) { this.repository = repository; }
    public List<Category> findAll() { return repository.findAll(); }
    public long count() { return repository.count(); }
    public Category save(Category category) { return repository.save(category); }
}
