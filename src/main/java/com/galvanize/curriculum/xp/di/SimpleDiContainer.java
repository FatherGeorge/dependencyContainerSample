package com.galvanize.curriculum.xp.di;

public class SimpleDiContainer {

    private Object[] dependencies;

    public SimpleDiContainer(Object... dependencies) {
        this.dependencies = dependencies;
    }

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
        // TODO: implement
    }
}
