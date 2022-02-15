package com.example.digitalDen.repository.impl;

import com.example.digitalDen.db.util.JDBCAccess;
import com.example.digitalDen.entities.Customer;
import com.example.digitalDen.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.sql.*;
import java.util.List;

@Repository
public class CustomerRepositoryImplementation implements CustomerRepository {
    @Inject
    Environment env;

    @Inject
    @Qualifier("jdbcAccess")
    JDBCAccess jdbcAccess;

    final String GET_CUSTOMER="SELECT * FROM customer";
    final String GET_CUSTOMERID="SELECT * FROM customer WHERE customer_id=?";
    final String CHECK_CUSTOMER_LOGIN="SELECT * FROM customer WHERE email=? and password=?";
    final String INSERT_SQL = "INSERT INTO `digitalden`.`customer` (`customer_name`, `email`, `contact`, `address`, `dob`, `password`) VALUES (?,?,?,?,?,?)";
    final String UPDATE_SQL="UPDATE `digitalden`.`customer` SET `customer_name` = ?, `email` = ?, `contact` = ?, `address` = ?, `dob` = ?, `password` = ? WHERE (`customer_id` = ?);";

    @Override
    public List<Customer> getCustomersData() throws SQLException
    {
        List<Customer> customerList = jdbcAccess.find(GET_CUSTOMER, new RowMapper<Customer>() {
            @Override
            public Customer mapRow(ResultSet rs, int rowNum) throws SQLException
            {
                Customer customer = new Customer();
                customer.setCustomer_id(rs.getInt("customer_id"));
                customer.setCustomer_name(rs.getString("customer_name"));
                customer.setEmail(rs.getString("email"));
                customer.setContact(rs.getString("contact"));
                customer.setAddress(rs.getString("address"));
                customer.setDob(rs.getString("dob"));
                return customer;
            }
        });
        return customerList;
    }

    @Override
    public Customer getCustomerData(Integer customerId) throws SQLException
    {
        Customer customer1 = jdbcAccess.findOne(GET_CUSTOMERID, new RowMapper<Customer>() {
            @Override
            public Customer mapRow(ResultSet rs, int rowNum) throws SQLException
            {
                Customer customer=new Customer();
                customer.setCustomer_id(rs.getInt("customer_id"));
                customer.setCustomer_name(rs.getString("customer_name"));
                customer.setEmail(rs.getString("email"));
                customer.setContact(rs.getString("contact"));
                customer.setAddress(rs.getString("address"));
                customer.setDob(rs.getString("dob"));
                return customer;
            }
        },customerId);
        return customer1;
    }

    @Override
    public ResponseEntity<String> getCustomerLoginData(String email, String password) throws SQLException {
        return  jdbcAccess.findOne(CHECK_CUSTOMER_LOGIN, new RowMapper<ResponseEntity<String>>() {
            @Override
            public ResponseEntity<String> mapRow(ResultSet rs, int rowNum) throws SQLException
            {
                if(rs.getString("email").equals(email) && rs.getString("password").equals(password))
                {
                    return ResponseEntity.status(HttpStatus.OK).body("Login Successfully");
                }
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Login Failed !!! Retry");
            }
        },email,password);
    }


    @Override
    public ResponseEntity<String> setCustomerData(Customer customer) throws SQLException {
        return  jdbcAccess.findOne(INSERT_SQL, new RowMapper<ResponseEntity<String>>() {
            @Override
            public ResponseEntity<String> mapRow(ResultSet rs, int rowNum) throws SQLException
            {
                try
                {
                    Customer customer=new Customer();
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
        });
    }

    @Override
    public ResponseEntity<String> updateCustomerData(Customer customer) throws SQLException {
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
