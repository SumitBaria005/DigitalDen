package com.example.digitalDen.api;

import com.example.digitalDen.api.request.CustomerLogInRequest;
import com.example.digitalDen.api.request.RatingReviewRequest;
import com.example.digitalDen.api.response.RatingReviewResponse;
import com.example.digitalDen.entities.Categories.Mobiles;
import com.example.digitalDen.entities.Customer;
import com.example.digitalDen.entities.Product;
import com.example.digitalDen.entities.complaints.Complaints;
import com.example.digitalDen.services.*;
import io.jsonwebtoken.Jwt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import com.example.digitalDen.entities.Category;
import com.example.digitalDen.services.ProductService;

import javax.inject.Inject;
import java.util.List;


@RestController
public class Controller {
    @Autowired
    private ProductService productService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ComplaintService complaintService;

    @Autowired
    private RatingReviewService ratingReviewService;


    //Product Related APIs
    @GetMapping("/products")
    public List<Product> getProducts() throws SQLException {
        return this.productService.getProducts();
    }

    @PostMapping("/products")
    public void setProduct(@RequestBody Mobiles mobile){
        this.productService.setProduct(mobile);
    }

    @GetMapping("/products/{product_id}")
    public Product getProduct(@PathVariable Integer product_id) throws SQLException {
        return this.productService.getProduct(product_id);
    }

    //Account of Customer Related APIs
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



    @PostMapping("/customer")
    public ResponseEntity<String>  setCustomer(@RequestBody Customer customer) throws SQLException {
        return this.customerService.setCustomer(customer);
    }

    @PutMapping("/customer")
    public ResponseEntity<String>  updateCustomer(@RequestBody Customer customer) throws SQLException {
        return this.customerService.updateCustomer(customer);
    }

    //Category Related APIs
    @GetMapping("/category")
    public List<Category> getCategory(@RequestParam(value = "pageNo", required = false) Integer pageNo, @RequestParam(value = "pageSize", required = false) Integer pageSize){
        pageNo = null == pageNo ? 1 : pageNo;
        pageSize = null == pageSize ? 20 : pageSize;
        return categoryService.getCategories(pageNo, pageSize);
    }

    @GetMapping("/category/{categoryId}")
    public Category getCategory(@PathVariable Integer categoryId){
        return categoryService.getCategory(categoryId);
    }

    @PostMapping("/category")
    public void setCategory(@RequestBody Category category){
        categoryService.setCategories(category);
    }

    @PutMapping("/category")
    public void updateCategory(@RequestBody Category category){
        categoryService.updateCategory(category);
    }

    @DeleteMapping("/category/{categoryId}")
    public ResponseEntity<String> deleteCategory(@PathVariable Integer categoryId){
        return categoryService.deleteCategory(categoryId);
    }

    //Complaint Related APIs.
    @PostMapping("/complaint")
    public ResponseEntity<String> addComplaint(@RequestBody Complaints complaint){
        return this.complaintService.addComplaint(complaint);
    }


    //Rating & Review Related APIs.
    @GetMapping("/rating-for-product")
    public ResponseEntity<List<RatingReviewResponse>> getRatingReviewForProduct(@RequestParam Long productId){
        return  ratingReviewService.getRatingReviewForProduct(productId);
    }

    @GetMapping("/rating-for-customer")
    public ResponseEntity<List<RatingReviewResponse>> getRatingReviewForCustomer(@RequestParam Long customerId){
        return  ratingReviewService.getRatingReviewForCustomer(customerId);
    }

    @PutMapping("/rating")
    public void updateRatingReview(@RequestBody RatingReviewRequest ratingReviewRequest){
        ratingReviewService.updateRatingReview(ratingReviewRequest);
    }

    @PostMapping("/rating")
    public void addRatingforProduct(@RequestBody RatingReviewRequest ratingReviewRequest){
        ratingReviewService.addRatingforProduct(ratingReviewRequest);
    }

    @DeleteMapping("/rating/{ratingId}")
    public void deleteRatingReview(@PathVariable Long ratingId){
        ratingReviewService.deleteRatingReview(ratingId);
    }
}
