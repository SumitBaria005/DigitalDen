package com.example.digitalden.repository;

import com.example.digitalden.api.request.RatingReviewRequest;
import com.example.digitalden.api.response.RatingReviewResponse;
import com.example.digitalden.entities.RatingReview;

import java.util.List;

public interface RatingReviewRepository {
    public List<RatingReviewResponse> getRatingReviewForProduct(Long productId);

    public List<RatingReviewResponse> getRatingReviewForCustomer(Long customerId);

    public RatingReview getRatingReview(Long ratingId);

    public void setRatingforProduct(RatingReview ratingReview);

    public void updateRatingReview(RatingReview ratingReview);

    public void deleteRatingReview(RatingReview ratingReview);

}
