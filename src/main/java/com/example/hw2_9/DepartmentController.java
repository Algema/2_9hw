package com.example.hw2_9;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/departments")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService){this.departmentService=departmentService;}

// /departments/max-salary?departmentId=5
    @GetMapping(path ="/max-salary" )
    public Employee maxSalary (@RequestParam(value = "departmentId") int departmentId){
        return departmentService.maxSalary(departmentId);
    }
//    /departments/min-salary?departmentId=5
    @GetMapping(path  ="/min-salary")
    public Employee minSalary (@RequestParam(value = "departmentId") int departmentId){
        return departmentService.minSalary(departmentId);
    }
//    /departments/all?departmentId=5
    @GetMapping(path ="/all",params = {"departmentId"})
    public List <Employee> allEmployees (@RequestParam(value = "departmentId") int departmentId){
        return  departmentService.allEmployees(departmentId);
    }
//    /departments/all
    @GetMapping(path ="/all")
    public List<Employee> allEmployees2 (){
    return departmentService.allEmployees2();
}







}
