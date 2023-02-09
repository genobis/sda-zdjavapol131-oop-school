package pl.sdacademy.java.oopschool;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class StudentService {
    // Kompozycja - użycie wzorca Strategia
    private final StudentDataProvider studentDataProvider;

    public StudentService(StudentDataProvider studentDataProvider) {
        this.studentDataProvider = studentDataProvider;
    }

    public List<Student> getStudents() {
        return studentDataProvider.getData();
    }

    public Optional<Student> getStudent(UUID uuid) {
        return studentDataProvider.getData().stream()
            .filter(student -> uuid.equals(student.uuid()))
            .findAny();
    }
}
