package com.example.company_rest_api.controller;

import com.example.company_rest_api.dto.ApiResponse;
import com.example.company_rest_api.dto.DepartmentDto;
import com.example.company_rest_api.repository.DepartmentRepository;
import com.example.company_rest_api.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("/api/department")
@RestController
@RequiredArgsConstructor
public class DepartmentController {
    final DepartmentRepository departmentRepository;
    final DepartmentService departmentService;

    @GetMapping
    public HttpEntity<?> getAll(){
        return ResponseEntity.ok().body(departmentRepository.findAll());
    }
    @PostMapping
    public HttpEntity<?> add(@Valid @RequestBody DepartmentDto dto){
        ApiResponse apiResponse=departmentService.add(dto);
        return ResponseEntity.status(apiResponse.isSuccess()?201:409).body(apiResponse);
    }
    @PutMapping("/{id}")
    public HttpEntity<?> edit(@PathVariable Integer id,@Valid @RequestBody DepartmentDto dto){
        ApiResponse apiResponse=departmentService.edit(id,dto);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }
    @DeleteMapping("/{id}")
    public HttpEntity<?> delete(@PathVariable Integer id){
        ApiResponse apiResponse=departmentService.delete(id);
        return ResponseEntity.status(apiResponse.isSuccess()?204:404).body(apiResponse);
    }

}
