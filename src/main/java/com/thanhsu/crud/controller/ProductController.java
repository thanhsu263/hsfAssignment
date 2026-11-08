package com.thanhsu.crud.controller;

import com.thanhsu.crud.entity.Product;
import com.thanhsu.crud.service.CategoryService;
import com.thanhsu.crud.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/products")
public class ProductController {
    private final ProductService products; private final CategoryService categories;
    public ProductController(ProductService products, CategoryService categories) { this.products=products; this.categories=categories; }
    @GetMapping public String list(@RequestParam(defaultValue = "") String keyword, @RequestParam(defaultValue = "0") int page, Model model) {
        model.addAttribute("products", products.search(keyword, page)); model.addAttribute("keyword", keyword); return "products";
    }
    @GetMapping("/new") public String createForm(Model model) { addFormData(model, new Product(), false); return "product-form"; }
    @GetMapping("/edit/{id}") public String editForm(@PathVariable String id, Model model, RedirectAttributes redirect) {
        Product product = products.findById(id).orElse(null);
        if (product == null) { redirect.addFlashAttribute("error", "Product not found."); return "redirect:/products"; }
        addFormData(model, product, true); return "product-form";
    }
    @PostMapping("/save") public String save(@Valid @ModelAttribute("product") Product product, BindingResult result,
                                                @RequestParam(defaultValue = "false") boolean editing, Model model, RedirectAttributes redirect) {
        if (result.hasErrors()) { addFormData(model, product, editing); return "product-form"; }
        products.save(product); redirect.addFlashAttribute("success", editing ? "Product updated successfully." : "Product created successfully."); return "redirect:/products";
    }
    @PostMapping("/delete/{id}") public String delete(@PathVariable String id, RedirectAttributes redirect) {
        if (products.existsById(id)) { products.deleteById(id); redirect.addFlashAttribute("success", "Product deleted successfully."); }
        else redirect.addFlashAttribute("error", "Product not found.");
        return "redirect:/products";
    }
    private void addFormData(Model model, Product product, boolean editing) { model.addAttribute("product", product); model.addAttribute("categories", categories.findAll()); model.addAttribute("editing", editing); }
}
