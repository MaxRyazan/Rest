package ru.maxruazan.rest.DAO;


import ru.maxruazan.rest.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

     List<Employee> getAllEmployees();

    void saveEmployee(Employee employee);

    Employee getEmployee(int id);

    void deleteEmployee(int id);
}
