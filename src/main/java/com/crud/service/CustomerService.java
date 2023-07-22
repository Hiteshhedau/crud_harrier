package com.crud.service;

import com.crud.entity.Customer;
import com.crud.error.CustomerNotFounException;
import com.crud.error.InvalidCustomerCreatedException;

import java.util.List;

public interface CustomerService {


    Customer createCustomer(Customer customer) throws InvalidCustomerCreatedException;

    Customer findCustomerById(int id) throws CustomerNotFounException;

    Customer findCustomerByName(String name);

    String deleteCustomerById(int id);

    Customer updateCustomerById(Customer customer, int id);

    List<Customer> getAllCustomer();
}
