package com.example.company_rest_api.service;

import com.example.company_rest_api.dto.ApiResponse;
import com.example.company_rest_api.dto.WorkerDto;
import com.example.company_rest_api.entity.Address;
import com.example.company_rest_api.entity.Department;
import com.example.company_rest_api.entity.Worker;
import com.example.company_rest_api.repository.AddressRepository;
import com.example.company_rest_api.repository.DepartmentRepository;
import com.example.company_rest_api.repository.WorkerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class WorkerService {

    final WorkerRepository workerRepository;
    final AddressRepository addressRepository;
    final DepartmentRepository departmentRepository;

    public ApiResponse add(WorkerDto dto) {
        Worker worker = new Worker();
        worker.setName(dto.getName());
        worker.setPhoneNumber(dto.getPhoneNumber());
        Optional<Address> byId = addressRepository.findById(dto.getAddress_id());
        worker.setAddress(byId.get());
        Optional<Department> byId1 = departmentRepository.findById(dto.getDepartment_id());
        worker.setDepartment(byId1.get());
        Worker save = workerRepository.save(worker);
        return new ApiResponse("Added", true, save);
    }

    public ApiResponse edit(Integer id, WorkerDto dto) {
        Optional<Worker> byId = workerRepository.findById(id);
        if (!byId.isPresent()) {
            return new ApiResponse("Not found",false);
        }
        Worker worker = byId.get();
        worker.setName(dto.getName());
        worker.setPhoneNumber(dto.getPhoneNumber());
        Optional<Address> byId1 = addressRepository.findById(dto.getAddress_id());
        worker.setAddress(byId1.get());
        Optional<Department> byId2 = departmentRepository.findById(dto.getDepartment_id());
        worker.setDepartment(byId2.get());
        Worker save = workerRepository.save(worker);
        return new ApiResponse("Edited",true,save);
    }

    public ApiResponse delete(Integer id) {
        Optional<Worker> byId = workerRepository.findById(id);
        if (!byId.isPresent()) {
            return new ApiResponse("Not found",false);
        }
        Worker worker = byId.get();
        workerRepository.delete(worker);
        return new ApiResponse("Deleted",true,worker);
    }
}
