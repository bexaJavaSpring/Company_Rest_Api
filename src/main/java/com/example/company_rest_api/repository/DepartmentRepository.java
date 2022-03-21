package com.example.company_rest_api.repository;

import com.example.company_rest_api.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department,Integer> {
}
