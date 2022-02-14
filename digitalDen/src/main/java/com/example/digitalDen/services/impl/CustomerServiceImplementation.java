package com.example.digitalDen.services.impl;

import com.example.digitalDen.entities.Customer;
import com.example.digitalDen.services.CustomerService;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import javax.inject.Inject;

@Service
public class CustomerServiceImplementation implements CustomerService {
    @Inject
    Environment env;

    final String GET_CUSTOMER="SELECT * FROM sql6472203.customer";
    final String GET_CUSTOMERID="SELECT * FROM sql6472203.customer WHERE customer_id=?";
    final String CHECK_CUSTOMER_LOGIN="SELECT * FROM sql6472203.customer WHERE email=? and password=?";

    @Override
    public List<Customer> getCustomers() throws SQLException {
       Connection con = DriverManager.getConnection((String)env.getProperty("spring.datasource.url"),(String)env.getProperty("spring.datasource.username"),(String)env.getProperty("spring.datasource.password"));
        List<Customer> customerList=new LinkedList<>();
        Statement st=con.createStatement();
        ResultSet rs=st.executeQuery(GET_CUSTOMER);
        while(rs.next()){
            Customer customer=new Customer();
            customerList.add(getCustomerData(customer,rs));
        }
        return customerList;
    }

    @Override
    public Customer getCustomer(Integer customerId) throws SQLException
    {
        Connection con = DriverManager.getConnection((String)env.getProperty("spring.datasource.url"),(String)env.getProperty("spring.datasource.username"),(String)env.getProperty("spring.datasource.password"));
        PreparedStatement statement = con.prepareStatement(GET_CUSTOMERID);
        statement.setString(1, String.valueOf(customerId));
        ResultSet rs = statement.executeQuery();
        Customer customer = new Customer();
        while(rs.next())
        {
            customer =getCustomerData(customer,rs);
        }
        return customer;
    }

    @Override
    public ResponseEntity<String> getCustomerLogin(String email, String password) throws SQLException {
        Connection con = DriverManager.getConnection((String)env.getProperty("spring.datasource.url"),(String)env.getProperty("spring.datasource.username"),(String)env.getProperty("spring.datasource.password"));
        PreparedStatement statement = con.prepareStatement(CHECK_CUSTOMER_LOGIN);
        statement.setString(1, email);
        statement.setString(2, password);
        ResultSet rs = statement.executeQuery();
        Customer customer = new Customer();
        while(rs.next())
        {
            customer.setEmail(rs.getString("email"));
            customer.setPassword(rs.getString("password"));
            if(customer.getEmail().equals(email) && customer.getPassword().equals(password))
            {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Login Successfully");
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Login Failed !!! Retry");
    }

    Customer getCustomerData(Customer customer,ResultSet rs) throws SQLException {
        customer.setCustomer_id(rs.getInt(1));
        customer.setCustomer_name(rs.getString(2));
        customer.setEmail(rs.getString(3));
        customer.setContact(rs.getString(4));
        customer.setAddress(rs.getString(5));
        customer.setDob(rs.getString(6));
        return customer;
    }
}
