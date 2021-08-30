package com.geekbrains.ru.springmvcdemo.controller;

import com.geekbrains.ru.springmvcdemo.domain.Product;
import com.geekbrains.ru.springmvcdemo.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/product")
@AllArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/show")
    public String getProducts(Model model) {
        List<Product> products = productService.findAll();

        model.addAttribute("products", products);

        return "products";
    }

    @GetMapping("/add")
    public String addProduct(Model model, @ModelAttribute("error") String error) {
        model.addAttribute("product", new Product());
        model.addAttribute("error", error);

        return "add-product";
    }

//    @GetMapping("/{id}")
//    public String getProduct(Model model, @PathVariable Long id) {
//        Product product = productService.findById(id).orElseThrow(IllegalArgumentException::new);
//
//        model.addAttribute("product", product);
//        return "/product";
//    }

    @PostMapping
    public RedirectView saveProduct(@ModelAttribute Product product, RedirectAttributes attributes) {
        if (product.getName().isEmpty()) {
            attributes.addFlashAttribute("error", "Name не может быть пустым");
            return new RedirectView("/product/add");
        }

        if (product.getId() == null) {
            throw new IllegalArgumentException();
        }

        productService.save(product);

        return new RedirectView("/product");
    }

    @ExceptionHandler(Exception.class)
    public String handleError(HttpServletRequest req, Exception ex) {
        System.err.println("Request: " + req.getRequestURL() + " raised " + ex);

        return "error";
    }

}
