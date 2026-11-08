package com.thanhsu.crud.repository;
import com.thanhsu.crud.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
public interface CategoryRepository extends JpaRepository<Category, Long> { }
