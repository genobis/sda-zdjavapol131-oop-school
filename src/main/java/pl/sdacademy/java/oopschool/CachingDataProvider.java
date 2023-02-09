package pl.sdacademy.java.oopschool;

import java.util.List;

public class CachingDataProvider<T> implements DataProvider<T> {

    private final DataProvider<T> internal;

    private List<T> cachedData;

    public CachingDataProvider(DataProvider<T> internal) {
        this.internal = internal;
    }

    @Override
    public List<T> getData() {
        if (cachedData == null) {
            cachedData = internal.getData();
        }
        return cachedData;
    }
}
