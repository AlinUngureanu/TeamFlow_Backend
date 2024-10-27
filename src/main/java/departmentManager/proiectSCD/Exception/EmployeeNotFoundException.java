package departmentManager.proiectSCD.Exception;

public class EmployeeNotFoundException extends RuntimeException{

    public EmployeeNotFoundException(Integer id){
        super("Couldn't find the employee with the id: " + id);
    }
}