package com.example.digitalDen.services;

import com.example.digitalDen.entities.Category;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface CategoryService {

    public List<Category> getCategories(Integer pageNo, Integer pageSize);

    public void  setCategories(Category category);

    public void updateCategory(Category category);

    public ResponseEntity<String> deleteCategory(Integer categoryId);

    public Category getCategory(Integer categoryId);
}
