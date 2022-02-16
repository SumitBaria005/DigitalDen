package com.example.digitalDen.repository.impl;

import com.example.digitalDen.db.util.JDBCAccess;
import com.example.digitalDen.db.util.JPAAccess;
import com.example.digitalDen.entities.Category;
import com.example.digitalDen.repository.CategoryRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CategoryRepositoryImplementation implements CategoryRepository {

    public static final String GET_ALL_CATEGORIES = "SELECT * FROM digitalden.category_data";
    public static final String GET_CATEGORY_FROM_ID = "SELECT * FROM digitalden.category_data WHERE id = ?";

    @Inject
    JDBCAccess jdbcAccess;

    @Inject
    JPAAccess jpaAccess;

    @Override
    public List<Category> getCategories(Integer pageNo, Integer pageSize) {
        return jdbcAccess.find(GET_ALL_CATEGORIES, new RowMapper<Category>() {
            @Override
            public Category mapRow(ResultSet rs, int rowNum) throws SQLException {
                Category category = new Category();
                category.setCategoryName(rs.getString("category_name"));
                category.setId(rs.getLong("id"));
                category.setProductId(rs.getLong("product_id"));
                return category;
            }
        });
    }

    @Override
    public Category getCategory(Integer categoryId) {
        try{
            Category category =  jdbcAccess.findOne(GET_CATEGORY_FROM_ID, new RowMapper<Category>() {
                @Override
                public Category mapRow(ResultSet rs, int rowNum) throws SQLException {
                    return new Category(rs.getLong("id"), rs.getString("category_name"), rs.getLong("product_id"));
                }
            }, categoryId);
            return category;
        } catch (Exception e){
            return null;
        }

    }

    @Override
    public void setCategory(Category category) {
        jpaAccess.save(category);
    }

    @Override
    public void updateCategory(Category category) {
        jpaAccess.update(category);
    }

    @Override
    public void deleteCategory(Category category) {
        jpaAccess.delete(category);
    }
}
