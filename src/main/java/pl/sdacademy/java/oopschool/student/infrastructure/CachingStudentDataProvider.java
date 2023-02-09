package pl.sdacademy.java.oopschool.student.infrastructure;

import pl.sdacademy.java.oopschool.student.domain.Student;
import pl.sdacademy.java.oopschool.student.domain.StudentDataProvider;

import java.util.List;

public class CachingStudentDataProvider implements StudentDataProvider {

    private final StudentDataProvider internal;

    private List<Student> students;

    public CachingStudentDataProvider(StudentDataProvider internal) {
        this.internal = internal;
    }

    @Override
    public List<Student> getData() {
        if (students == null) {
            students = internal.getData();
        }
        return students;
    }
}
