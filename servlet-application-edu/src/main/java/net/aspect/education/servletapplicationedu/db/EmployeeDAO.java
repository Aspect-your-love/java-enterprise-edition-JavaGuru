package net.aspect.education.servletapplicationedu.db;

import net.aspect.education.servletapplicationedu.entity.Employee;
import net.aspect.education.servletapplicationedu.entity.enums.Company;

import java.util.List;

public class EmployeeDAO {
    List<Employee> employees;

    {
        employees = List.of(
          new Employee(1L, "Ksue", 32, 1000, Company.SPYKE_AND_Hole),
          new Employee(2L, "Misha", 14, 600, Company.HOME_LAND),
          new Employee(3L, "Oleg", 24, 20, Company.HOME_LAND),
          new Employee(4L, "Viktor", 10, 10_000, Company.GOOGLE),
          new Employee(5L, "Stepan", 75, 200, Company.INFINITY),
          new Employee(6L, "Kol't", 20, 5000, Company.YANDEX),
          new Employee(7L, "Karina", 20, 5000, Company.GOOGLE),
          new Employee(8L, "Lilo", 64, 1000, Company.SPYKE_AND_Hole)
        );
    }

    public List<Employee> getEmployees() {
        return employees;
    }
}
