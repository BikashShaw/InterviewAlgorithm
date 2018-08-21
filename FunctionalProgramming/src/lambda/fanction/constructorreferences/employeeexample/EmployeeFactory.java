package lambda.fanction.constructorreferences.employeeexample;

public interface EmployeeFactory {
    public abstract Employee getEmployee(String name, Integer age);
}
