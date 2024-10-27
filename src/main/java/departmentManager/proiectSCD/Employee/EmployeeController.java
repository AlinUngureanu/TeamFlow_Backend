package departmentManager.proiectSCD.Employee;

import departmentManager.proiectSCD.Department.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @PostMapping("/add-employee")
    public Employee addEmployee(@RequestBody Employee employee){
        return employeeService.addEmployee(employee);
    }

    @PutMapping("/update-employee/{id}")
    public Employee updateEmployee(@RequestBody Employee employee, @PathVariable Integer id){
        return employeeService.updateEmployee(employee,id);
    }

    @DeleteMapping("/delete-employee/{id}")
    public String deleteEmployee(@PathVariable Integer id){
        return employeeService.deleteEmployee(id);
    }

    @GetMapping("/get-all-employees-per-department")
    public List<Employee> getAllEmployeesPerDepartment(@RequestBody Department department){
        return employeeService.getAllEmployeesPerDepartment(department);
    }

    @GetMapping("/get-all-managers-per-department/{isManager}")
    public List<Employee> getAllManagersPerDepartment(@RequestBody Department department, @PathVariable Boolean isManager){
        return employeeService.getAllManagersPerDepartment(department, isManager);
    }
}