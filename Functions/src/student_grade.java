import java.util.ArrayList;
import java.util.function.Function;
import java.util.function.Predicate;

class Student {
    String name;
    int marks;
    Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }
}
public class student_grade {
    public static void main(String[] args) {
        ArrayList<Student> studentArrayList = new ArrayList<Student>();
        populate(studentArrayList);

        Function<Student, String> function = s -> {
            int marks = s.marks;
            if(marks>=80) {
                return "A";
            }
            else if(marks>=60) {
                return "B";
            }
            else if(marks>=50) {
                return "C";
            }
            else if (marks >= 35) {
                return "D";
            }
            else {
                return "E - Failed";
            }
        };
        Predicate<Student> predicate = student -> student.marks >= 60;
        for(Student student : studentArrayList) {
            System.out.println("Student Name: " + student.name);
            System.out.println("Student Marks : " + student.marks);
            System.out.println("Student Grade : " + function.apply(student));
            System.out.println();
        }
    }

    public static void populate(ArrayList<Student> studentArrayList) {
        studentArrayList.add(new Student("Amit", 100));
        studentArrayList.add(new Student("Sunny", 65));
        studentArrayList.add(new Student("Bunny", 55));
        studentArrayList.add(new Student("Honey", 45));
        studentArrayList.add(new Student("Money", 25));

    }
}
