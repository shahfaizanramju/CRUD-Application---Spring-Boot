package com.example.crudoperation.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.DeleteExchange;

import com.example.crudoperation.model.ModelDTO;
import com.example.crudoperation.service.EmpService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/")
public class Controller {

    @Autowired
    public EmpService empService;

    @GetMapping
    public List<ModelDTO> getAllEmployees() {
        return empService.readEmployees();
    }

    @GetMapping("/{id}")
    public String getEmployeeById(@PathVariable Long id) {
        ModelDTO employee = empService.getEmployeeById(id);
        if (employee == null) {
            return "ID not found";
        }
        return " "+ employee;
    }

    @PostMapping
    public String creatEmployees(@RequestBody ModelDTO employee) {
        return empService.creatEmployee(employee);

    }

    @DeleteExchange("{id}")
    public String deleteEmployees(@PathVariable Long id) {
        if (empService.deleteEmployee(id)) {
            return "Delete Successfully";
        }
        return "ID not found";
    }

    @PutMapping("{id}")
    public String putMethodName(@PathVariable Long id, @RequestBody ModelDTO employee) {
        return empService.updateEmployee(id, employee);
    }

}
