package com.example.digitalDen.repository.impl;

import com.example.digitalDen.db.util.JDBCAccess;
import com.example.digitalDen.entities.Product;
import com.example.digitalDen.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ProductRepositoryImplementation implements ProductRepository {
    @Inject
    Environment env;

    @Inject
    @Qualifier("jdbcAccess")
    JDBCAccess jdbcAccess;

    final String GET_PRODUCT="SELECT * FROM products";
    final String GET_PRODUCT_BY_ID="SELECT * FROM digitalden.products where product_id=?";

    @Override
    public List<Product> getProducts() throws SQLException {
        List<Product> productList=jdbcAccess.find(GET_PRODUCT, new RowMapper<Product>() {
            @Override
            public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
                Product product=new Product();
                product.setProduct_id(rs.getInt("product_id"));
                product.setProduct_name(rs.getString("product_name"));
                product.setProduct_description(rs.getString("product_description"));
                product.setPrice(rs.getDouble("price"));
                product.setCategory(rs.getString("category"));
                product.setCompany_name(rs.getString("company_name"));
                return product;
            }
        });
        return productList;
    }

    @Override
    public Product getProduct(Integer product_id) throws SQLException {
        return jdbcAccess.findOne(GET_PRODUCT_BY_ID, new RowMapper<Product>() {
            @Override
            public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
                Product product=new Product();
                product.setProduct_id(rs.getInt("product_id"));
                product.setProduct_name(rs.getString("product_name"));
                product.setProduct_description(rs.getString("product_description"));
                product.setPrice(rs.getDouble("price"));
                product.setCategory(rs.getString("category"));
                product.setCompany_name(rs.getString("company_name"));
                return product;
            }
        },product_id);
    }
}
