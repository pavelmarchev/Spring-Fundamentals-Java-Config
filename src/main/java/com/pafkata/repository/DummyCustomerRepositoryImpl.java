package com.pafkata.repository;

import com.pafkata.model.Customer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("dummyCustomerRepository")
public class DummyCustomerRepositoryImpl implements CustomerRepository {

    @Override
    public List<Customer> findAll() {
        List<Customer> customers = new ArrayList<>();

        Customer customer = new Customer();
        customer.setFirstName("Bryan Dummy");
        customer.setLastName("Hansen Dummy");

        customers.add(customer);
        return customers;
    }
}
