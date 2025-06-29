// Package where this entity class is placed
package EmpManagementsystem.project.ems.entity;

// Importing required JPA and Lombok annotations
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// Lombok annotation to generate getters for all fields
@Getter  
// Lombok annotation to generate setters for all fields
@Setter  
// Lombok annotation to generate a no-argument constructor
@NoArgsConstructor  
// Lombok annotation to generate a constructor with all fields
@AllArgsConstructor  

// Marks this class as a JPA entity to map it to a database table
@Entity  
// Specifies the name of the database table as "employees"
@Table(name = "employees")  
public class Employee {

    // Marks 'id' as the primary key for the table
    @Id  
    // Automatically generates the value for 'id' (auto-increment)
    @GeneratedValue(strategy = GenerationType.IDENTITY)  
    private Long id;

    // Maps this field to the 'first_name' column in the database
    @Column(name = "first_name")  
    private String firstName;

    // Maps this field to the 'last_name' column in the database
    @Column(name = "last_name")  
    private String lastName;

    // Maps this field to the 'email' column, making it required (not null) and unique
    @Column(name = "email", nullable = false, unique = true)  
    private String email;
}
