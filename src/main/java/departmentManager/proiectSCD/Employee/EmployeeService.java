package departmentManager.proiectSCD.Employee;

import departmentManager.proiectSCD.Department.Department;
import departmentManager.proiectSCD.Exception.EmployeeNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    //read
    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    //create
    public Employee addEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    //update
    public Employee updateEmployee(Employee newEmployee, Integer id){
        return employeeRepository.findById(id)
                .map(currentEmployee -> {
                    if (newEmployee.getEmail() != null) {
                        currentEmployee.setEmail(newEmployee.getEmail());
                    }
                    if (newEmployee.getIsManager() != null) {
                        currentEmployee.setIsManager(newEmployee.getIsManager());
                    }
                    if (newEmployee.getName() != null) {
                        currentEmployee.setName(newEmployee.getName());
                    }
                    if (newEmployee.getDepartment() != null) {
                        currentEmployee.setDepartment(newEmployee.getDepartment());
                    }
                    return employeeRepository.save(currentEmployee);
                }).orElseThrow(() -> new EmployeeNotFoundException(id));
    }

    //delete
    public String deleteEmployee(Integer id){

        if(!employeeRepository.existsById(id)){
            throw new EmployeeNotFoundException(id);
        }
        employeeRepository.deleteById(id);
        return "Employee with id " + id + " has been deleted successfully.";
    }

    //get all employees per department
    public List<Employee> getAllEmployeesPerDepartment(Department department){
        return employeeRepository.findAllByDepartment(department);
    }

    //get all managers per department
    public List<Employee> getAllManagersPerDepartment(Department department, Boolean isManager){
        return employeeRepository.findAllByDepartmentAndIsManager(department,isManager);
    }
}