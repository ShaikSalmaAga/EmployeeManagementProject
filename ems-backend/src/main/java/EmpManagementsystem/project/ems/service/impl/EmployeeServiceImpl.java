// Define the package this class belongs to
package EmpManagementsystem.project.ems.service.impl;

// Import necessary libraries
import java.util.stream.Collectors; // For converting list of entities to list of DTOs
import java.util.List;              // For using List data structure

import org.springframework.stereotype.Service; // To mark this class as a service in Spring
import lombok.AllArgsConstructor;             // Lombok annotation to generate constructor for final fields

// Import your own project classes
import EmpManagementsystem.project.ems.dto.EmployeeDto; // Data Transfer Object for Employee
import EmpManagementsystem.project.ems.entity.Employee; // Entity class mapped to database table
import EmpManagementsystem.project.ems.exception.ResourceNotFoundException; // Custom exception
import EmpManagementsystem.project.ems.mapper.EmployeeMapper; // Converts Entity <-> DTO
import EmpManagementsystem.project.ems.repository.EmployeeRepository; // JPA repository for database access
import EmpManagementsystem.project.ems.service.EmployeeService; // Service interface

// Marks this class as a Spring service class for business logic
@Service

// Lombok annotation to create a constructor with all required dependencies (final fields)
@AllArgsConstructor

// Class that implements business logic defined in the EmployeeService interface
public class EmployeeServiceImpl implements EmployeeService {

    // Dependency for database operations (injected automatically)
    private final EmployeeRepository employeeRepository;

    // Method to create a new employee
    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        // Convert incoming DTO to Entity
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);

        // Save employee entity into the database
        Employee savedEmployee = employeeRepository.save(employee);

        // Convert saved entity back to DTO and return
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    // Method to fetch employee details by ID
    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        // Try to find employee by ID, throw exception if not found
        Employee employee = employeeRepository.findById(employeeId)
            .orElseThrow(() ->
                new ResourceNotFoundException("Employee does not exist with given id: " + employeeId)
            );

        // Convert found employee entity to DTO and return
        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    // Method to get all employees
    @Override
    public List<EmployeeDto> getAllEmployees() {
        // Fetch all employee entities from the database
        List<Employee> employees = employeeRepository.findAll();

        // Convert each entity to DTO using stream and return list of DTOs
        return employees.stream()
            .map((employee) -> EmployeeMapper.mapToEmployeeDto(employee))
            .collect(Collectors.toList());
    }

    // Method to update existing employee data
    @Override
    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee) {
        // Find the employee by ID or throw exception if not found
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(
            () -> new ResourceNotFoundException("Employee does not exists with given id: " + employeeId)
        );

        // Update employee details with new values
        employee.setFirstName(updatedEmployee.getFirstName());
        employee.setLastName(updatedEmployee.getLastName());
        employee.setEmail(updatedEmployee.getEmail());

        // Save the updated employee entity into the database
        Employee updatedEmployeeObj = employeeRepository.save(employee);

        // Convert updated entity to DTO and return
        return EmployeeMapper.mapToEmployeeDto(updatedEmployeeObj);
    }

    // Method to delete an employee by ID
    @Override
    public void deleteEmployee(Long employeeId) {
        // Check if employee exists or throw exception
        employeeRepository.findById(employeeId).orElseThrow(
            () -> new ResourceNotFoundException("Employee does not exists with given id: " + employeeId)
        );

        // Delete employee from the database
        employeeRepository.deleteById(employeeId);
    }
}
