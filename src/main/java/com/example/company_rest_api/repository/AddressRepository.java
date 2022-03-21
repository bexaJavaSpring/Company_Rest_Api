package com.example.company_rest_api.repository;

import com.example.company_rest_api.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address,Integer> {

}
