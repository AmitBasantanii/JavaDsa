import java.util.ArrayList;
import java.util.Collections;

class Employee {
    int eno;
    String ename;
    Employee(int eno, String ename) {
        this.eno = eno;
        this.ename = ename;
    }
    public String toString() {
        return eno + ":" + ename;
    }
}

public class employee_descending_sorting {

    public static void main(String[] args) {

        ArrayList<Employee> employeeArrayList = new ArrayList<Employee>();
        employeeArrayList.add(new Employee(100, "Amit"));
        employeeArrayList.add(new Employee(600, "John"));
        employeeArrayList.add(new Employee(200, "Alice"));
        employeeArrayList.add(new Employee(400, "Bob"));
        employeeArrayList.add(new Employee(500, "Alia"));
        employeeArrayList.add(new Employee(300, "Monika"));
        employeeArrayList.add(new Employee(700, "Africa"));

        System.out.println("Before sorting" + employeeArrayList);

        Collections.sort(employeeArrayList, (e1,e2) -> (e1.eno<e2.eno)?-1:(e1.eno> e2.eno)?1:0);
        System.out.println("After sorting" + employeeArrayList);
    }

}
