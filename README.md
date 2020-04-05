# Library Management System
## Description
This is the repository for the homeworks 2, 3 and 4 of the course *Design Pattern* opened during the 2020 Spring Semester at the National Taipei University of Technology.

## Homework description
You will have to program a library management system, whose SRS is specified below. Specifically, you must write the implementations and tests for the classes and their methods given in [this template project](
https://drive.google.com/open?id=1hsVOMI2u-BZDa1igMoeiUIRVkoChuGja).

## Software Requirements Specification (SRS)
* The library management system can add an `Item` to the `Library`.
* An `Item` can be either a `Book` or a `Collection`.
* A `Book` should contain its name, description, author, and ISBN.
* A `Collection` should contain its name and description.
* A `Collection` can contain zero or many `Book`(s) and other `Collection`(s).
* An `Item` can ask a `FindVisitorByName` to help it find from itself and its children (if any) `Item`(s) having a specific name.
* An `Item` can ask a `ListDetailVisitor` to help it retrieve the information of itself and its children (if any). If the `Item` is a `Book`, then its name, description, author, and ISBN shall be retrieved. If the `Item` is a `Collection`, then its name, description, and the information of its children (if any) shall all be retrieved.

## Execution
Please refer to [this execution example](docs/EXECUTION_EXAMPLE.md) on how to run the program.

## Design Patterns
The project implements the following design patterns:
* Composite Pattern
* Iterator Pattern
* Visitor Pattern

## Contributor
* [phogbinh](https://github.com/phogbinh)