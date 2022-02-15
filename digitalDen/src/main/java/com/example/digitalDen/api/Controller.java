package com.example.digitalDen.api;

import com.example.digitalDen.entities.Customer;
import com.example.digitalDen.entities.Product;
import com.example.digitalDen.services.CustomerService;
import com.example.digitalDen.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import com.example.digitalDen.entities.Category;
import com.example.digitalDen.services.CategoryService;
import com.example.digitalDen.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class Controller {
    @Autowired
    private ProductService productService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CategoryService categoryService;


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
        return this.customerService.getCustomerLogin(email, password);
    }
    @GetMapping("/products/{product_id}")
    public Product getProduct(@PathVariable Integer product_id) throws SQLException {
        return this.productService.getProduct(product_id);
    }


    @GetMapping("/category")
    public List<Category> getCategory(@RequestParam(value = "pageNo", required = false) Integer pageNo, @RequestParam(value = "pageSize", required = false) Integer pageSize){
        pageNo = null == pageNo ? 1 : pageNo;
        pageSize = null == pageSize ? 20 : pageSize;
        return categoryService.getCategories(pageNo, pageSize);
    }

    @PostMapping("/customer")
    public ResponseEntity<String>  setCustomer(@RequestBody Customer customer) throws SQLException {
        return this.customerService.setCustomer(customer);
    }

    @PutMapping("/customer")
    public ResponseEntity<String>  updateCustomer(@RequestBody Customer customer) throws SQLException {
        return this.customerService.updateCustomer(customer);
    }
}
