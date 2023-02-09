package pl.sdacademy.java.oopschool;

public class Main {
    public static void main(String[] args) {
        CsvStudentService csvStudentService = new CsvStudentService();

        new WebApplication(csvStudentService).start();
    }
}
