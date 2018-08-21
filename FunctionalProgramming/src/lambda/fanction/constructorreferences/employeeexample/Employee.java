package lambda.fanction.constructorreferences.employeeexample;

public class Employee {
    String name;
    Integer age;

    //Contructor of employee
    public Employee(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}