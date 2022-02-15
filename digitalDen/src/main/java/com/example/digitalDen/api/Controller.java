package com.example.digitalDen.api;

import com.example.digitalDen.services.CategoryService;
import com.example.digitalDen.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Controller {
    @Autowired
    private ProductService productServices;

    @Autowired
    private CategoryService categoryService;
}
