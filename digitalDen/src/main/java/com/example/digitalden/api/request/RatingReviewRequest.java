package com.example.digitalden.api.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RatingReviewRequest {

    @JsonProperty(value = "id", required = false)
    private Long id;

    @JsonProperty("rating")
    private Integer rating;

    @JsonProperty("review")
    private String review;

    @JsonProperty("productId")
    private Long productId;

    @JsonProperty("customerId")
    private Long customerId;


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

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public RatingReviewRequest(Integer rating, String review, Long productId, Long customerId) {
        this.rating = rating;
        this.review = review;
        this.productId = productId;
        this.customerId = customerId;
    }

    public RatingReviewRequest(Long id, Integer rating, String review, Long productId, Long customerId) {
        this.id = id;
        this.rating = rating;
        this.review = review;
        this.productId = productId;
        this.customerId = customerId;
    }

    public RatingReviewRequest() {
    }


    @Override
    public String toString() {
        return "RatingReviewRequest{" +
                "rating=" + rating +
                ", review='" + review + '\'' +
                ", productId=" + productId +
                ", customerId=" + customerId +
                '}';
    }
}
