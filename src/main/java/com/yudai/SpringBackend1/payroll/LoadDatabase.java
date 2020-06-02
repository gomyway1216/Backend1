package com.yudai.SpringBackend1.payroll;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(EmployeeRepository employeeRepository, OrderRepository orderRepository) {
        return args -> {
          employeeRepository.save(new Employee("bibbo", "baggins", "birug"));
          employeeRepository.save(new Employee("frond", "baggines", "thief"));

          employeeRepository.findAll().forEach(employee -> log.info("Preloaded " + employee));

          orderRepository.save(new Order("Macbook pro", Status.COMPLETED));
          orderRepository.save(new Order("iphone", Status.IN_PROGRESS));

          orderRepository.findAll().forEach(order -> log.info("Preloaded " + order));
        };
    }
}
