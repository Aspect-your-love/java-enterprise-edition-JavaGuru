package net.aspect.education.servletapplicationedu.entity;

import net.aspect.education.servletapplicationedu.entity.enums.Company;

public class Employee {
    private Long id;
    private String name;
    private int age;
    private int salary;
    private Company companyName;

    public Employee(Long id, String name, int age, int salary, Company companyName) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.companyName = companyName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Company getCompanyName() {
        return companyName;
    }

    @Override
    public String toString() {
        return "Employee[" +
               "id=" + id +
               ", name='" + name + '\'' +
               ", age=" + age +
               ", salary=" + salary +
               ", companyName=" + companyName +
               ']';
    }

    public void setCompanyName(Company companyName) {
        this.companyName = companyName;
    }
}
