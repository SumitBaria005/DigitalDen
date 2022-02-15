package com.example.digitalDen.repository.impl;

import com.example.digitalDen.entities.Category;
import com.example.digitalDen.repository.CategoryRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoryRepositoryImplementation implements CategoryRepository {
    @Override
    public List<Category> getCategory(Integer pageNo) {
        return null;
    }
}
