# Library Management System
## Description
This is the repository for the homeworks 2 and 3 of the course *Design Pattern* opened during the 2020 Spring Semester at the National Taipei University of Technology.

## Homework description
You will have to program a library management system, whose SRS is specified below. Specifically, you must write the implementations and tests for the classes and their methods given in [this template project](
https://drive.google.com/file/d/1PH1wbgZ-TB2FJaLjuJo4Lfj6AGJHHVS7/view?usp=sharing).

## Software Requirements Specification (SRS)
* The library management system can add an `Item` to the `Library`.
* An `Item` can be either a `Book` or a `Collection`.
* A `Book` should contain its name, description, author, and ISBN.
* A `Collection` should contain its name and description.
* A `Collection` can contain zero or many `Book`(s) and other `Collection`(s).

## Execution
Please refer to [this execution example](docs/EXECUTION_EXAMPLE.md) to run the program.

## Design Patterns
The project uses the following design patterns:
* Composite Pattern
* Iterator Pattern

## Contributor
* [phogbinh](https://github.com/phogbinh)