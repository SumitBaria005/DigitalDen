package com.example.digitalDen.repository;

import com.example.digitalDen.api.response.RatingReviewResponse;
import com.example.digitalDen.entities.RatingReview;

import java.util.List;

public interface RatingReviewRepository {
    public List<RatingReviewResponse> getRatingReviewForProduct(Long productId);

    public List<RatingReviewResponse> getRatingReviewForCustomer(Long customerId);

    public RatingReview getRatingReview(Long ratingId);

    public void setRatingforProduct(RatingReview ratingReview);

    public void updateRatingReview(RatingReview ratingReview);

    public void deleteRatingReview(RatingReview ratingReview);

}
