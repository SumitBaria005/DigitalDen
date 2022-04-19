package com.example.digitalDen.repository.impl;

import com.example.digitalDen.api.response.RatingReviewResponse;
import com.example.digitalDen.db.util.JDBCAccess;
import com.example.digitalDen.db.util.JPAAccess;
import com.example.digitalDen.entities.RatingReview;
import com.example.digitalDen.repository.RatingReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RatingReviewRepositoryImplementation implements RatingReviewRepository {

    @Autowired
    JPAAccess jpaAccess;

    @Autowired
    JDBCAccess jdbcAccess;

    private String GET_RATING_REVIEW_FOR_PRODUCT = "SELECT id, rating, review FROM rating_review WHERE product_id = ?";

    private String GET_RATING_REVIEW_FOR_CUSTOMER  = "SELECT id, rating, review FROM rating_review WHERE customer_id = ?";

    private String GET_RATING_REVIEW = "SELECT * FROM  rating_review WHERE id = ?";

    private String UPDATE_RATING_REVIEW = "UPDATE rating_review SET rating = ?, review = ? WHERE id = ?";

    private String DELETE_RATING_REVIEW = "DELETE FROM rating_review WHERE id = ?";

    @Override
    public List<RatingReviewResponse> getRatingReviewForProduct(Long productId) {
        return getRatingReviewResponses(productId, GET_RATING_REVIEW_FOR_PRODUCT);
    }

    @Override
    public List<RatingReviewResponse> getRatingReviewForCustomer(Long customerId) {
        return getRatingReviewResponses(customerId, GET_RATING_REVIEW_FOR_CUSTOMER);
    }

    @Override
    public RatingReview getRatingReview(Long ratingId) {
        return jdbcAccess.findOne(GET_RATING_REVIEW, (rs, rowNum) -> {
            RatingReview ratingReviewResponse = new RatingReview();
            ratingReviewResponse.setRating(rs.getInt("rating"));
            ratingReviewResponse.setReview(rs.getString("review"));
            ratingReviewResponse.setId(rs.getLong("id"));
            return ratingReviewResponse;
        }, ratingId);
    }

    private List<RatingReviewResponse> getRatingReviewResponses(Long id, String get_rating_review_for_customer) {
        return jdbcAccess.find(get_rating_review_for_customer, (rs, rowNum) -> {
            RatingReviewResponse ratingReviewResponse = new RatingReviewResponse();
            ratingReviewResponse.setRating(rs.getInt("rating"));
            ratingReviewResponse.setReview(rs.getString("review"));
            ratingReviewResponse.setId(rs.getLong("id"));
            return ratingReviewResponse;
        }, id);
    }

    @Override
    public void setRatingforProduct(RatingReview ratingReview) {
        jpaAccess.save(ratingReview);
    }

    @Override
    public void updateRatingReview(RatingReview ratingReview) {
        int n = jdbcAccess.update(UPDATE_RATING_REVIEW, ratingReview.getRating(), ratingReview.getReview(), ratingReview.getId());
        System.out.println("Rows Affected: " + n);
    }

    @Override
    public void deleteRatingReview(RatingReview ratingReview) {
        jpaAccess.delete(ratingReview);
    }
}
