package com.example.digitalden.entities.Categories;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "Televisions")
@Table(name = "Televisions")
public class Televisions {
    @Id
    private Long id;

    @Column(name = "company")
    private String company;

    @Column(name="rating")
    private Double rating;

    @Column(name="price")
    private Double price;

    @Column(name="television_name")
    private String mobileName;

    @Column(name = "about")
    private String about;

    @Column(name="supported_internet_services")
    private String supportedInternetServices;

    @Column(name="screen_size")
    private String screenSize;

    @Column(name="connector_type")
    private String connectorType;

    @Column(name="color")
    private String color;

    @Column(name="resolution")
    private String resolution;

    @Column(name="feature")
    private String feature;

    @Column(name="bluetooth")
    private boolean bluetooth;

    @Column(name = "speakers")
    private Integer speakers;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getMobileName() {
        return mobileName;
    }

    public void setMobileName(String mobileName) {
        this.mobileName = mobileName;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getSupportedInternetServices() {
        return supportedInternetServices;
    }

    public void setSupportedInternetServices(String supportedInternetServices) {
        this.supportedInternetServices = supportedInternetServices;
    }

    public String getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(String screenSize) {
        this.screenSize = screenSize;
    }

    public String getConnectorType() {
        return connectorType;
    }

    public void setConnectorType(String connectorType) {
        this.connectorType = connectorType;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public String getFeature() {
        return feature;
    }

    public void setFeature(String feature) {
        this.feature = feature;
    }

    public boolean isBluetooth() {
        return bluetooth;
    }

    public void setBluetooth(boolean bluetooth) {
        this.bluetooth = bluetooth;
    }

    public Integer getSpeakers() {
        return speakers;
    }

    public void setSpeakers(Integer speakers) {
        this.speakers = speakers;
    }
}
