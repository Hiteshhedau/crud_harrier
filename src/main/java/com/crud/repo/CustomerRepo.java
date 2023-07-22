package com.crud.repo;


import com.crud.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo  extends JpaRepository<Customer,Integer> {
    Customer findByName(String name);
}
