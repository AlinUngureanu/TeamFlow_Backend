package departmentManager.proiectSCD.Exception;

public class DepartmentNotFoundException extends RuntimeException{

    public DepartmentNotFoundException(Integer id){
        super("Couldn't find the department with the id: " + id);
    }
}
