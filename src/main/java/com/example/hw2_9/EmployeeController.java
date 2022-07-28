package com.example.hw2_9;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {              // http://localhost:8080/employee/add?firstName=Ivan&lastName=Ivanov
    private final  EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService){
        this.employeeService=employeeService;
    }

    @GetMapping(path = "/add")
    public Employee add (@RequestParam (value = "firstName",required = false) String userName,
                         @RequestParam (value = "lastName",required = false) String userSurname,
                         @RequestParam (value = "patronomic",required = false) String userPatronomic,
                         @RequestParam (value = "salary",required = false) int userSalary,
                         @RequestParam (value = "department",required = false) int userDepartment){
        return employeeService.addEmployee(userSurname,userName,userPatronomic,userSalary,userDepartment);
    }

    @GetMapping(path = "/remove")
    public Employee remove (@RequestParam ("firstName") String userName,
                            @RequestParam ("lastName") String userSurname,
                            @RequestParam (value = "patronomic",required = false) String userPatronomic,
                            @RequestParam (value = "salary",required = false) int userSalary,
                            @RequestParam (value = "department",required = false) int userDepartment){
        return employeeService.removeEmployee(userSurname,userName,userPatronomic,userSalary,userDepartment);
    }

    @GetMapping(path = "/findall")
    public Map<String,Employee> findAll (){
        return employeeService.findAll();
    }
}











