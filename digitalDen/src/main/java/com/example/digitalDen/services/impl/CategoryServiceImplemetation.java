package com.example.digitalDen.services.impl;

import com.example.digitalDen.entities.Category;
import com.example.digitalDen.repository.CategoryRepository;
import com.example.digitalDen.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CategoryServiceImplemetation implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public List<Category> getCategories(Integer pageNo, Integer pageSize) {
        return categoryRepository.getCategories(pageNo, pageSize);
    }

    @Override
    public void setCategories(Category category) {
         categoryRepository.setCategory(category);
    }

    @Override
    public void updateCategory(Category category) {
        categoryRepository.updateCategory(category);
    }

    @Override
    public ResponseEntity<String> deleteCategory(Integer categoryId) {
        Category category = categoryRepository.getCategory(categoryId);
        if(category == null){
            return  ResponseEntity.status(HttpStatus.OK).body("Id Not Found");
        }
        categoryRepository.deleteCategory(category);
        return ResponseEntity.status(HttpStatus.OK).body("Deleted SuccessFull");
    }

    @Override
    public Category getCategory(Integer categoryId) {
        return categoryRepository.getCategory(categoryId);
    }


}
