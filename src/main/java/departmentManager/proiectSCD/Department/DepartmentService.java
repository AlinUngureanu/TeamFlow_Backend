package departmentManager.proiectSCD.Department;

import departmentManager.proiectSCD.Exception.DepartmentNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    DepartmentRepository departmentRepository;

    //read
    public List<Department> getAllDepartments(){
        return departmentRepository.findAll();
    }

    //create
    public Department addDepartment(Department newDepartment){
        return departmentRepository.save(newDepartment);
    }

    //update
    public Department updateDepartment(Department newDepartment, Integer id){
        return departmentRepository.findById(id)
                .map(currentDepartment -> {
                    if (newDepartment.getDescription() != null) {
                        currentDepartment.setDescription(newDepartment.getDescription());
                    }
                    if (newDepartment.getName() != null) {
                        currentDepartment.setName(newDepartment.getName());
                    }
                    return departmentRepository.save(currentDepartment);
                }).orElseThrow(() -> new DepartmentNotFoundException(id));
    }

    //delete
    public String deleteDepartment(Integer id){

        if(!departmentRepository.existsById(id)){
            throw new DepartmentNotFoundException(id);
        }
        departmentRepository.deleteById(id);
        return "Department with id " + id + " has been deleted successfully.";
    }
}
