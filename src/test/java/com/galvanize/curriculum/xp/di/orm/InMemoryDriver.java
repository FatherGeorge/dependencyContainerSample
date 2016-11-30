package com.galvanize.curriculum.xp.di.orm;

import java.util.ArrayList;
import java.util.List;

public class InMemoryDriver implements Driver {

    public List<Object> saved = new ArrayList<>();

    public void save(Object obj) {
        saved.add(obj);
    }
}
