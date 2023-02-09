package pl.sdacademy.java.oopschool;

import io.javalin.Javalin;
import io.javalin.http.HandlerType;
import io.javalin.http.HttpStatus;

import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        InMemoryStudentService inMemoryStudentService = new InMemoryStudentService();

        Javalin.create()
            .addHandler(HandlerType.GET, "/students",
                ctx -> ctx.result(inMemoryStudentService.getStudents().toString())
            )
            .addHandler(HandlerType.GET, "/students/{uuid}",
                ctx -> {
                    UUID uuid = UUID.fromString(ctx.pathParam("uuid"));
                    inMemoryStudentService.getStudent(uuid).ifPresentOrElse(
                        student -> ctx.result(student.toString()),
                        () -> ctx.status(HttpStatus.NOT_FOUND).result("Nie ma takiego ucznia!")
                    );
                }
            )
            .start(8080);
    }
}
