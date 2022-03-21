package com.example.company_rest_api.controller;

import com.example.company_rest_api.dto.AddresDto;
import com.example.company_rest_api.dto.ApiResponse;
import com.example.company_rest_api.repository.AddressRepository;
import com.example.company_rest_api.service.AddresssService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("/api/address")
@RestController
@RequiredArgsConstructor
public class AddressController {

    final AddressRepository addressRepository;
    final AddresssService addresssService;

    @GetMapping
    public HttpEntity<?> getAll(){
        return ResponseEntity.ok().body(addressRepository.findAll());
    }
    @PostMapping
    public HttpEntity<?> add(@Valid @RequestBody AddresDto dto){
        ApiResponse apiResponse=addresssService.add(dto);
        return ResponseEntity.status(apiResponse.isSuccess()?201:409).body(apiResponse);
    }
    @PutMapping("/{id}")
    public HttpEntity<?>edit(@PathVariable Integer id,@Valid @RequestBody AddresDto dto){
        ApiResponse apiResponse=addresssService.edit(id,dto);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }
    @DeleteMapping("/{id}")
    public HttpEntity<?> delete(@PathVariable Integer id){
        ApiResponse apiResponse=addresssService.delete(id);
        return ResponseEntity.status(apiResponse.isSuccess()?204:404).body(apiResponse);
    }

}
