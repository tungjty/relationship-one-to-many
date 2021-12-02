package com.example.demo.service;

import com.example.demo.model.Employee;
import com.example.demo.model.Manager;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.repository.ManagerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MangerServiceImpl implements ManagerService{

    private final ManagerRepository managerRepository;
    private final EmployeeRepository employeeRepository;

    @Override
    public Manager getManager(String name) {
        return managerRepository.findByFullName(name);
    }

    @Override
    public List<Manager> getManagers() {
        return managerRepository.findAll();
    }

    @Override
    public void deleteMangerById(Long id) {
        managerRepository.deleteById(id);
    }

    @Override
    public void removeOrphanEmployeeFromManager(Long ofManagerId, Long orphanEmployeeId) {
        Optional<Manager> ofManagerOptional = managerRepository.findById(ofManagerId);
        Optional<Employee> orphanEmployeeOptional = employeeRepository.findById(orphanEmployeeId);
        List<Employee> listEmpoloyees = ofManagerOptional.get().getEmployees();

        // WILL DELETE EMPLOYEE FROM MANAGER IN DB
        listEmpoloyees.remove(orphanEmployeeOptional.get());
        managerRepository.save(ofManagerOptional.get());
    }
}
