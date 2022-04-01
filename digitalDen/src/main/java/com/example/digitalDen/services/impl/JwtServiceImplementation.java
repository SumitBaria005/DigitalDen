package com.example.digitalDen.services.impl;

import com.example.digitalDen.api.request.CustomerLogInRequest;
import com.example.digitalDen.api.response.JwtResponse;
import com.example.digitalDen.jwt.JwtUtil;
import com.example.digitalDen.services.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtServiceImplementation implements JwtService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private CustomerServiceImplementation customerServiceImplementation;

    @Override
    public ResponseEntity<?> getCustomerToken(CustomerLogInRequest customerLogInRequest) throws Exception {

            System.out.println(customerLogInRequest);

            try{
                this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(customerLogInRequest.getUserName(), customerLogInRequest.getPassword()));
            } catch (UsernameNotFoundException e){
                e.printStackTrace();
                throw new Exception("Bad Credential");
            } catch (BadCredentialsException e){
                e.printStackTrace();
                throw new Exception("Bad Credentials");
            } catch (Exception e) {
                e.printStackTrace();
            }

            UserDetails userDetails = this.customerServiceImplementation.loadUserByUsername(customerLogInRequest.getUserName());

            String token = jwtUtil.generateToken(userDetails);
            System.out.println("Token: " + token);

            return ResponseEntity.ok(new JwtResponse(token));

    }

    
}
