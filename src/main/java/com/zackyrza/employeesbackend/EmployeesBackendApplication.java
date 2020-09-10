package com.zackyrza.employeesbackend;

import com.zackyrza.employeesbackend.model.Division;
import com.zackyrza.employeesbackend.model.Employees;
import com.zackyrza.employeesbackend.model.Position;
import com.zackyrza.employeesbackend.repository.DivisionRepository;
import com.zackyrza.employeesbackend.repository.EmployeesRepositories;
import com.zackyrza.employeesbackend.repository.PositionRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

@SpringBootApplication
@EnableJpaAuditing
public class EmployeesBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmployeesBackendApplication.class, args);
    }

    @Bean
    ApplicationRunner init(EmployeesRepositories employeeRepository, DivisionRepository divisionRepository, PositionRepository positionRepository) {
        return args -> {
            AtomicInteger empNum = new AtomicInteger(1);
            AtomicInteger posNum = new AtomicInteger(1);
            Stream.of("Abdul", "Gofur").forEach(name -> {
                Employees employees = new Employees();
                employees.setId(empNum.longValue());
                employees.setName(name);
                employees.setType("DEMOTION");
                employees.setNik("EMP000"+empNum.intValue());
                employees.setDivisionId(1);
                employees.setPositionId(1);
                empNum.addAndGet(1);
                employeeRepository.save(employees);
            });
            Stream.of("IT", "HRD", "Loading", "Ticketing").forEach(name -> {
                Division division = new Division();
                division.setName(name);
                divisionRepository.save(division);
            });
            Stream.of("Staff", "Supervisor", "Asisten Manager", "Manager").forEach(name -> {
                Position position = new Position();
                position.setName(name);
                position.setLevel(posNum.intValue());
                posNum.addAndGet(1);
                positionRepository.save(position);
            });
            employeeRepository.findAll().forEach(System.out::println);
            divisionRepository.findAll().forEach(System.out::println);
            positionRepository.findAll().forEach(System.out::println);
        };
    }

}
