package com.example.hw2_9;

import org.springframework.stereotype.Service;

import java.util.Objects;

public class Employee {
    private String name;
    private String surname;
    private String patronymic;
    private int salary;
    private int department;

    public Employee(String surname, String name, String patronymic, int salary, int department) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.salary = salary;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public int getSalary() {
        return salary;
    }

    public int getDepartment() {
        return department;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee that = (Employee) o;
        return salary == that.salary && department == that.department && Objects.equals(name, that.name) && Objects.equals(surname, that.surname) && Objects.equals(patronymic, that.patronymic);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, patronymic, salary, department);
    }
}
