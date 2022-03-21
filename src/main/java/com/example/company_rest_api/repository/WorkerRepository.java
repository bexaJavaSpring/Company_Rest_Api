package com.example.company_rest_api.repository;

import com.example.company_rest_api.entity.Worker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkerRepository extends JpaRepository<Worker,Integer> {
}
