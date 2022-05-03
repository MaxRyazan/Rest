package ru.maxruazan.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.maxruazan.rest.entity.Employee;
import ru.maxruazan.rest.exception_handling.NoSuchEmployeeException;
import ru.maxruazan.rest.service.EmployeeService;
import java.util.List;

@RestController
@RequestMapping("/api")
public class MyRestController {

    private final EmployeeService employeeService;

    @Autowired
    public MyRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> showAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/employees/{id}")
    public Employee showOneEmployee(@PathVariable("id") int id) {
        Employee employee = employeeService.getEmployee(id);
        if(employee==null) {
        throw  new NoSuchEmployeeException("There is no employee with id= " + id);
        }
      return employee;
    }

    @PostMapping("/employees")
    public Employee addNewEmployee(@RequestBody Employee employee) {
    employeeService.saveEmployee(employee);
        return employee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
        return employee;
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable("id") int id) {
        Employee employee = employeeService.getEmployee(id);
        if(employee==null) {
            throw  new NoSuchEmployeeException("There is no employee with id= " + id);
        }
        employeeService.deleteEmployee(id);
        return "Employee with ID= " + id + " was deleted";
    }
}
