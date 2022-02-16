package com.example.digitalDen.services;

import com.example.digitalDen.entities.complaints.Complaints;
import org.springframework.http.ResponseEntity;

public interface ComplaintService {
    ResponseEntity<String> addComplaint(Complaints complaint);
}
