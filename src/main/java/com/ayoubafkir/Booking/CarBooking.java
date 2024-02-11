package com.ayoubafkir.Booking;

import com.ayoubafkir.Car.Car;
import com.ayoubafkir.Customer.Customer;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

public class CarBooking {

    private UUID bookingId;
    private Customer customer;
    private Car car;
    private LocalDateTime bookingTime;
    private boolean isCanceled;

    // Default Constructor
    public CarBooking(UUID bookingId, Customer customer, Car car, LocalDateTime now) {

    }

    // Constructor
    public CarBooking(UUID bookingId, Customer customer, Car car, LocalDateTime bookingTime, boolean isCanceled) {
        this.bookingId = bookingId;
        this.customer = customer;
        this.car = car;
        this.bookingTime = bookingTime;
        this.isCanceled = isCanceled;
    }

    // Getters and Setters


    public UUID getBookingId() {
        return bookingId;
    }

    public void setBookingId(UUID bookingId) {
        this.bookingId = bookingId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public LocalDateTime getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(LocalDateTime bookingTime) {
        this.bookingTime = bookingTime;
    }

    public boolean isCanceled() {
        return isCanceled;
    }

    public void setCanceled(boolean canceled) {
        isCanceled = canceled;
    }

    // toString method

    @Override
    public String toString() {
        return "CarBooking{" +
                "bookingId=" + bookingId +
                ", customer=" + customer +
                ", car=" + car +
                ", bookingTime=" + bookingTime +
                ", isCanceled=" + isCanceled +
                '}';
    }

    // equal and hashcode

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarBooking that = (CarBooking) o;
        return isCanceled == that.isCanceled && Objects.equals(bookingId, that.bookingId) && Objects.equals(customer, that.customer) && Objects.equals(car, that.car) && Objects.equals(bookingTime, that.bookingTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookingId, customer, car, bookingTime, isCanceled);
    }
}
