package pl.sdacademy.java.oopschool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.*;

public class CsvStudentService {
    private final Logger logger = LoggerFactory.getLogger(CsvStudentService.class);

    public List<Student> getStudents() {
        return loadStudents();
    }

    public Optional<Student> getStudent(UUID uuid) {
        return loadStudents().stream()
            .filter(student -> uuid.equals(student.uuid()))
            .findAny();
    }

    private List<Student> loadStudents() {
        try(var studentCsvStream = CsvStudentService.class.getResourceAsStream("/students.csv")) {
            if (studentCsvStream == null) {
                return Collections.emptyList();
            }

            var scanner = new Scanner(studentCsvStream);

            List<Student> students = new LinkedList<>();

            while (scanner.hasNextLine()) {
                var student = parseLine(scanner.nextLine());
                students.add(student);
            }

            return students;
        }
        catch (IOException ioe) {
            logger.error("Error on input stream handling", ioe);
            throw new RuntimeException(ioe); //fail fast!
        }
    }

    private Student parseLine(String line) {
        logger.info("Parsing {}", line);
        String[] fields = line.split(",");
        return new Student(
          UUID.fromString(fields[0]),
            fields[2], //imię jest w 3 kolumnie
            fields[1], //nazwisko jest 2 kolumnie
            fields[3] //klasa
        );
    }
}
