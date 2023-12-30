import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {
        Instructor instructor = new Instructor(1, "Jonathan", "De la Cruz");
        instructor.instructorInformation();
        Course course = new Course(1, "Java", instructor);
        Student student = new Student(1, "Jane", "Brown");
        student.enroll(course);
        student.studentInformation();
        Instructor instructor2 = new Instructor(2, "Mike", "Smith");
        instructor2.instructorInformation();
        Course course2 = new Course(2, "Python", instructor2);
        student.enroll(course2);
        student.studentInformation();
    }
}