package com.example.digitalDen.controller;

import com.example.digitalDen.services.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;


@RestController
public class Controller {
    @Autowired
    private Services services;

}
