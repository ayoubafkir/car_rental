package com.ayoubafkir;

import com.ayoubafkir.Booking.CarBooking;
import com.ayoubafkir.Booking.CarBookingDAO;
import com.ayoubafkir.Booking.CarBookingService;
import com.ayoubafkir.Car.Car;
import com.ayoubafkir.Car.CarDAO;
import com.ayoubafkir.Car.CarService;
import com.ayoubafkir.Customer.Customer;
import com.ayoubafkir.Customer.CustomerDAO;
import com.ayoubafkir.Customer.CustomerFileDataAccessService;
import com.ayoubafkir.Customer.CustomerService;

import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class Main {

    public static void main(String[] args) {

        CustomerDAO customerDAO = new CustomerFileDataAccessService();
       CustomerService customerService = new CustomerService(customerDAO);

        CarBookingDAO carBookingDao = new CarBookingDAO();
        CarDAO carDAO = new CarDAO();

        CarService carService = new CarService(carDAO);
        CarBookingService carBookingService = new CarBookingService(carBookingDao, carService);

        Scanner scanner = new Scanner(System.in);

        boolean keepLooping = true;

        while (keepLooping) {
            try {
                displayMenu();
                String choice = scanner.nextLine();
                switch (Integer.parseInt(choice)) {
                    case 1 -> bookCar(customerService, carBookingService, scanner);
                    case 2 -> displayAllCustomerBookedCars(customerService, carBookingService, scanner);
                    case 3 -> allBookings(carBookingService);
                    case 4 -> displayAvailableCars(carBookingService, false);
                    case 5 -> displayAvailableCars(carBookingService, true);
                    case 6 -> displayAllCustomers(customerService);
                    case 7 -> keepLooping = false;
                    default -> System.out.println(choice + " not a valid option ❌");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

        private static void allBookings (CarBookingService carBookingService){
            List<CarBooking> bookings = carBookingService.getBookings();
            if (bookings.isEmpty()) {
                System.out.println("No bookings available");
                return;
            }
            for (CarBooking booking : bookings) {
                System.out.println("booking = " + booking);
            }
        }

        private static void displayAllCustomers (CustomerService customerService){
            List<Customer> customers = customerService.getCustomers();
            if (customers.isEmpty()) {
                System.out.println("No users in the system");
                return;
            }
            for (Customer customer : customers) {
                System.out.println(customer);
            }
        }

        private static void displayAvailableCars (CarBookingService carBookingService,boolean isElectric){
            List<Car> availableCars = isElectric ? carBookingService.getAvailableElectricCars() : carBookingService.getAvailableElectricCars();
            if (availableCars.isEmpty()) {
                System.out.println("No cars available for renting");
                return;
            }
            for (Car availableCar : availableCars) {
                System.out.println(availableCar);
            }
        }


        private static void displayAllCustomerBookedCars (CustomerService customerService, CarBookingService
        carBookingService, Scanner scanner){
            displayAllCustomers(customerService);

            System.out.println("Select customer id");
            String customerId = scanner.nextLine();

            Customer customer = customerService.getCustomerById(UUID.fromString(customerId));
            if (customer == null) {
                System.out.println("No customer foudn with id " + customerId);
                return;
            }

            List<Car> customerBookedCars = carBookingService.getCustomerBookedCars(customer.getId());
            if (customerBookedCars.isEmpty()) {
                System.out.println("Customer %s has no cars booked" + customer);
                return;
            }
            for (Car customerBookedCar : customerBookedCars) {
                System.out.println(customerBookedCar);
            }
        }

        private static void bookCar (CustomerService customerService, CarBookingService carBookingService, Scanner
        scanner){
            displayAvailableCars(carBookingService, false);

            System.out.println("Select car registration number");
            String registrationNumber = scanner.nextLine();

            displayAllCustomers(customerService);

            System.out.println("Select customer id");
            String customerId = scanner.nextLine();

            try {
                Customer customer = customerService.getCustomerById(UUID.fromString(customerId));
                if (customer == null) {
                    System.out.println("No customer found with id " + customerId);
                } else {
                    UUID bookingId = carBookingService.bookCar(customer, registrationNumber);
                    String confirmationMessage = "Successfully booked car with reg number %s for customer $s".formatted(registrationNumber, customer, bookingId);
                    System.out.println(confirmationMessage);
                }

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }


        private static void displayMenu () {
            System.out.println("""
                    \n
                    1️⃣ - Book Car
                    2️⃣ - View All User Booked Cars
                    3️⃣ - View All Bookings
                    4️⃣ - View Available Cars
                    5️⃣ - View Available Electric Cars
                    6️⃣ - View all users
                    7️⃣ - Exit
                    """);
        }


    }

