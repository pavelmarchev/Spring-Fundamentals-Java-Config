package com.pafkata.repository;

import com.pafkata.model.Customer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("customerRepository") //define as repository bean with name property, instead in the xml config. Does not need to be named tho.
public class HibernateCustomerRepositoryImpl implements CustomerRepository {

    @Override
    public List<Customer> findAll() {
        List<Customer> customers = new ArrayList<>();

        Customer customer = new Customer();
        customer.setFirstName("Bryan");
        customer.setLastName("Hansen");

        customers.add(customer);
        return customers;
    }
}
