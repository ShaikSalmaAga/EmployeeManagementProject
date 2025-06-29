// Package name where this DTO class is located
package EmpManagementsystem.project.ems.dto;

// Lombok annotation to automatically generate getters for all fields
import lombok.AllArgsConstructor;
import lombok.Getter;
// Lombok annotation to automatically generate a no-argument constructor
import lombok.NoArgsConstructor;
// Lombok annotation to automatically generate setters for all fields
import lombok.Setter;

// Automatically generate getters for all fields
@Getter  
// Automatically generate setters for all fields
@Setter  
// Automatically generate a no-argument constructor (needed for frameworks)
@NoArgsConstructor  
// Automatically generate a constructor with all fields
@AllArgsConstructor  

// DTO (Data Transfer Object) class to transfer employee data between layers
public class EmployeeDto {
    
    // ID of the employee
    private Long id;

    // First name of the employee
    private String firstName;

    // Last name of the employee
    private String lastName;

    // Email of the employee
    private String email;
}
