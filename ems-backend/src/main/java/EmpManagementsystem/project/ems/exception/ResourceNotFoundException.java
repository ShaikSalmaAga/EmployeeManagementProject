// Package name for organizing exception-related classes
package EmpManagementsystem.project.ems.exception;

// Importing HTTP status codes from Spring framework
import org.springframework.http.HttpStatus;

// Tells Spring to return HTTP 404 (Not Found) when this exception is thrown
import org.springframework.web.bind.annotation.ResponseStatus;

// When this exception is thrown, Spring will return a 404 Not Found status
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

    // Constructor: Accepts a custom error message (e.g., "Employee not found")
    public ResourceNotFoundException(String message) {
        // Call the parent class (RuntimeException) constructor with the message
        super(message);
    }

}
