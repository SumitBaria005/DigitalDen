package com.example.digitalDen.services.impl;

import com.example.digitalDen.entities.complaints.Complaints;
import com.example.digitalDen.repository.ComplaintRepository;
import com.example.digitalDen.services.ComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class ComplaintServiceImplementation implements ComplaintService {

    @Autowired
    private ComplaintRepository complaintRepository;

    @Override
    public ResponseEntity<String> addComplaint(Complaints complaint) {
        return this.complaintRepository.addComplaint(complaint);
    }
}
