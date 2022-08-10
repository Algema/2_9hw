package com.example.hw2_9;

import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DepartmentService {
    private  final  EmployeeService employeeService;

    public DepartmentService(EmployeeService employeeService){
        this.employeeService=employeeService;
    }
    public  Employee maxSalary(int departmentId) {
        Map<String, Employee> employees = employeeService.findAll();
       final Employee maxSalaryEmployee= employees
                .values()
                .stream()
                .filter(e -> e.getDepartment()==departmentId)
                .max(Comparator.comparingInt(e -> e.getSalary()))
                .orElseThrow(()-> new EmployeeNotFoundException("не найден"));
       return  maxSalaryEmployee;

    }
    public  Employee minSalary(int departmentId) {
        Map<String, Employee> employees = employeeService.findAll();
        final Employee minSalaryEmployee= employees
                .values()
                .stream()
                .filter(e -> e.getDepartment()==departmentId)
                .min(Comparator.comparingInt(e -> e.getSalary()))
                .orElseThrow(()-> new EmployeeNotFoundException("не найден") );
        return  minSalaryEmployee;

    }
    public Map<Integer,List<Employee>> allEmployees2() {
        Map<String, Employee> employees = employeeService.findAll();
        final Map<Integer,List<Employee>> allEmployees2= employees
                .values()
                .stream()
                .collect(Collectors.groupingBy(e->e.getDepartment()));
        return  allEmployees2;
    }

    public List<Employee> allEmployees(int departmentId) {
        Map<String, Employee> employees = employeeService.findAll();
        final List <Employee> allEmployees= employees
                .values()
                .stream()
                .filter(e -> e.getDepartment()==departmentId)
                .collect(Collectors.toList());
        return   allEmployees;
    }
}
