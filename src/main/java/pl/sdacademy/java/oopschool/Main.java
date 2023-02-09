package pl.sdacademy.java.oopschool;

public class Main {
    public static void main(String[] args) {
        StudentService studentService = new StudentService(
            new CsvStudentDataProvider()
        );

        //alternatywnie
//        StudentService studentService = new StudentService(
//            new InMemoryStudentDataProvider()
//        );

        new WebApplication(studentService).start();
    }
}
