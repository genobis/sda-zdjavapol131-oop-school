package pl.sdacademy.java.oopschool;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class InMemoryStudentService {
    private final List<Student> students = List.of(
        new Student(
            UUID.fromString("fd60b673-43d2-482f-b020-68cf6d4af132"),
            "Tomasz",
            "Majbaum",
            "1B"
        )
    );

    public List<Student> getStudents() {
        return students;
    }

    public Optional<Student> getStudent(UUID uuid) {
        return students.stream()
            .filter(student -> uuid.equals(student.uuid()))
            .findAny();
    }
}
