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

    final String GET_CUSTOMER="SELECT * FROM customer";
    final String GET_CUSTOMERID="SELECT * FROM customer WHERE customer_id=?";
    final String CHECK_CUSTOMER_LOGIN="SELECT * FROM customer WHERE email=? and password=?";
    final String INSERT_SQL = "INSERT INTO `digitalden`.`customer` (`customer_name`, `email`, `contact`, `address`, `dob`, `password`) VALUES (?,?,?,?,?,?)";
    final String UPDATE_SQL="UPDATE `digitalden`.`customer` SET `customer_name` = ?, `email` = ?, `contact` = ?, `address` = ?, `dob` = ?, `password` = ? WHERE (`customer_id` = ?);";

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
                return ResponseEntity.status(HttpStatus.OK).body("Login Successfully");
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Login Failed !!! Retry");
    }


    @Override
    public ResponseEntity<String> setCustomer(Customer customer) throws SQLException {
        Connection con = DriverManager.getConnection((String)env.getProperty("spring.datasource.url"),(String)env.getProperty("spring.datasource.username"),(String)env.getProperty("spring.datasource.password"));
        PreparedStatement statement = con.prepareStatement(INSERT_SQL);
        try
        {
            statement.setString(1, customer.getCustomer_name());
            statement.setString(2, customer.getEmail());
            statement.setString(3, customer.getContact());
            statement.setString(4, customer.getAddress());
            statement.setString(5, customer.getDob());
            statement.setString(6, customer.getPassword());
            statement.execute();
            return ResponseEntity.status(HttpStatus.OK).body("Inserted Successfully");
        }
        catch (Exception e)
        {

        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not Inserted Successfully");
    }

    @Override
    public ResponseEntity<String> updateCustomer(Customer customer) throws SQLException {
        Connection con = DriverManager.getConnection((String)env.getProperty("spring.datasource.url"),(String)env.getProperty("spring.datasource.username"),(String)env.getProperty("spring.datasource.password"));
        PreparedStatement statement = con.prepareStatement(UPDATE_SQL);
        try {
            statement.setString(1, customer.getCustomer_name());
            statement.setString(2, customer.getEmail());
            statement.setString(3, customer.getContact());
            statement.setString(4, customer.getAddress());
            statement.setString(5, customer.getDob());
            statement.setString(6, customer.getPassword());
            statement.setInt(7, customer.getCustomer_id());
            statement.execute();
            return ResponseEntity.status(HttpStatus.OK).body("Updated Successfully");
        }
        catch (Exception e)
        {

        }
       return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not Updated Successfully");
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
