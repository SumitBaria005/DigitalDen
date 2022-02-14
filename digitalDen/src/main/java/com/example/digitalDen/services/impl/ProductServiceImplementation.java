package com.example.digitalDen.services.impl;

import com.example.digitalDen.entities.Product;
import com.example.digitalDen.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
        Connection con= DriverManager.getConnection((String)env.getProperty("spring.datasource.url"),(String)env.getProperty("spring.datasource.username"),(String)env.getProperty("spring.datasource.password"));
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

}

