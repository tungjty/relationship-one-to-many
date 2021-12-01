package com.example.demo.controller;

import com.example.demo.model.Employee;
import com.example.demo.model.Manager;
import com.example.demo.service.EmployeeService;
import com.example.demo.service.ManagerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class ManagerController {

    private final ManagerService managerService;
    private final EmployeeService employeeService;

    public ManagerController(ManagerService managerService,
                             EmployeeService employeeService) {
        this.managerService = managerService;
        this.employeeService = employeeService;
    }

    @GetMapping(path = "manager")
    public Manager getManagerByName(@RequestParam("name") String name) {
        return managerService.getManager(name);
    }

    @GetMapping(path = "manager/all")
    public List<Manager> getAllManagers() {
        return managerService.getManagers();
    }

    @GetMapping(path = "employee/all")
    public List<Employee> getAllEmployeese() {
        return employeeService.getEmployeese();
    }

    @DeleteMapping(path = "manager/delete/{id}")
    public String deleteManager(@PathVariable("id") Long id) {
        managerService.deleteMangerById(id);
        return "MANAGER WAS REMOVED SUCCESSFULLY";
    }

    @DeleteMapping(path = "employee/delete/{id}")
    public String deleteEmployee(@PathVariable("id") Long id) {
        employeeService.deleteEmployeeById(id);
        return "EMPLOYEE WAS REMOVED SUCCESSFULLY";
    }
}
