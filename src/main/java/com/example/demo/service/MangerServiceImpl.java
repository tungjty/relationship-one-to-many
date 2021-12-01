package com.example.demo.service;

import com.example.demo.model.Manager;
import com.example.demo.repository.ManagerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MangerServiceImpl implements ManagerService{

    private final ManagerRepository managerRepository;

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
}
