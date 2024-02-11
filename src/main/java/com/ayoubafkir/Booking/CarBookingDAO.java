package com.ayoubafkir.Booking;

import com.ayoubafkir.Car.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CarBookingDAO {

    protected final static List<CarBooking> carBookings;

    static {
        carBookings = new ArrayList<CarBooking>();
    }

    public List<CarBooking> getCarBookings() {
        return carBookings;
    }

    public void book(CarBooking carBooking) {
        carBookings.add(carBooking);
    }

    public void cancelCarBooking(UUID id) {
        for (CarBooking carBooking : carBookings) {
            if (carBooking.isCanceled()) {
                throw new IllegalStateException("Booking is canceled. Must make a new booking");
            }
        }
    }

}


