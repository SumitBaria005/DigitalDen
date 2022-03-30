package com.example.digitalDen.repository.impl;

import com.example.digitalDen.db.util.HibernateAccess;
import com.example.digitalDen.db.util.JDBCAccess;
import com.example.digitalDen.db.util.JPAAccess;
import com.example.digitalDen.entities.Cart;
import com.example.digitalDen.entities.CartToProductMapping;
import com.example.digitalDen.entities.Product;
import com.example.digitalDen.repository.CartRepository;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.data.jpa.provider.HibernateUtils;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;



@Repository
public class CartRepositoryImplementation implements CartRepository {

    @Inject
    JPAAccess jpaAccess;

    @Inject
    JDBCAccess jdbcAccess;

    double totalPrice = 0.0;



    private String CART_DETAILS="SELECT * FROM digitalden.cart WHERE customer_id=?";
    private String SUM_OF_QUANTITY="SELECT SUM(quantity) as quantity FROM digitalden.carttoproductmapping where cart_id=?";
    private String SUM_OF_PRICE="SELECT * FROM digitalden.carttoproductmapping where cart_id=?";
    private String PRODUCT_DATA="SELECT * FROM digitalden.product WHERE id=?";

  //  private String INSERT_DATA="INSERT INTO digitalden.cart_to_product_mapping(cart_id,quantity,product_id) VALUES(?,?,?)";
    @Override
    public Cart addCart(CartToProductMapping cartMapping, int customerId) {
        jpaAccess.save(cartMapping);

        int cartId=cartMapping.getCartId();
        int totalQuantity=jdbcAccess.findOne(SUM_OF_QUANTITY, new RowMapper<Integer>() {
            @Override
            public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
                return rs.getInt("quantity");
            }
        },cartId);


        List<CartToProductMapping> cartToProductMapping=jdbcAccess.find(SUM_OF_PRICE, new RowMapper<CartToProductMapping>() {
            @Override
            public CartToProductMapping mapRow(ResultSet rs, int rowNum) throws SQLException {
                CartToProductMapping cartToProductMapping=new CartToProductMapping();
                Product product= getProduct(rs.getInt("product_id"));
                totalPrice =totalPrice+product.getPrice()*rs.getInt("quantity");
                //cartToProductMapping.setProduct(rs.g);
                return null;
            }
        },cartId);
        Cart cart=new Cart();
        cart.setQuantity(totalQuantity);
        cart.setId(cartId);
        cart.setTotalPrice(totalPrice);
        totalPrice=0.0;
        cart.setCustomerId(customerId);
        cart.setUpdatedDate("20-03-2022");
        cart.setCreatedDate("19-03-2022");
        jpaAccess.update(cart);
        return cart;
    }

    private Product getProduct(int id){
        return jdbcAccess.findOne(PRODUCT_DATA, new RowMapper<Product>() {
            @Override
            public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
               Product product=new Product();
               product.setPrice(rs.getDouble("price"));
               return product;
            }
        },id);
    }

    @Override
    public Cart getCart(Integer customerId) {
        Cart cartDetails=jdbcAccess.findOne(CART_DETAILS, new org.springframework.jdbc.core.RowMapper<Cart>() {
            @Override
            public Cart mapRow(ResultSet rs, int rowNum) throws SQLException {
                Cart cart=new Cart();
                cart.setId(rs.getInt("id"));
                cart.setCreatedDate(rs.getString("created_date"));
                cart.setCustomerId(rs.getInt("customer_id"));
                cart.setQuantity(rs.getInt("quantity"));
                cart.setTotalPrice(rs.getDouble("total_price"));
                cart.setUpdatedDate(rs.getString("updated_date"));
                return cart;
            }
        },customerId);
        return cartDetails;
    }
}
