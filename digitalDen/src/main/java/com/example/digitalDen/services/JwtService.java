package com.example.digitalDen.services;

import com.example.digitalDen.api.request.CustomerLogInRequest;
import org.springframework.http.ResponseEntity;

public interface JwtService {
    ResponseEntity<?> getCustomerToken(CustomerLogInRequest customerLogInRequest) throws Exception;


}
