import java.util.ArrayList;
import java.util.function.BiFunction;

class Student {
    String name;
    int rollno;
    Student(String name, int rollno) {
        this.name = name;
        this.rollno = rollno;
    }
}
public class Student_BiFunction {
    public static void main(String[] args) {
        ArrayList<Student> studentArrayList = new ArrayList<Student>();
        BiFunction<String, Integer, Student> studentBiFunction = (name, rollno) -> new Student(name, rollno);

        studentArrayList.add(studentBiFunction.apply("Amit", 100));
        studentArrayList.add(studentBiFunction.apply("Ravi", 200));
        studentArrayList.add(studentBiFunction.apply("Sonu", 300));
        studentArrayList.add(studentBiFunction.apply("Golu", 400));
        for(Student student : studentArrayList) {
            System.out.println("Student name : " + student.name);
            System.out.println("Student rollno : " + student.rollno );
            System.out.println();
        }
    }
}
