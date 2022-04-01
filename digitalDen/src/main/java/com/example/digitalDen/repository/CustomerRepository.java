package com.example.digitalDen.repository;

import com.example.digitalDen.api.response.User;
import com.example.digitalDen.entities.Customer;
import org.springframework.http.ResponseEntity;

import java.sql.SQLException;
import java.util.List;

public interface CustomerRepository {
    List<Customer> getCustomersData() throws SQLException;
    Customer getCustomerData(Integer customerId) throws SQLException;
    ResponseEntity<String> getCustomerLoginData(String email, String password) throws SQLException;
    ResponseEntity<String>  setCustomerData(Customer customer) throws SQLException;
    ResponseEntity<String>  updateCustomerData(Customer customer) throws SQLException;
    User getCustomerByEmail(String email);
}
