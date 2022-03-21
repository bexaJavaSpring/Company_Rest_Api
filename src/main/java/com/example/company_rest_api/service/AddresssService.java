package com.example.company_rest_api.service;

import com.example.company_rest_api.dto.AddresDto;
import com.example.company_rest_api.dto.ApiResponse;
import com.example.company_rest_api.entity.Address;
import com.example.company_rest_api.repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AddresssService {

    final AddressRepository addressRepository;

    public ApiResponse add(AddresDto dto) {
        Address address=new Address();
        address.setStreet(dto.getStreet());
        address.setHomeNumber(dto.getHomeNumber());
        Address save = addressRepository.save(address);
        return new ApiResponse("Added",true,save);
    }

    public ApiResponse edit(Integer id, AddresDto dto) {
        Optional<Address> byId = addressRepository.findById(id);
        Address address = byId.get();
        address.setStreet(dto.getStreet());
        address.setHomeNumber(dto.getHomeNumber());
        Address save = addressRepository.save(address);
        return new ApiResponse("Edited",true,save);
    }

    public ApiResponse delete(Integer id) {
        Optional<Address> byId = addressRepository.findById(id);
        Address address = byId.get();
        addressRepository.delete(address);
        return new ApiResponse("Delete",true,address);
    }
}
