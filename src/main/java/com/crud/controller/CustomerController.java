package com.crud.controller;


import com.crud.entity.Customer;
import com.crud.error.CustomerNotFounException;
import com.crud.error.InvalidCustomerCreatedException;
import com.crud.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {



    @Autowired
    private CustomerService customerService;

    @PostMapping("/create")
    public Customer createCustomer(@RequestBody Customer customer) throws InvalidCustomerCreatedException {
        return  customerService.createCustomer(customer);
    }



    @GetMapping("/get-all")
    public List<Customer> getAllCustomer(){
        return customerService.getAllCustomer();
    }
    @GetMapping("/find-customer-by-id/{id}")
    public Customer findCustomerById(@PathVariable int id) throws CustomerNotFounException {
        return  customerService.findCustomerById(id);
    }

    @GetMapping("/find-customer-by-name/{name}")
    public Customer findCustomerByName(@PathVariable String name ){
        return  customerService.findCustomerByName(name);
    }

    @DeleteMapping("/delete-customer/{id}")
    public String deleteCustomerById(@PathVariable int id){
        return  customerService.deleteCustomerById(id);
    }


    @PutMapping("/update/{id}")
    public Customer updateCustomerById(@RequestBody Customer customer,@PathVariable int id){
        return  customerService.updateCustomerById(customer,id);
    }

}
