package com.example.digitalDen.services.impl;

import com.example.digitalDen.entities.Category;
import com.example.digitalDen.repository.CategoryRepository;
import com.example.digitalDen.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImplemetation implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public List<Category> getCategories(Integer pageNo, Integer pageSize) {
        return null;
    }
}
