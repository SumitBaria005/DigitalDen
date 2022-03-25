package com.example.digitalDen.services.impl;

import com.example.digitalDen.api.request.RatingReviewRequest;
import com.example.digitalDen.api.response.RatingReviewResponse;
import com.example.digitalDen.entities.RatingReview;
import com.example.digitalDen.repository.RatingReviewRepository;
import com.example.digitalDen.services.RatingReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class RatingReviewServiceImplementation implements RatingReviewService {

    @Autowired
    private RatingReviewRepository ratingReviewRepository;

    @Override
    public ResponseEntity<List<RatingReviewResponse>> getRatingReviewForProduct(Long productId) {
        List<RatingReviewResponse> ratingReviewResponseList = new ArrayList<RatingReviewResponse>();

        ratingReviewResponseList = ratingReviewRepository.getRatingReviewForProduct(productId);

        return  ResponseEntity.status(HttpStatus.OK).body(ratingReviewResponseList);
    }

    @Override
    public ResponseEntity<List<RatingReviewResponse>> getRatingReviewForCustomer(Long customerId) {
        List<RatingReviewResponse> ratingReviewResponseList = new ArrayList<>();

        ratingReviewResponseList = ratingReviewRepository.getRatingReviewForCustomer(customerId);

        return ResponseEntity.status(HttpStatus.OK).body(ratingReviewResponseList);
    }

    @Override
    public void updateRatingReview(RatingReviewRequest ratingReviewRequest) {
        RatingReview ratingReview = new RatingReview(ratingReviewRequest.getId(), ratingReviewRequest.getRating(), ratingReviewRequest.getReview(), ratingReviewRequest.getProductId(), ratingReviewRequest.getCustomerId());
        ratingReviewRepository.updateRatingReview(ratingReview);
    }

    @Override
    public void addRatingforProduct(RatingReviewRequest ratingReviewRequest) {
        //TODO add customerId from session.
        RatingReview ratingReview = new RatingReview(ratingReviewRequest.getRating(), ratingReviewRequest.getReview(), ratingReviewRequest.getProductId(), ratingReviewRequest.getCustomerId());
        ratingReviewRepository.setRatingforProduct(ratingReview);
    }

    @Override
    public void deleteRatingReview(Long ratingId) {

        RatingReview ratingReview = null;
        try {
            ratingReview = ratingReviewRepository.getRatingReview(ratingId);
        } catch (Exception e) {
            System.out.println("Could not find Rating Review");
        }

        ratingReviewRepository.deleteRatingReview(ratingReview);
    }
}
