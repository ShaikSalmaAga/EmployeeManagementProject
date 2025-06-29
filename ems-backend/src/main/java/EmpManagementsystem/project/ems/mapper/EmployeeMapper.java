// Package location for the mapper class
package EmpManagementsystem.project.ems.mapper;

// Importing the DTO and Entity classes
import EmpManagementsystem.project.ems.dto.EmployeeDto;
import EmpManagementsystem.project.ems.entity.Employee;

// This class helps convert between Employee Entity and Employee DTO
public class EmployeeMapper {
    
    // Converts an Employee (Entity) to EmployeeDto
    public static EmployeeDto mapToEmployeeDto(Employee employee){
        // Creating and returning a new DTO object from the entity fields
        return new EmployeeDto(
            employee.getId(),            // ID from entity
            employee.getFirstName(),     // First name from entity
            employee.getLastName(),      // Last name from entity
            employee.getEmail()          // Email from entity
        );
    }

    // Converts an EmployeeDto back to Employee (Entity)
    public static Employee mapToEmployee(EmployeeDto employeeDto){
        // Creating and returning a new Entity object from the DTO fields
        return new Employee(
            employeeDto.getId(),            // ID from DTO
            employeeDto.getFirstName(),     // First name from DTO
            employeeDto.getLastName(),      // Last name from DTO
            employeeDto.getEmail()          // Email from DTO
        );
    }

}
