package com.nipun.Spring.Security.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
@Slf4j
public class ProductController {

    private record Product(String name, String description) {
    }

    List<Product> productList = new ArrayList<>(
            List.of(new Product("test_name_1", "test_description_1"),
                    new Product("test_name_2", "test_description_2"),
                    new Product("test_name_3", "test_description_3")
            ));

    @RequestMapping("/list")
    public List<Product> list() {
        return productList;
    }

    @RequestMapping("/add")
    public Product addProduct(@PathVariable String name, @PathVariable String description) {
        Product product = new Product(name, description);
        productList.add(product);
        return product;
    }
}
