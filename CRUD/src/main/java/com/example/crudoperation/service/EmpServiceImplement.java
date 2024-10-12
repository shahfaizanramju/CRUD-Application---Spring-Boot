package com.example.crudoperation.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.crudoperation.entity.EEntity;
import com.example.crudoperation.model.ModelDTO;
import com.example.crudoperation.repository.RRepository;


@Service
public class EmpServiceImplement implements EmpService {

    // List<Employee> employees = new ArrayList<>();
    
    @Autowired
    private RRepository empRepository;

    @Override
    public String creatEmployee(ModelDTO employee) {
        EEntity empEntity = new EEntity();
        BeanUtils.copyProperties(employee, empEntity);
        empRepository.save(empEntity);
        // employees.add(employee);
        return "Save Successfully";

    }

    @Override
    public ModelDTO readEmployee(Long id) {
        EEntity empEntity = empRepository.findById(id).get();
        ModelDTO employee = new ModelDTO();
        BeanUtils.copyProperties(empEntity, employee);
        return employee;

    }

    @Override
    public List<ModelDTO> readEmployees() {
        List<EEntity> employeesList = empRepository.findAll();
        List<ModelDTO> employees = new ArrayList<>();
        // for(int i=0;i<employeesList.size();i++){
        for (EEntity employeeEntity : employeesList) {

            ModelDTO emp = new ModelDTO();
            emp.setId(employeeEntity.getId());
            emp.setName(employeeEntity.getName());
            emp.setEmail(employeeEntity.getEmail());
            emp.setPhone(employeeEntity.getPhone());

            employees.add(emp);
        }
        return employees;
        
    }

    @Override
    public boolean deleteEmployee(Long id) {
        EEntity emp = empRepository.findById(id).get();
        empRepository.delete(emp);
        return true;
    }

    @Override
    public String updateEmployee(Long id, ModelDTO employee) {
        EEntity exestingEmployee = empRepository.findById(id).get();

        exestingEmployee.setEmail(employee.getEmail());
        exestingEmployee.setName(employee.getName());
        exestingEmployee.setPhone(employee.getPhone());

        empRepository.save(exestingEmployee);

        return "Update Succesfully";
    }

    @Override
    public ModelDTO getEmployeeById(Long id) {
        EEntity empEntity = empRepository.findById(id).orElse(null);
        ModelDTO emp = null;
        if (empEntity != null) {
            ModelDTO employee = new ModelDTO();
            BeanUtils.copyProperties(empEntity, employee);
            emp = employee;
        }
        return emp; // Handle not found case
    }



}
