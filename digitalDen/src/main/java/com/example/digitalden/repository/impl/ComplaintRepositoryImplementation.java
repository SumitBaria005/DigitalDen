package com.example.digitalDen.repository.impl;

import com.example.digitalDen.db.util.JPAAccess;
import com.example.digitalDen.entities.complaints.Complaints;
import com.example.digitalDen.repository.ComplaintRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;

@Repository
public class ComplaintRepositoryImplementation implements ComplaintRepository {
    @Inject
    JPAAccess jpaAccess;
    @Override
    public ResponseEntity<String> addComplaint(Complaints complaint) {
        jpaAccess.save(complaint);
        return  ResponseEntity.status(HttpStatus.OK).body("Your Complaint is Successfully Added! Thank you");
    }
}
