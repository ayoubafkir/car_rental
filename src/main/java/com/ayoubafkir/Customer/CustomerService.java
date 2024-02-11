package com.ayoubafkir.Customer;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

public class CustomerService {

    private final CustomerDAO customerDAO;

    public CustomerService(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    public List<Customer> getCustomers()  {
        return customerDAO.getCustomers();
    }

    public Customer getCustomerById(UUID id) {
        for (Customer customer : getCustomers()) {
            if (customer.getId().equals(id)) {
                return customer;
            }
        }
        return null;
    }
}
