package com.thanhsu.crud.controller;
import com.thanhsu.crud.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class DashboardController {
    private final ProductService products; private final CategoryService categories;
    public DashboardController(ProductService products, CategoryService categories) { this.products=products; this.categories=categories; }
    @GetMapping("/dashboard") public String dashboard(Model model) {
        model.addAttribute("totalProducts", products.count()); model.addAttribute("totalCategories", categories.count());
        model.addAttribute("lowStockCount", products.countLowStock());
        model.addAttribute("lowStockProducts", products.lowStock().stream().filter(p -> p.getQuantity() < 20).toList());
        return "dashboard";
    }
}
