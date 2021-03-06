package com.example.digitalDen.services;

import com.example.digitalDen.api.request.CustomerLogInRequest;
import com.example.digitalDen.api.response.CustomerLoginResponse;
import com.example.digitalDen.entities.Customer;
import org.springframework.http.ResponseEntity;

import java.sql.SQLException;
import java.util.List;

public interface CustomerService {
    List<Customer> getCustomers() throws SQLException;
    Customer getCustomer(Integer customerId) throws SQLException;
    CustomerLoginResponse getCustomerLogin(String email, String password) throws SQLException;
    ResponseEntity<String>  setCustomer(Customer customer) throws SQLException;
    ResponseEntity<String>  updateCustomer(Customer customer) throws SQLException;


}
