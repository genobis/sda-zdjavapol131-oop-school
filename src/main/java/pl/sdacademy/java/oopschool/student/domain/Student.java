package pl.sdacademy.java.oopschool.student.domain;

import java.util.UUID;

public record Student(UUID uuid, String firstName, String lastName, String group) {
}
