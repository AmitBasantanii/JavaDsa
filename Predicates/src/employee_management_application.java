import java.util.ArrayList;
import java.util.function.Predicate;

class Employee {
    String name;
    String designation;
    double salary;
    String city;

    public Employee(String name, String designation, double salary, String city) {
        this.name = name;
        this.designation = designation;
        this.salary = salary;
        this.city = city;
    }

    @Override
    public String toString() {
        String s = String.format("[%s, %s, %.2f, %s]", name, designation, salary, city);
        return s;
    }

    public boolean equals(Object obj) {
        Employee e = (Employee)obj;
        if(name.equals(e.name) && designation.equals(e.designation) && salary == e.salary && city == e.city) {
            return true;
        }
        else {
            return false;
        }
    }
}
public class employee_management_application {

    public static void main(String... args) {

        ArrayList<Employee> employeeArrayList = new ArrayList<Employee>();
        populate(employeeArrayList);

        Predicate<Employee> employeePredicate = emp -> emp.designation.equals("Manager");
        System.out.println("Manager's Information");
        display(employeePredicate, employeeArrayList);

        Predicate<Employee> employeePredicate1 = emp -> emp.city.equals("Banglore");
        System.out.println("Bangalore Employees Information");
        display(employeePredicate1, employeeArrayList);

        Predicate<Employee> employeePredicate2 = emp -> emp.salary<20000;
        System.out.println("Employees whose salary is <20000, to give increment");
        display(employeePredicate2, employeeArrayList);

        System.out.println("All managers from Banglore city for the pink slip");
        display(employeePredicate.and(employeePredicate1), employeeArrayList);

        System.out.println("Employees imformation who are either manager or salary <20000");
        display(employeePredicate.or(employeePredicate2), employeeArrayList);

        System.out.println("All employees information who are not managers");
        display(employeePredicate.negate(), employeeArrayList);

        Predicate<Employee> isCEO = Predicate.isEqual(new Employee("Amit", "CEO", 30000, "Indore"));

        Employee employee1 = new Employee("Amit", "CEO", 30000, "Indore");
        Employee employee2 = new Employee("Joe", "Manager", 20000, "Bhopal");

        System.out.println(isCEO.test(employee1)); // true
        System.out.println(isCEO.test(employee2));// false
    }

    public static void populate(ArrayList<Employee> employeeArrayList) {
        employeeArrayList.add(new Employee("Amit", "CEO", 30000, "Indore"));
        employeeArrayList.add(new Employee("Joe", "Manager", 20000, "Bhopal"));
        employeeArrayList.add(new Employee("Loe", "Manager", 20000, "Banglore"));
        employeeArrayList.add(new Employee("Zoya", "Lead", 15000, "Hyderabad"));
        employeeArrayList.add(new Employee("Neel", "Lead", 15000, "Banglore"));
        employeeArrayList.add(new Employee("Anushka", "Developer", 10000, "Hyderabad"));
        employeeArrayList.add(new Employee("Soumya", "Developer", 10000, "Hyderabad"));
        employeeArrayList.add(new Employee("Sunny", "Developer", 10000, "Banglore"));
        employeeArrayList.add(new Employee("Ram", "Developer", 10000, "Banglore"));
    }

    public static void display(Predicate<Employee> employeePredicate, ArrayList<Employee> employeeArrayList) {
        for(Employee e: employeeArrayList) {
            if(employeePredicate.test(e)) {
                System.out.println(e);
            }
        }
        System.out.println("*********************************");
    }
}
