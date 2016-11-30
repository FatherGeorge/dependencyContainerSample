package com.galvanize.curriculum.xp.di.orm;

import javax.inject.Inject;

public class Orm {

    @Inject
    private Driver driver;

    public void save(Object obj) {
        driver.save(obj);
    }
}
