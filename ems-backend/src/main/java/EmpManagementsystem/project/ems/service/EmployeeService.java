// Package name where this interface belongs
package EmpManagementsystem.project.ems.service;

// Importing List interface from java.util to use for lists
import java.util.List;

// Importing EmployeeDto class to transfer employee data
import EmpManagementsystem.project.ems.dto.EmployeeDto;

// This is a service interface for employee-related business logic
public interface EmployeeService {

    // Method to create a new employee
    // Takes employee data as input (DTO) and returns the created employee
    EmployeeDto createEmployee(EmployeeDto employeeDto);

    // Method to get a single employee by their ID
    // Returns the employee data if found
    EmployeeDto getEmployeeById(Long employeeId);

    // Method to get a list of all employees
    // Returns a list of EmployeeDto objects
    List<EmployeeDto> getAllEmployees();

    // Method to update an existing employee's details
    // Takes employee ID and updated data as input, returns the updated employee
    EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee);

    // Method to delete an employee by ID
    // Does not return anything (void)
    void deleteEmployee(Long employeeId);
}
