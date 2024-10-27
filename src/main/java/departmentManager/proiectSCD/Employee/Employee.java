package departmentManager.proiectSCD.Employee;

import departmentManager.proiectSCD.Department.Department;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private Boolean isManager;

    @ManyToOne
    @JoinColumn(name="department_id")
    private Department department;

    private String email;
}