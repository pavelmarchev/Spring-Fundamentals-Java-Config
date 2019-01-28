package com.pafkata.repository;

import com.pafkata.model.Customer;

import java.util.List;

public interface CustomerRepository {
    List<Customer> findAll();
}
