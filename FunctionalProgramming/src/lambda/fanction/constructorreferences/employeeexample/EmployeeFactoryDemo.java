package lambda.fanction.constructorreferences.employeeexample;

public class EmployeeFactoryDemo {
    public static void main(String[] args) {
        EmployeeFactory empFactory = Employee::new;
        Employee emp = empFactory.getEmployee("John Hammond", 25);

        System.out.println(emp);
    }
}
