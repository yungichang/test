package com.jycase.dreamflycustomer.dreamflycustomer.dto;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public class CustomerRequest {
    @NotBlank
    private String customerName;
    private LocalDate birthday;
    private String phone;
    @NotBlank
    private String civilId;
    private String career;
    private String carModel;
    private String carNumber;
    private LocalDate purchaseDate;
    private LocalDate compulsoryInsuraceDate;
    private LocalDate insuraceDate;
    private Boolean insuranceService;

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCivilId() {
        return civilId;
    }

    public void setCivilId(String civilId) {
        this.civilId = civilId;
    }

    public String getCareer() {
        return career;
    }

    public void setCareer(String career) {
        this.career = career;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public LocalDate getCompulsoryInsuraceDate() {
        return compulsoryInsuraceDate;
    }

    public void setCompulsoryInsuraceDate(LocalDate compulsoryInsuraceDate) {
        this.compulsoryInsuraceDate = compulsoryInsuraceDate;
    }

    public LocalDate getInsuraceDate() {
        return insuraceDate;
    }

    public void setInsuraceDate(LocalDate insuraceDate) {
        this.insuraceDate = insuraceDate;
    }

    public Boolean getInsuranceService() {
        return insuranceService;
    }

    public void setInsuranceService(Boolean insuranceService) {
        this.insuranceService = insuranceService;
    }
}
