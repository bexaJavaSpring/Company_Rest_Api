package com.example.company_rest_api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class WorkerDto {
    private String name;
    private String phoneNumber;
    private Integer address_id;
    private Integer department_id;
}
