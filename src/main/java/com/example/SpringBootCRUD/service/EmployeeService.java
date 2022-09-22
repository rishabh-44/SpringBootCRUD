package com.example.SpringBootCRUD.service;

import com.example.SpringBootCRUD.model.Employee;
import com.example.SpringBootCRUD.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }
    public List<Employee> getEmployeesByCity(String city) {
        return employeeRepository.findAllByCity(city);
    }

    public String saveEmployee(Employee employee) {
        if (employeeRepository.existsById(employee.getId())) {
            return "Employee already exists";
        } else {
            employeeRepository.save(employee);
            return "Save successfully";
        }
    }

    public String putEmployee(Employee employee) {
        if (employeeRepository.existsById(employee.getId())) {
            employeeRepository.save(employee);
            return "Data Updated successfully";
        } else {
            return "Employee doesn't exists";
        }
    }
    public String deleteEmployee(Employee employee) {
        if (employeeRepository.existsById(employee.getId())) {
            employeeRepository.delete(employee);
            return "Data deleted successfully";
        } else {
            return "Employee doesn't exists";
        }
    }

    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee getEmployeeById(Long id) {
//        return employeeRepository.getReferenceById(id);
        return employeeRepository.findById(id).get();
    }

    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    public void delete(Employee employee) {
        employeeRepository.delete(employee);
    }
}