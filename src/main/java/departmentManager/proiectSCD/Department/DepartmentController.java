package departmentManager.proiectSCD.Department;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    @GetMapping("/departments")
    public List<Department> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

    @PostMapping("/add-department")
    public Department addDepartment(@RequestBody Department newDepartment){
        return departmentService.addDepartment(newDepartment);
    }

    @PutMapping("/update-department/{id}")
    public Department updateDepartment(@RequestBody Department department, @PathVariable Integer id){
        return departmentService.updateDepartment(department,id);
    }

    @DeleteMapping("/delete-department/{id}")
    public String deleteDepartment(@PathVariable Integer id){
        return departmentService.deleteDepartment(id);
    }
}