package com.example.digitalDen.repository;

import com.example.digitalDen.entities.Category;

import java.util.List;

public interface CategoryRepository {
    public List<Category> getCategory(Integer pageNo);
}
