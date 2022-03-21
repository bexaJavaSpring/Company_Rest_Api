package com.example.company_rest_api.service;

import com.example.company_rest_api.dto.ApiResponse;
import com.example.company_rest_api.dto.CompanyDto;
import com.example.company_rest_api.entity.Address;
import com.example.company_rest_api.entity.Company;
import com.example.company_rest_api.repository.AddressRepository;
import com.example.company_rest_api.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CompanyService {
  final CompanyRepository companyRepository;
  final AddressRepository addressRepository;

    public ApiResponse add(CompanyDto dto) {
        Company company=new Company();
        company.setCorpName(dto.getCorpName());
        Optional<Address> byId = addressRepository.findById(dto.getAddress_id());
        company.setAddress(byId.get());
        Company save = companyRepository.save(company);
        return new ApiResponse("Added",true,save);
    }

    public ApiResponse edit(Integer id, CompanyDto dto) {
        Optional<Company> byId = companyRepository.findById(id);
        if (!byId.isPresent()) {
            return new ApiResponse("Not found",false);
        }
        Company company = byId.get();
        company.setCorpName(dto.getCorpName());
        Optional<Address> byId1 = addressRepository.findById(dto.getAddress_id());
        company.setAddress(byId1.get());
        Company save = companyRepository.save(company);
        return new ApiResponse("Edited",true,save);
    }
    public ApiResponse delete(Integer id) {
        Optional<Company> byId = companyRepository.findById(id);
        if (!byId.isPresent()) {
            return new ApiResponse("Not found",false);
        }
        Company company = byId.get();
        companyRepository.delete(company);
        return new ApiResponse("Deleted",true,company);
    }
}
