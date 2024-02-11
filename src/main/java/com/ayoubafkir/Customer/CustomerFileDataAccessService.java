package com.ayoubafkir.Customer;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class CustomerFileDataAccessService implements CustomerDAO {

    @Override
    public List<Customer> getCustomers()  {
        File file = new File("src/file.customers");

        List<Customer> customers = new ArrayList<>();

        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                String[] split = scanner.nextLine().split(",");
                customers.add(new Customer(UUID.fromString(split[0]), split[1]));
            }
            return customers;
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }
}
