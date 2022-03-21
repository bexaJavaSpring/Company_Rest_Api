package com.example.company_rest_api.controller;

import com.example.company_rest_api.dto.ApiResponse;
import com.example.company_rest_api.dto.WorkerDto;
import com.example.company_rest_api.repository.WorkerRepository;
import com.example.company_rest_api.service.WorkerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("/api/worker")
@RestController
@RequiredArgsConstructor
public class WorkerController {
    final WorkerRepository workerRepository;
    final WorkerService workerService;

    @GetMapping
    public HttpEntity<?> getAll(){
        return ResponseEntity.ok().body(workerRepository.findAll());
    }
    @PostMapping
    public HttpEntity<?> add(@Valid @RequestBody WorkerDto dto){
        ApiResponse apiResponse=workerService.add(dto);
        return ResponseEntity.status(apiResponse.isSuccess()?201:409).body(apiResponse);
    }
    @PutMapping("/{id}")
    public HttpEntity<?> edit(@PathVariable Integer id,@Valid @RequestBody WorkerDto dto){
        ApiResponse apiResponse=workerService.edit(id,dto);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }
    @DeleteMapping("/{id}")
    public HttpEntity<?> delete(@PathVariable Integer id){
        ApiResponse apiResponse=workerService.delete(id);
        return ResponseEntity.status(apiResponse.isSuccess()?204:404).body(apiResponse);
    }
}
