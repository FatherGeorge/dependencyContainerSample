package com.galvanize.curriculum.xp.di;

public class SimpleDiContainer {

    private Object[] dependencies;

    public SimpleDiContainer(Object... dependencies) {
        this.dependencies = dependencies;
    }

    // "getBean" may sound like a strange name to developers unfamiliar with Java, but it is used here to maintain parity with Spring
    // https://stackoverflow.com/questions/8526751/in-simple-laymans-terms-what-does-getbean-do-in-spring
    public <T> T getBean(Class<T> beanType) {
        try {
            T instance = beanType.newInstance();
            injectDependencies(instance);
            return instance;
        }
        catch(Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void injectDependencies(Object instance) throws Exception {
        // TODO: Use reflection to scan the fields of `instance` with the @Inject annotation,
        // and populate them with the proper implementation from the array of dependencies
    }
}
