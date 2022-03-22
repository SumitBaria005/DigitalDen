package com.example.digitalDen.services.impl;

import com.example.digitalDen.entities.Customer;
import com.example.digitalDen.repository.CustomerRepository;
import com.example.digitalDen.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.List;

@Service
public class CustomerServiceImplementation implements CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    @Override
    public List<Customer> getCustomers() throws SQLException {
        return customerRepository.getCustomersData();
    }

    @Override
    public Customer getCustomer(Integer customerId) throws SQLException {
        return customerRepository.getCustomerData(customerId);
    }

    @Override
    public ResponseEntity<String> getCustomerLogin(String email, String password) throws SQLException {
        return customerRepository.getCustomerLoginData(email,password);
    }

    @Override
    public ResponseEntity<String> setCustomer(Customer customer) throws SQLException {
        return customerRepository.setCustomerData(customer);
    }

    @Override
    public ResponseEntity<String> updateCustomer(Customer customer) throws SQLException {
        return customerRepository.updateCustomerData(customer);
    }
}
