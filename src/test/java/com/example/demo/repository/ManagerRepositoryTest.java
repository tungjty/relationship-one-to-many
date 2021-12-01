package com.example.demo.repository;

import com.example.demo.model.Manager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ManagerRepositoryTest {

    private final ManagerRepository managerRepository;

    @Autowired
    ManagerRepositoryTest(ManagerRepository managerRepository) {
        this.managerRepository = managerRepository;
    }

    @Test
    public void saveMangerOnly() {
        Manager manager_korean = new Manager("manager_korean", null);
        managerRepository.save(manager_korean);
    }

}