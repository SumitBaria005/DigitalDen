package com.example.digitalDen.repository;

import com.example.digitalDen.entities.complaints.Complaints;
import org.springframework.http.ResponseEntity;

public interface ComplaintRepository {
    ResponseEntity<String> addComplaint(Complaints complaint);
}
