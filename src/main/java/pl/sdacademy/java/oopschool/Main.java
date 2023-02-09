package pl.sdacademy.java.oopschool;

public class Main {
    public static void main(String[] args) {
        InMemoryStudentService inMemoryStudentService = new InMemoryStudentService();

        new WebApplication(inMemoryStudentService).start();
    }
}
