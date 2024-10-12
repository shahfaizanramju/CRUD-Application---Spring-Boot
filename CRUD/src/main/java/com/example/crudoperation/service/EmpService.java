package com.example.crudoperation.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.crudoperation.model.ModelDTO;

@Service
public interface EmpService {

    String creatEmployee(ModelDTO employee);
    List<ModelDTO> readEmployees();
    boolean deleteEmployee(Long id);
    String updateEmployee(Long id, ModelDTO employee);
    ModelDTO readEmployee(Long id);
    ModelDTO getEmployeeById(Long id);
   


}
