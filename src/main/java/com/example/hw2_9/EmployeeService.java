package com.example.hw2_9;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeService {
    private final static Map<String, Employee> allEmployee=new HashMap<>();


    public  EmployeeService (){

        allEmployee.put ( "FrolovaKatya",new Employee("Frolova","Katya","Mihailovna",21000,5));
        allEmployee.put("FisherKatya",new Employee("Fisher", "Katya","Mihailovna",32000,5));
        allEmployee.put("FricKatya", new Employee("Fric","Katya","Mihailovna",93000,5));
        allEmployee.put("FlowerKatya", new Employee("Flower","Katya","Mihailovna",44000,2));
        allEmployee.put( "FeetKatya",new Employee("Feet","Katya","Mihailovna",55000,4));
        allEmployee.put("IvanovIvan" ,new Employee("Ivanov", "Ivan","Mihailovna",16000,3));

    }

    public  Map<String, Employee> findAll(){  //возврщает и ключ и значение
        return allEmployee;
    }

    public  Employee addEmployee(String lastName,String firstName,String patronomic,int salary, int department) { // возвращает только значение
        Employee newEmployee = new Employee(lastName,firstName,patronomic,salary,department);
        String keyAdd=lastName+firstName;
        if (lastName == null || firstName == null) {
            System.out.println("отсутсвует первый или второй параметр");
            return null;
        } else if (allEmployee.containsKey(key( lastName,firstName))) {
            throw new EmployeeAlreadyAddedException("такой уже есть");
        } else {
            allEmployee.put(keyAdd,newEmployee);
        }
        return newEmployee;
    }

    public   Employee removeEmployee(String lastName,String firstName,String patronomic,int salary, int department){
        Employee removeEmployee = new Employee(lastName,firstName,patronomic,salary,department);
        String keyAdd2=lastName+firstName;
        if(firstName == null || lastName == null) {
            System.out.println("отсутсвует первый или второй параметр");
            return null;
        }else if (!allEmployee.containsKey(keyAdd2)) {
            throw new EmployeeNotFoundException("сотрудник не найден");
        } else {
            allEmployee.remove(key( lastName,firstName));
        }
        return  removeEmployee;
    }
    public Employee findEmployee(String lastName,String firstName,String patronomic,int salary, int department) {
        Employee findEmployee1 = new Employee(lastName,firstName,patronomic,salary,department);
        if(firstName == null || lastName == null) {
            System.out.println("отсутсвует первый или второй параметр");
            return null;
        }else if (!allEmployee.containsKey(key(lastName, firstName))) {
            throw new EmployeeNotFoundException("сотрудник не найден");
        } else {
            allEmployee.remove(key( lastName,firstName));
        }
        return  findEmployee1;

    }
    private String key(String lastName,String firstName ){
        return lastName+firstName;
    }

}
