package com.ayoubafkir.Car;

import java.math.BigDecimal;
import java.util.Objects;

public class Car {

    private String registrationNumber;
    private BigDecimal rentalPricePerDay;
    private Brand brand;

    private boolean isElectric;

    // Default Constructor
    public Car() {

    }

    // Constructor
    public Car(String registrationNumber, BigDecimal rentalPricePerDay, Brand brand, boolean isElectric) {
        this.registrationNumber = registrationNumber;
        this.rentalPricePerDay = rentalPricePerDay;
        this.brand = brand;
        this.isElectric = isElectric;
    }

    // Getters and Setters
    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public BigDecimal getRentalPricePerDay() {
        return rentalPricePerDay;
    }

    public void setRentalPricePerDay(BigDecimal rentalPricePerDay) {
        this.rentalPricePerDay = rentalPricePerDay;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public boolean isElectric() {
        return isElectric;
    }

    public void setElectric(boolean electric) {
        isElectric = electric;
    }

    @Override
    public String toString() {
        return "Car{" +
                "registrationNumber='" + registrationNumber + '\'' +
                ", rentalPricePerDay=" + rentalPricePerDay +
                ", brand=" + brand +
                ", isElectric=" + isElectric +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return isElectric == car.isElectric && Objects.equals(registrationNumber, car.registrationNumber) && Objects.equals(rentalPricePerDay, car.rentalPricePerDay) && brand == car.brand;
    }

    @Override
    public int hashCode() {
        return Objects.hash(registrationNumber, rentalPricePerDay, brand, isElectric);
    }
}


















