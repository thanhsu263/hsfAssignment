package com.thanhsu.crud.config;

import com.thanhsu.crud.entity.*;
import com.thanhsu.crud.service.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.math.BigDecimal;

@Configuration
public class DataInitializer {
    @Bean CommandLineRunner seedData(AccountService accounts, CategoryService categories, ProductService products) {
        return args -> {
            if (accounts.count() > 0) return;
            accounts.save(new Account("ad@a.com", "ad", 1)); accounts.save(new Account("st@a.com", "st", 2)); accounts.save(new Account("mb@a.com", "mb", 3));
            Category office = categories.save(new Category("Văn phòng", "Dụng cụ học tập và văn phòng"));
            Category tech = categories.save(new Category("Công nghệ", "Thiết bị số cho lớp học"));
            Category home = categories.save(new Category("Gia dụng", "Đồ dùng hằng ngày"));
            Category book = categories.save(new Category("Sách", "Sách tham khảo và kỹ năng"));
            add(products, "P001", "Bút bi xanh", 15, 10000, office); add(products, "P002", "Vở kẻ ngang", 48, 18000, office); add(products, "P003", "Bìa hồ sơ", 22, 25000, office); add(products, "P004", "Máy tính cầm tay", 12, 350000, tech);
            add(products, "P005", "Bàn phím cơ", 28, 850000, tech); add(products, "P006", "Chuột không dây", 18, 420000, tech); add(products, "P007", "Bình giữ nhiệt", 35, 280000, home); add(products, "P008", "Đèn học LED", 16, 390000, home);
            add(products, "P009", "Gối tựa lưng", 25, 210000, home); add(products, "P010", "Sách Java cơ bản", 17, 125000, book); add(products, "P011", "Sách Spring Boot", 30, 185000, book); add(products, "P012", "Sổ tay kế hoạch", 42, 65000, book);
            add(products, "P013", "Tai nghe học online", 19, 520000, tech); add(products, "P014", "Kẹp giấy màu", 55, 15000, office);
        };
    }
    private void add(ProductService service, String id, String name, int quantity, int price, Category category) { service.save(new Product(id, name, quantity, BigDecimal.valueOf(price), category)); }
}
