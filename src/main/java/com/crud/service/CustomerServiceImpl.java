package com.crud.service;


import com.crud.entity.Customer;
import com.crud.error.CustomerNotFounException;
import com.crud.error.InvalidCustomerCreatedException;
import com.crud.repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService{



    @Autowired
    private CustomerRepo customerRepo;
    @Override
    public Customer createCustomer(Customer customer) throws InvalidCustomerCreatedException {
        if(!Objects.nonNull(customer.getName()) || "".equalsIgnoreCase(customer.getName())){
            throw new InvalidCustomerCreatedException("please provide name");
        }
        if(!Objects.nonNull(customer.getContact()) || "".equalsIgnoreCase(customer.getContact())){
            throw new InvalidCustomerCreatedException("please provide contact");
        }
        if(!Objects.nonNull(customer.getAddress()) || "".equalsIgnoreCase(customer.getAddress())){
            throw new InvalidCustomerCreatedException("please provide address");
        }
        return customerRepo.save(customer);
    }

    
    @Override
    public Customer findCustomerById(int id) throws CustomerNotFounException {
        Optional<Customer> customer= customerRepo.findById(id);
        if(!customer.isPresent()){
            throw new CustomerNotFounException("customer not found for id => "+id);

        }
        return customer.get();
    }

    @Override
    public Customer findCustomerByName(String name) {
        return customerRepo.findByName(name);
    }

    @Override
    public String deleteCustomerById(int id) {

         customerRepo.deleteById(id);
         return "Customer delete successfully " +id;

    }

    @Override
    public Customer updateCustomerById(Customer customer, int id) {


        Customer updatedCustomer= customerRepo.findById(id).get();
        if(Objects.nonNull(customer.getName()) && !"".equalsIgnoreCase(customer.getName())){
            updatedCustomer.setName(customer.getName());
        }
        if(Objects.nonNull(customer.getAddress()) && !"".equalsIgnoreCase(customer.getAddress())){
            updatedCustomer.setAddress(customer.getAddress());
        }
        if(Objects.nonNull(customer.getContact()) && !"".equalsIgnoreCase(customer.getContact())){
            updatedCustomer.setContact(customer.getContact());
        }

        customerRepo.save(updatedCustomer);
        return updatedCustomer;
    }

    @Override
    public List<Customer> getAllCustomer() {
        return customerRepo.findAll();
    }


}
