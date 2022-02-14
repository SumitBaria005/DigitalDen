package com.example.digitalDen.api;

import com.example.digitalDen.services.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Controller {
    @Autowired
    private Services services;

}
