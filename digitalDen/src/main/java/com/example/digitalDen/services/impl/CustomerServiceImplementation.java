package com.example.digitalDen.services.impl;

import com.example.digitalDen.api.response.MyUserPrincipal;

import com.example.digitalDen.api.response.User;
import com.example.digitalDen.entities.Customer;
import com.example.digitalDen.repository.CustomerRepository;
import com.example.digitalDen.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Service
@Transactional
public class CustomerServiceImplementation implements CustomerService, UserDetailsService {
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


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = customerRepository.getCustomerByEmail(email);
        if(user == null)
            throw new UsernameNotFoundException(email + "User Not Fount");

//        User userdetails = new User(customer.getEmail(), customer.getPassword(), new ArrayList<>());
        return new MyUserPrincipal(user);
    }
}
