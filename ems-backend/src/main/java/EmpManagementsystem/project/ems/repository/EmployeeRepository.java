// Package where this repository class is located
package EmpManagementsystem.project.ems.repository;

// Importing JpaRepository from Spring Data JPA
import org.springframework.data.jpa.repository.JpaRepository;

// Importing the Employee entity class
import EmpManagementsystem.project.ems.entity.Employee;

// This interface is used to interact with the database for Employee entity
// It extends JpaRepository which provides built-in methods like save(), findAll(), findById(), deleteById(), etc.
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // No need to write any code here – Spring Boot will handle all basic CRUD operations automatically
}
