package com.example.digitalDen.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RatingReviewResponse {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("rating")
    private Integer rating;

    @JsonProperty("review")
    private String review;

    public RatingReviewResponse(Long id, Integer rating, String review) {
        this.id = id;
        this.rating = rating;
        this.review = review;
    }

    public RatingReviewResponse() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    @Override
    public String toString() {
        return "RatingReviewResponse{" +
                "id=" + id +
                ", rating=" + rating +
                ", review='" + review + '\'' +
                '}';
    }
}
