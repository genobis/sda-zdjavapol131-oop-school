package pl.sdacademy.java.oopschool;

import pl.sdacademy.java.oopschool.student.domain.StudentService;
import pl.sdacademy.java.oopschool.student.infrastructure.CachingStudentDataProvider;
import pl.sdacademy.java.oopschool.student.infrastructure.CsvStudentDataProvider;

public class Main {
    public static void main(String[] args) {
        StudentService studentService = new StudentService(
            new CachingStudentDataProvider()
        );

        //alternatywnie
//        StudentService studentService = new StudentService(
//            new InMemoryStudentDataProvider()
//        );

        new WebApplication(studentService).start();
    }
}
