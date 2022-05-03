package ru.maxruazan.rest.service;



import ru.maxruazan.rest.entity.Employee;

import java.util.List;

public interface EmployeeService {

    public List<Employee> getAllEmployees();

    public void saveEmployee(Employee employee);

    Employee getEmployee(int id);

    public void deleteEmployee(int id);
}
