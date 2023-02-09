package pl.sdacademy.java.oopschool;

import io.javalin.Javalin;
import io.javalin.http.HandlerType;
import io.javalin.http.HttpStatus;

import java.util.UUID;

public record WebApplication(CsvStudentService csvStudentService) {

    public void start() {
        Javalin.create()
            .addHandler(HandlerType.GET, "/students",
                ctx -> ctx.result(csvStudentService.getStudents().toString())
            )
            .addHandler(HandlerType.GET, "/students/{uuid}",
                ctx -> {
                    UUID uuid = UUID.fromString(ctx.pathParam("uuid"));
                    csvStudentService.getStudent(uuid).ifPresentOrElse(
                        student -> ctx.result(student.toString()),
                        () -> ctx.status(HttpStatus.NOT_FOUND).result("Nie ma takiego ucznia!")
                    );
                }
            )
            .start(8080);
    }
}