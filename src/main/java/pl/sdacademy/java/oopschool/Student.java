package pl.sdacademy.java.oopschool;

import java.util.UUID;

public record Student(UUID uuid, String firstName, String lastName, String group) {
}
