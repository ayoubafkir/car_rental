package com.ayoubafkir.Car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CarService {

    // Create a reference of the DAO Class in the Service Class
    private final CarDAO carDAO;

    public CarService(CarDAO carDAO) {
        this.carDAO = carDAO;
    }

    public List<Car> getAllCars() {
        return carDAO.getAllCars();
    }

    public Car getCar(String registrationNumber) {
        for (Car car : getAllCars()) {
            if (car.getRegistrationNumber().equals(registrationNumber)) {
                return car;
            }
        }
        throw new IllegalStateException(String.format("Car with registration number [%s] not found", registrationNumber));
    }

    public List<Car> getAllElectricCars() {
        List<Car> cars = getAllCars();

        if (cars.size() == 0) {
            return Collections.emptyList();
        }

        List<Car> electricCars = new ArrayList<>();

        for (Car car : cars) {
            if (car.isElectric()) {
                electricCars.add(car);
            }
        }

        return electricCars;
    }


}
