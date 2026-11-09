package com.thanhsu.crud.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.Nationalized;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Category {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
    @Nationalized @Column(nullable = false, unique = true, length = 100) private String name;
    @Nationalized @Column(length = 500) private String description;
    @OneToMany(mappedBy = "category") private List<Product> products = new ArrayList<>();
    public Category() { }
    public Category(String name, String description) { this.name = name; this.description = description; }
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public List<Product> getProducts() { return products; }
}
