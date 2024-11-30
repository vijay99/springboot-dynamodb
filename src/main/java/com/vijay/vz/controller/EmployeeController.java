package com.vijay.vz.controller;


import com.vijay.vz.entity.Employee;
import com.vijay.vz.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController {

    private EmployeeRepository employeeRepository;

    @PostMapping("/employee")
    public Employee saveEmployee(@RequestBody Employee employee){
        return employeeRepository.save(employee);
    }

    @GetMapping("/employee/{empId}")
    public Employee getEmployee(@PathVariable("empId") String empId){
        return employeeRepository.getEmployeeById(empId);
    }

    @DeleteMapping("employee/{empId}")
    public String deleteEmployee(@PathVariable("empId") String empId){
        return employeeRepository.delete(empId);

    }
    @PutMapping("employee/{empId}")
    public String updateEmployee(@RequestBody Employee employee,@PathVariable("empId") String empId){
        return employeeRepository.update(empId,employee);
    }
}
