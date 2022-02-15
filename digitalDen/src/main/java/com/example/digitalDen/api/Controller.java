package com.example.digitalDen.api;

import com.example.digitalDen.entities.Product;
import com.example.digitalDen.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;


@RestController
public class Controller {
    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public List<Product> getProducts() throws SQLException {
        return this.productService.getProducts();
    }

    @GetMapping("/products/{product_id}")
    public Product getProduct(@PathVariable Integer product_id) throws SQLException {
        return this.productService.getProduct(product_id);
    }
}
