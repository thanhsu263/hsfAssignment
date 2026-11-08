package com.thanhsu.crud.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.hibernate.annotations.Nationalized;
import java.math.BigDecimal;

@Entity
public class Product {
    @Id
    @Size(min = 4, max = 5, message = "Product ID must contain 4 to 5 characters")
    @Column(length = 10, columnDefinition = "varchar(10)")
    private String id;
    @NotBlank(message = "Name is required")
    @Pattern(regexp = "^[\\p{L}0-9][\\p{L}0-9\\s\\-()&.,']{2,99}$", message = "Name contains unsupported characters")
    @Nationalized @Column(nullable = false, length = 100) private String name;
    @NotNull(message = "Quantity is required") @Min(value = 5, message = "Quantity must be at least 5") @Max(value = 100, message = "Quantity must not exceed 100")
    private Integer quantity;
    @NotNull(message = "Price is required") @DecimalMin(value = "10000", message = "Price must be at least 10,000") @DecimalMax(value = "100000000", message = "Price must not exceed 100,000,000")
    @Column(nullable = false, precision = 15, scale = 2) private BigDecimal price;
    @ManyToOne(fetch = FetchType.EAGER) @JoinColumn(name = "category_id") private Category category;
    public Product() { }
    public Product(String id, String name, Integer quantity, BigDecimal price, Category category) { this.id=id; this.name=name; this.quantity=quantity; this.price=price; this.category=category; }
    public String getId() { return id; } public void setId(String id) { this.id=id; }
    public String getName() { return name; } public void setName(String name) { this.name=name; }
    public Integer getQuantity() { return quantity; } public void setQuantity(Integer quantity) { this.quantity=quantity; }
    public BigDecimal getPrice() { return price; } public void setPrice(BigDecimal price) { this.price=price; }
    public Category getCategory() { return category; } public void setCategory(Category category) { this.category=category; }
}
