// This class is in the controller package (handles API requests)
package EmpManagementsystem.project.ems.controller;

import java.util.List;

// Spring classes to handle HTTP responses
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

// Used to mark this as a REST controller
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// Importing the DTO (used to send/receive employee data)
import EmpManagementsystem.project.ems.dto.EmployeeDto;

// Importing the service that contains business logic
import EmpManagementsystem.project.ems.service.EmployeeService;

// Lombok will auto-generate constructor for required fields
import lombok.AllArgsConstructor;

// CORS support so frontend (like React) can call the backend
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

// Allow requests from any origin (frontend can connect without error)
@CrossOrigin("*")

// Lombok will create a constructor with all required dependencies
@AllArgsConstructor

// Marks this class as a REST API controller
@RestController

// Base URL for all endpoints in this controller
@RequestMapping("/api/employees")
public class EmployeeController {

    // Reference to the service layer that contains logic
    private EmployeeService employeeService;

    // POST - Create a new employee
    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto) {
        EmployeeDto savedEmployee = employeeService.createEmployee(employeeDto);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED); // 201 Created
    }

    // GET - Get employee by ID
    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDto> getEmployeeId(@PathVariable("id") Long employeeId) {
        EmployeeDto employeeDto = employeeService.getEmployeeById(employeeId);
        return ResponseEntity.ok(employeeDto); // 200 OK
    }

    // GET - Get all employees
    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployees() {
        List<EmployeeDto> employees = employeeService.getAllEmployees();
        return ResponseEntity.ok(employees); // 200 OK
    }

    // PUT - Update an existing employee
    @PutMapping("/{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id") Long employeeId, 
        @RequestBody EmployeeDto updatedEmployee) {
        EmployeeDto employeeDto = employeeService.updateEmployee(employeeId, updatedEmployee);
        return ResponseEntity.ok(employeeDto); // 200 OK
    }

    // DELETE - Delete an employee by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long employeeId) {
        employeeService.deleteEmployee(employeeId);
        return ResponseEntity.ok("Employee deleted successfully"); // 200 OK with message
    }
}
