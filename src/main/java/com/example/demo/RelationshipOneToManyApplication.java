package com.example.demo;

import com.example.demo.model.Employee;
import com.example.demo.model.Manager;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.repository.ManagerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class RelationshipOneToManyApplication {

	public static void main(String[] args) {
		SpringApplication.run(RelationshipOneToManyApplication.class, args);
	}

	@Bean
	CommandLineRunner run(ManagerRepository managerRepository,
						  EmployeeRepository employeeRepository) {
		return args -> {

			// SAVE MANGER -> SAVE EMPLOYEE
			Employee maria = new Employee("Maria Carey");
			Employee john = new Employee("Johny Deep");
			List<Employee> employeeList_us = List.of(maria, john);

			Employee tung = new Employee("Tung Hoang");
			Employee tran = new Employee("Khanh Tran");
			List<Employee> employeeList_vn = List.of(tung, tran);

			Manager manager_us = new Manager("manager_us", employeeList_us);
			Manager manager_vn = new Manager("manager_vn", employeeList_vn);
			List<Manager> managerList = List.of(manager_us, manager_vn);

			managerRepository.saveAll(managerList);

			// SAVE MANAGER ONLY
			Manager manager_indian = new Manager("manager_indian", null);
			managerRepository.save(manager_indian);

			// SAVE EMPLOYEE ONLY
			Employee jutih = new Employee("Jutih Juddjn");
			employeeRepository.save(jutih);
		};
	}
}
