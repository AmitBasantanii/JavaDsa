import java.sql.Time;
import java.util.function.BiFunction;

class Employee {
    int id;
    String name;
    double dailyWage;
    Employee(int id, String name, double dailyWage) {
        this.id = id;
        this.name = name;
        this.dailyWage = dailyWage;
    }
}

class TimeSheet {
    int id;
    int days;
    TimeSheet(int id, int days) {
        this.id = id;
        this.days = days;
    }
}
public class Employee_BiFunction {
    public static void main(String[] args) {
        BiFunction<Employee, TimeSheet, Double> biFunction = (e,t) -> e.dailyWage*t.days;
        Employee e = new Employee(101, "Amit", 1500);
        TimeSheet t = new TimeSheet(101, 25);
        System.out.println("Employee Monthly Salary: " + biFunction.apply(e,t));
    }
}
