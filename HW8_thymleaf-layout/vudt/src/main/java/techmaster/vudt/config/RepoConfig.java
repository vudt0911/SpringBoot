package techmaster.vudt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import techmaster.vudt.repository.EmployeeDao;

@Configuration
public class RepoConfig {
    @Bean
    public EmployeeDao employeeDao(){
        return new EmployeeDao("employee.csv");
    }
}
