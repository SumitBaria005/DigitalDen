package com.example.digitalDen.repository;

import com.example.digitalDen.entities.Category;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CategoryRepository {
    public List<Category> getCategories(Integer pageNo, Integer pageSize);

    public void setCategory(Category category);

    public void updateCategory(Category category);

    public void deleteCategory(Category category);

    public Category getCategory(Integer categoryId);
}
