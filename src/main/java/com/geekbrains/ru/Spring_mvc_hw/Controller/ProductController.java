package com.geekbrains.ru.Spring_mvc_hw.Controller;

import com.geekbrains.ru.Spring_mvc_hw.Domain.Product;
import com.geekbrains.ru.Spring_mvc_hw.Service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/product")
@AllArgsConstructor
public class ProductController {
    private ProductService productService;

    @GetMapping("/getproduct")
    public String getProducts(Model model) {
        List<Product> products = productService.getAllProducts();

        model.addAttribute("products", products);

        return "products";
    }

    @GetMapping("/addproduct")
    public String addProductPage(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        return "addProductPage";
    }

    @PostMapping("/addproduct")
    public String addProduct(@RequestParam int id, @RequestParam String title, @RequestParam double price, Model model) {

        productService.addNewProduct(id, title, price);
        return "redirect:/product/getproduct";
    }


}
