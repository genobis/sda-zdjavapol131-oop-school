package pl.sdacademy.java.oopschool;

import java.util.List;

public interface DataProvider<T> {
    List<T> getData();
}
