package com.example.company_rest_api.controller;

import com.example.company_rest_api.dto.ApiResponse;
import com.example.company_rest_api.dto.CompanyDto;
import com.example.company_rest_api.repository.CompanyRepository;
import com.example.company_rest_api.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("/api/company")
@RestController
@RequiredArgsConstructor
public class CompanyController {
    final CompanyRepository companyRepository;
    final CompanyService companyService;

    @GetMapping
    public HttpEntity<?> getAll(){
        return ResponseEntity.ok().body(companyRepository.findAll());
    }
    @PostMapping
    public HttpEntity<?> add(@Valid @RequestBody CompanyDto dto){
        ApiResponse apiResponse=companyService.add(dto);
        return ResponseEntity.status(apiResponse.isSuccess()?201:409).body(apiResponse);
    }
    @PutMapping("/{id}")
    public HttpEntity<?> edit(@PathVariable Integer id,@Valid @RequestBody CompanyDto dto){
        ApiResponse apiResponse=companyService.edit(id,dto);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }
    @DeleteMapping("/{id}")
    public HttpEntity<?> delete(@PathVariable Integer id){
        ApiResponse apiResponse=companyService.delete(id);
        return ResponseEntity.status(apiResponse.isSuccess()?204:404).body(apiResponse);
    }
}
