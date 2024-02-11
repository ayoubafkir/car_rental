package com.ayoubafkir.Customer;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class CustomerArrayDAOService implements CustomerDAO {

    // Fake Database : Array of customers
    private static final Customer[] customers;

    static {
        customers = new Customer[] {
                    new Customer(UUID.fromString("2bdf7101-0419-47cf-bdec-28ed8b48ff19"), "Ayoub"),
                    new Customer(UUID.fromString("da01f40c-8bc2-4282-899f-8c78600ac665"), "Mohammad")
        };
    }

    @Override
    public List<Customer> getCustomers() {
        return Arrays.asList(customers);
    }
}
