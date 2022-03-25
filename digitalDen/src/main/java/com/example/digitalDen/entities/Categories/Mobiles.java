package com.example.digitalDen.entities.Categories;

import javax.persistence.*;


@Entity(name="Mobiles")
@Table(name="mobiles")
public class Mobiles {
    @Id
    private Long id;

    @Column(name = "company")
    private String company;

    @Column(name="rating")
    private Double rating;

    @Column(name="price")
    private Double price;

    @Column(name="mobile_name")
    private String mobileName;

    @Column(name = "about")
    private String about;

    @Column(name="rear_camera")
    private String rearCamera;

    @Column(name="screen_size")
    private String screenSize;

    @Column(name="battery")
    private String battery;

    @Column(name="ram")
    private String ram;

    @Column(name="storage")
    private String storage;

    @Column(name="expandable_storage")
    private String expandebleStorage;

    @Column(name="processor")
    private String processor;

    @Column(name = "operating_system")
    private String operatingSystem;

    @Column(name="warranty")
    private String warranty;

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

    public String getRearCamera() {
        return rearCamera;
    }

    public void setRearCamera(String rearCamera) {
        this.rearCamera = rearCamera;
    }

    public String getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(String screenSize) {
        this.screenSize = screenSize;
    }

    public String getBattery() {
        return battery;
    }

    public void setBattery(String battery) {
        this.battery = battery;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getStorage() {
        return storage;
    }

    public void setStorage(String storage) {
        this.storage = storage;
    }

    public String getExpandebleStorage() {
        return expandebleStorage;
    }

    public void setExpandebleStorage(String expandebleStorage) {
        this.expandebleStorage = expandebleStorage;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public String getWarranty() {
        return warranty;
    }

    public void setWarranty(String warranty) {
        this.warranty = warranty;
    }
}