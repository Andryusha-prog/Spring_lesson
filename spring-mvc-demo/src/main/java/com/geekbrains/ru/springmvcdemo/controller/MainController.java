package com.geekbrains.ru.springmvcdemo.controller;

import com.geekbrains.ru.springmvcdemo.domain.Product;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/main")
public class MainController {

    //GET http://localhost:8080/alpha
    @GetMapping("/alpha")
    @ResponseBody
    private String getAlpha() {
        return "Alpha";
    }

    //POST http://localhost:8080/alpha
    @PostMapping("/alpha")
    @ResponseBody
    private String postAlpha(@RequestBody Product product) {
        return product.toString();
    }


}
