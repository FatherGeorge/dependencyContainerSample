package com.galvanize.curriculum.xp.di;

import javax.inject.Inject;
import java.util.Arrays;

public class SimpleDiContainer {

    private final Object[] dependencies;

    public SimpleDiContainer(Object... dependencies) {
        this.dependencies = dependencies;
    }

    // "getBean" may sound like a strange name to developers unfamiliar with Java, but it is used here to maintain parity with Spring
    // https://stackoverflow.com/questions/8526751/in-simple-laymans-terms-what-does-getbean-do-in-spring
    public <T> T getBean(final Class<T> beanType) {
        try {
            T instance = beanType.newInstance();
            injectDependencies(instance);
            return instance;
        }
        catch(Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void injectDependencies(final Object instance) throws Exception {
        // TODO: Use reflection to scan the fields of `instance` with the @Inject annotation,
        // and populate them with the proper implementation from the array of dependencies
        Arrays.stream(instance.getClass().getDeclaredFields())
                .filter(field -> null!= field.getAnnotation(Inject.class))
                .forEach(field -> {

                    final Object foundDependency = Arrays.stream(dependencies)
                            .filter(possibleDependency -> field.getType().isAssignableFrom(possibleDependency.getClass())
                            )
                            .findFirst()
                            .orElseThrow(() -> new IllegalStateException("No dependency for " + field.getType()));


                    field.setAccessible(true);

                    try {
                        field.set(instance, foundDependency);
                    } catch (final IllegalAccessException ex) {
                        throw new RuntimeException(ex);
                    }
                });
    }
}
