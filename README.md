# Java Problem Set: Dependency Injection with Reflection

## Rationale

Dependency Injection (DI) frameworks are important tools for making applications _testable_. In order to more deeply understand how these frameworks function, students should implement their own.

## Objectives

- Create a simple IoC container
- Use reflection to inject dependencies

## Background

Guice and Spring are two popular DI frameworks, and both of these frameworks function in a similar manner:

1. Application developers configure a mapping of `interfaces` and their desired `implementations`
1. When the application starts, the framework scans for fields with `@Autowired` or `@Inject` annotations
1. Whenever a field requires injection, the framework will set it's value automatically

The concept of parent classes injecting dependencies into their children is reffered to as _Inversion of Control_ (IoC), and since frameworks like Spring & Guice store implementations they are reffered to as _IoC Containers_.

Step #1 above can be said to "store an implementation in the IoC container", and step #3 can be said to retrieve an implementation from the container.

## Assignment

You have been provided with tests to verify proper functionality of a simple IoC Container. 

To complete the assignment, you should:

1. Fork and clone this repository
1. Run the tests, and observe failure
1. Provide an implementation of `SimpleDiContainer.injectDependencies()` that satisfies the tests
1. Re-run the tests, and observe success!
1. Commit and push your work
