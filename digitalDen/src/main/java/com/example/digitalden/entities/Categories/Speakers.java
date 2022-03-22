package com.example.digitalden.entities.Categories;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="Speakers")
@Table(name="speakers")
public class Speakers {
    @Id
    private Long id;

    @Column(name = "company")
    private String company;

    @Column(name="rating")
    private Double rating;

    @Column(name="price")
    private Double price;

    @Column(name="model_name")
    private String modelName;

    @Column(name = "about")
    private String about;

    @Column(name="rear_camera")
    private String rearCamera;

    @Column(name="weight")
    private String weight;

    @Column(name="battery")
    private String battery;

    @Column(name="amplifies")
    private String amplifies;

    @Column(name="impedance")
    private String impedance;

    @Column(name="color")
    private String color;

    @Column(name="bluetooth")
    private boolean bluetooth;

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

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getRearCamera() {
        return rearCamera;
    }

    public void setRearCamera(String rearCamera) {
        this.rearCamera = rearCamera;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getBattery() {
        return battery;
    }

    public void setBattery(String battery) {
        this.battery = battery;
    }

    public String getAmplifies() {
        return amplifies;
    }

    public void setAmplifies(String amplifies) {
        this.amplifies = amplifies;
    }

    public String getImpedance() {
        return impedance;
    }

    public void setImpedance(String impedance) {
        this.impedance = impedance;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isBluetooth() {
        return bluetooth;
    }

    public void setBluetooth(boolean bluetooth) {
        this.bluetooth = bluetooth;
    }
}
