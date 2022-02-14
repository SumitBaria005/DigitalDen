package com.example.digitalDen.api;

import com.example.digitalDen.entities.Customer;
import com.example.digitalDen.entities.Product;
import com.example.digitalDen.services.CustomerService;
import com.example.digitalDen.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;


@RestController
public class Controller {
    @Autowired
    private ProductService productService;
    @Autowired
    private CustomerService customerService;


    @GetMapping("/products")
    public List<Product> getProducts() throws SQLException {
        return this.productService.getProducts();
    }

    @GetMapping("/customers")
    public List<Customer> getCustomers() throws SQLException {
        return this.customerService.getCustomers();
    }

    @GetMapping("/customers/{customerId}")
    public Customer getCustomer(@PathVariable Integer customerId) throws SQLException {
        return this.customerService.getCustomer(customerId);
    }

    @GetMapping("/customer")
    public ResponseEntity<String> getCustomerLogin(@RequestParam String email, @RequestParam String password ) throws SQLException {
        return this.customerService.getCustomerLogin(email,password);
    }
}
