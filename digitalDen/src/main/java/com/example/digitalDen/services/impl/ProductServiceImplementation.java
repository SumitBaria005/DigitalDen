package com.example.digitalDen.services.impl;

import com.example.digitalDen.entities.Product;
import com.example.digitalDen.services.ProductService;
import org.springframework.core.env.Environment;

import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import javax.inject.Inject;


@Service
public class ProductServiceImplementation implements ProductService{
    @Inject
    Environment env;

    final String GET_PRODUCT="SELECT * FROM sql6472203.products";

    @Override
    public List<Product> getProducts() throws SQLException {
        List<Product> productList=new LinkedList<>();
        Connection con= DriverManager.getConnection(env.getProperty("spring.datasource.url"),env.getProperty("spring.datasource.username"),env.getProperty("spring.datasource.password"));
        Statement st=con.createStatement();
        ResultSet rs=st.executeQuery(GET_PRODUCT);
        while(rs.next()){
            Product product=new Product();
            product.setProduct_id(rs.getInt(1));
            product.setProduct_name(rs.getString(2));
            product.setProduct_description(rs.getString(3));
            product.setPrice(rs.getDouble(4));
            product.setCategory(rs.getString(5));
            product.setCompany_name(rs.getString(6));
            productList.add(product);
        }
        return productList;
    }

    @Override
    public Product getProduct(Integer product_id) throws SQLException {
        Connection con= DriverManager.getConnection(env.getProperty("spring.datasource.url"),env.getProperty("spring.datasource.username"),env.getProperty("spring.datasource.password"));
        Statement st=con.createStatement();
        ResultSet rs=st.executeQuery(GET_PRODUCT);
        if(!rs.next())return null;
        while(rs.getInt(1)!=product_id){
            if(!rs.next())return null;
        }
        Product product=new Product();
        product.setProduct_id(rs.getInt(1));
        product.setProduct_name(rs.getString(2));
        product.setProduct_description(rs.getString(3));
        product.setPrice(rs.getDouble(4));
        product.setCategory(rs.getString(5));
        product.setCompany_name(rs.getString(6));
        return product;
    }

}

