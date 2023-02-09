package pl.sdacademy.java.oopschool.student.infrastructure;

import pl.sdacademy.java.oopschool.student.domain.Student;

import java.util.List;

public class CachingStudentDataProvider extends CsvStudentDataProvider{

    private List<Student> students;

    @Override
    public List<Student> getData() {
        if (students == null) {
            students = super.getData();
        }
        return students;
    }
}
