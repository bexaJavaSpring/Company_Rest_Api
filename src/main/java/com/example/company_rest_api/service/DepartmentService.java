package com.example.company_rest_api.service;

import com.example.company_rest_api.dto.ApiResponse;
import com.example.company_rest_api.dto.DepartmentDto;
import com.example.company_rest_api.entity.Company;
import com.example.company_rest_api.entity.Department;
import com.example.company_rest_api.repository.CompanyRepository;
import com.example.company_rest_api.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DepartmentService {

    final DepartmentRepository departmentRepository;
    final CompanyRepository companyRepository;

    public ApiResponse add(DepartmentDto dto) {
        Department department=new Department();
        department.setName(dto.getName());
        Optional<Company> byId = companyRepository.findById(dto.getCompany_id());
        department.setCompany(byId.get());
        Department save = departmentRepository.save(department);
        return new ApiResponse("Added",true,save);
    }

    public ApiResponse edit(Integer id, DepartmentDto dto) {
        Optional<Department> byId = departmentRepository.findById(id);
        if (!byId.isPresent()) {
            return new ApiResponse("Not found",false);
        }
        Department department = byId.get();
        department.setName(dto.getName());
        Optional<Company> byId1 = companyRepository.findById(dto.getCompany_id());
        department.setCompany(byId1.get());
        Department save = departmentRepository.save(department);
        return new ApiResponse("Edited",true,save);
    }

    public ApiResponse delete(Integer id) {
        Optional<Department> byId = departmentRepository.findById(id);
        if (!byId.isPresent()) {
            return new ApiResponse("Edited",false);
        }
        Department department = byId.get();
        departmentRepository.delete(department);
        return new ApiResponse("Deleted",true);
    }
}
