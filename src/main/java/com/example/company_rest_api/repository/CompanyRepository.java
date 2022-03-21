package com.example.company_rest_api.repository;

import com.example.company_rest_api.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company,Integer> {

}
