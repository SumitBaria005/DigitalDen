package com.example.digitalDen.repository.impl;

import com.example.digitalDen.db.util.JDBCAccess;
import com.example.digitalDen.db.util.JPAAccess;
import com.example.digitalDen.entities.Category;
import com.example.digitalDen.repository.CategoryRepository;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CategoryRepositoryImplementation implements CategoryRepository {

    public static final String GET_ALL_CATEGORIES = "SELECT * FROM digitalden.category_data;";

    @Inject
    JDBCAccess jdbcAccess;

    @Inject
    JPAAccess jpaAccess;

    @Override
    public List<Category> getCategory(Integer pageNo, Integer pageSize) {
        List<Category> categoryList = jdbcAccess.find(GET_ALL_CATEGORIES, new RowMapper<Category>() {
            @Override
            public Category mapRow(ResultSet rs, int rowNum) throws SQLException {
                Category category = new Category();
                category.setCategoryName(rs.getString("category_name"));
                category.setId(rs.getLong("id"));
                category.setProductId(rs.getLong("product_id"));
                return category;
            }
        });
        return categoryList;
    }

    @Override
    public void setCategory(Category category) {
        jpaAccess.save(category);
    }
}
