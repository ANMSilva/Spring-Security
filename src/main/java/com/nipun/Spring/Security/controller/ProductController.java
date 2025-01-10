package com.nipun.Spring.Security.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping
    public List<Product> list() {
        return productList;
    }

    @PostMapping
    public Product addProduct(@RequestBody Product request) {
        Product product = new Product(request.name(), request.description());
        productList.add(product);
        return product;
    }

    /**
     * CSRF Protection
     * Spring Security enables CSRF protection by default for non-GET methods (like POST, PUT, DELETE):
     *
     * If CSRF protection is active and you do not include a valid CSRF token in your POST request, it will be blocked.
     * GET requests are generally exempt from CSRF checks because they are not intended to modify server state.
     *
     * @Override
     * protected void configure(HttpSecurity http) throws Exception {
     *     http
     *         .csrf().disable()  // Disable CSRF for APIs
     *         .authorizeRequests()
     *         .antMatchers("/**").authenticated()
     *         .and()
     *         .httpBasic();
     * }
     * */
}
