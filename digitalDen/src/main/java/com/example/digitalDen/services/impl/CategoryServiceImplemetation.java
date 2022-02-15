package com.example.digitalDen.services.impl;

import com.example.digitalDen.entities.Category;
import com.example.digitalDen.repository.CategoryRepository;
import com.example.digitalDen.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
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
        return categoryRepository.getCategory(pageNo, pageSize);
    }

    @Override
    public void setCategories(Category category) {
         categoryRepository.setCategory(category);
    }


}
