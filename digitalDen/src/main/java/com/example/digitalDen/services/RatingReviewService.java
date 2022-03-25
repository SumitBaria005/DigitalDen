package com.example.digitalDen.services;

import com.example.digitalDen.api.request.RatingReviewRequest;
import com.example.digitalDen.api.response.RatingReviewResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface RatingReviewService {
    public ResponseEntity<List<RatingReviewResponse>> getRatingReviewForProduct(Long productId);

    ResponseEntity<List<RatingReviewResponse>> getRatingReviewForCustomer(Long customerId);

    void updateRatingReview(RatingReviewRequest ratingReviewRequest);

    void addRatingforProduct(RatingReviewRequest ratingReviewRequest);

    void deleteRatingReview(Long ratingId);
}
