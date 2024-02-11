package com.ayoubafkir.Booking;

import com.ayoubafkir.Car.Car;
import com.ayoubafkir.Car.CarService;
import com.ayoubafkir.Customer.Customer;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static com.ayoubafkir.Booking.CarBookingDAO.carBookings;

public class CarBookingService {

    private final CarBookingDAO carBookingDAO;
    private final CarService carService;

    public CarBookingService(CarBookingDAO carBookingDAO, CarService carService) {
        this.carBookingDAO = carBookingDAO;
        this.carService = carService;
    }

    private List<Car> getAvailableCars() {
        return getAvailableCars();
    }


    public UUID bookCar(Customer customer, String registrationNumber) {
        List<Car> availableCars = getAvailableCars();

        if (availableCars.isEmpty()) {
            throw new IllegalStateException("No car availabla for renting");
        }

        for (Car availableCar : availableCars) {
            if (availableCar.getRegistrationNumber().equals(registrationNumber)) {
                Car car = carService.getCar(registrationNumber);
                    UUID bookingId = UUID.randomUUID();
                    carBookingDAO.book(new CarBooking(bookingId, customer, car, LocalDateTime.now()));
                    return bookingId;
            }
        }
        throw new IllegalStateException("Already booked car with registration number" + registrationNumber);
     }

   public List<Car> getCustomerBookedCars(UUID customerId) {
        List<CarBooking> carBookings = carBookingDAO.getCarBookings();
        List<Car> customerCars = new ArrayList<>();

        for (CarBooking carBooking : carBookings) {
            if (carBooking != null && carBooking.getCustomer().getId().equals(customerId)) {
                customerCars.add(carBooking.getCar());
            }
        }
        return customerCars;
   }

   public List<Car> getAvailableElectricCars() {
        return getCars(carService.getAllElectricCars());
   }

   private List<Car> getCars(List<Car> cars) {

       // No cars in the system yet

       if (carBookings.isEmpty()) {
           return cars;
       }

       List<Car> availableCars = new ArrayList<>();

       // populate available cars
       for (Car car : cars) {
           // let's check if car took part of any booking
           // if not then it is available but this time we add it top available cars

           boolean booked = false;
           for (CarBooking carBooking : carBookings) {
               if (carBooking == null || !carBooking.getCar().equals(car)) {
                   continue;
               }
               booked = true;
           }
           if (!booked) {
               availableCars.add(car);
           }
       }
       return availableCars;
   }

   public List<CarBooking> getBookings() {
        return carBookingDAO.getCarBookings();
   }

}
