package com.pafkata.service;

import com.pafkata.model.Customer;
import com.pafkata.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;

// this is where the business logic resides
@Service("customerService") // or @Component, but @Service is a better practice and looks better
@Scope("singleton") // defaults to singleton if no text is in the brackets. You should better use the provided ConfigurableBeanFactory.SCOPE_SINGLETON
public class CustomerServiceImpl implements CustomerService {

    //loose coupling from hardcoded implementation of CustomerRepository. Spring's job is to inject the impl by xml configuration
//    private CustomerRepository customerRepository = new HibernateCustomerRepositoryImpl(); // no injection, bad code
//    @Autowired //setter auto-injection
    private CustomerRepository customerRepository;

    public CustomerServiceImpl() {

    }

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
        System.out.println("Constructor injection!");
    }
    @Override
    public List<Customer> findAll(){
        return customerRepository.findAll();
    }

    @Autowired //setter auto-injection
    public void setCustomerRepository(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
        System.out.println("Setter injection!");
    }
}
