# Execution Example
## Description
This is a demonstration of `LibraryManagementSystem` execution on the console.

### Program Execution
```
$ mvn exec:java -Dexec.mainClass="org.ntutssl.library.Main"
```

### Console
#### Console on program execution
```
Please enter the instruction as following to manage the library:
        1. 'Add book': to add book to the library
        2. 'Add collection': to add a collection to the library
        3. 'list': to list all the items name in the library
        4. 'list all': to list the detail of all the items in the library
        5. 'find': to find the item(s) in the library.
        6. 'exit': to exit the program.
```

#### Console on entering instruction: `Add book` (to `Library`)
```
Please enter the informations of books:
Name of book: Design Patterns
Description of book: This is a book discuss about 23 patterns of software designs.
Author of book: Erich Gamma, Richard Helm, Ralph Johnson, John Vlissides
ISBN of book: 0201633612
Book Design Patterns added
Please enter the instruction as following to manage the library:
        1. 'Add book': to add book to the library
        2. 'Add collection': to add a collection to the library
        3. 'list': to list all the items name in the library
        4. 'list all': to list the detail of all the items in the library
        5. 'find': to find the item(s) in the library.
        6. 'exit': to exit the program.
```

#### Console on entering instruction: `Add collection` (to `Library`)
```
Please enter the infomations of collection:
Name of collection: Agile
Description of collection: This collection contains all books about agile.
Please enter the instruction as following to manage the collection:
        1. 'Add book': to add book to the collection
        2. 'Add collection': to add a collection to the collection
        3. 'exit': to exit the process.
```

#### Console on entering instruction: `Add book` (to `Collection 1`)
```
Please enter the infomations of books:
Name of book: Learning Agile: Understanding Scrum, XP, Lean, and Kanban
Description of book: Learning Agile is a comprehensive guide to the most popular agile methods, written in a light and engaging style that makes it easy for you to learn.
Author of book: Andrew Stellman, Jennifer Greene
ISBN of book: 1449331920
Book Learning Agile: Understanding Scrum, XP, Lean, and Kanban added
Please enter the instruction as following to manage the collection:
        1. 'Add book': to add book to the collection
        2. 'Add collection': to add a collection to the collection
        3. 'exit': to exit the process.
```

#### Console on entering instruction: `Add collection` (to `Collection 1`)
```
Please enter the infomations of collection:
Name of collection: Design Patterns
Description of collection: This collection contains all books about patterns.
Please enter the instruction as following to manage the collection:
        1. 'Add book': to add book to the collection
        2. 'Add collection': to add a collection to the collection
        3. 'exit': to exit the process.
```

#### Console on entering instruction: `Add book` (to `Collection 2`)
```
Please enter the infomations of books:
Name of book: A Pattern Language: Towns, Buildings, Construction (Hardcover)
Description of book: This article is about the structured design approach by architect Christopher Alexander.
Author of book: Christopher Alexander
ISBN of book: 0195019199
Book A Pattern Language: Towns, Buildings, Construction (Hardcover) added
Please enter the instruction as following to manage the collection:
        1. 'Add book': to add book to the collection
        2. 'Add collection': to add a collection to the collection
        3. 'exit': to exit the process.
```

#### Console on entering instruction: `Add book` (to `Collection 2`)
```
Please enter the infomations of books:
Name of book: Design Patterns
Description of book: This is a book discuss about 23 patterns of software designs(2nd edition).
Author of book: Erich Gamma, Richard Helm, Ralph Johnson, John Vlissides
ISBN of book: 0201633613
Book Design Patterns added
Please enter the instruction as following to manage the collection:
        1. 'Add book': to add book to the collection
        2. 'Add collection': to add a collection to the collection
        3. 'exit': to exit the process.
```

#### Console on entering instruction: `exit` (from `Collection 2`)
```
Collection Design Patterns added
Please enter the instruction as following to manage the collection:
        1. 'Add book': to add book to the collection
        2. 'Add collection': to add a collection to the collection
        3. 'exit': to exit the process.
```

#### Console on entering instruction: `exit` (from `Collection 1`)
```
Collection Agile added
Please enter the instruction as following to manage the library:
        1. 'Add book': to add book to the library
        2. 'Add collection': to add a collection to the library
        3. 'list': to list all the items name in the library
        4. 'list all': to list the detail of all the items in the library
        5. 'find': to find the item(s) in the library.
        6. 'exit': to exit the program.
```

#### Console on entering instruction: `list` (on `Library`)
```
Design Patterns
Agile
Learning Agile: Understanding Scrum, XP, Lean, and Kanban
Design Patterns
A Pattern Language: Towns, Buildings, Construction (Hardcover)
Design Patterns
Please enter the instruction as following to manage the library:
        1. 'Add book': to add book to the library
        2. 'Add collection': to add a collection to the library
        3. 'list': to list all the items name in the library
        4. 'list all': to list the detail of all the items in the library
        5. 'find': to find the item(s) in the library.
        6. 'exit': to exit the program.
```

#### Console on entering instruction: `list all` (on `Library`)
```
Book Name: Design Patterns
        Author: Erich Gamma, Richard Helm, Ralph Johnson, John Vlissides
        Description: This is a book discuss about 23 patterns of software designs.
        ISBN: 0201633612
Collection Name: Agile
        Description: This collection contains all books about agile.
        Book Name: Learning Agile: Understanding Scrum, XP, Lean, and Kanban
                Author: Andrew Stellman, Jennifer Greene
                Description: Learning Agile is a comprehensive guide to the most popular agile methods, written in a light and engaging style that makes it easy for you to learn.
                ISBN: 1449331920
        Collection Name: Design Patterns
                Description: This collection contains all books about patterns.
                Book Name:  A Pattern Language: Towns, Buildings, Construction (Hardcover)
                        Author: Christopher Alexander
                        Description: This article is about the structured design approach by architect Christopher Alexander.
                        ISBN: 0195019199
                Book Name:  Design Patterns
                        Author: Erich Gamma, Richard Helm, Ralph Johnson, John Vlissides
                        Description: This is a book discuss about 23 patterns of software designs(2nd edition).
                        ISBN: 0201633613
Please enter the instruction as following to manage the library:
        1. 'Add book': to add book to the library
        2. 'Add collection': to add a collection to the library
        3. 'list': to list all the items name in the library
        4. 'list all': to list the detail of all the items in the library
        5. 'find': to find the item(s) in the library.
        6. 'exit': to exit the program.
```

#### Console on entering instruction: `find` (on `Library`)
```
Enter the name of the item to find: Design Patterns
Book Name: Design Patterns
        Author: Erich Gamma, Richard Helm, Ralph Johnson, John Vlissides
        Description: This is a book discuss about 23 patterns of software designs.
        ISBN: 0201633612
Collection Name: Design Patterns
        Description: This collection contains all books about patterns.
Book Name:  Design Patterns
        Author: Erich Gamma, Richard Helm, Ralph Johnson, John Vlissides
        Description: This is a book discuss about 23 patterns of software designs(2nd edition).
        ISBN: 0201633613
Please enter the instruction as following to manage the library:
        1. 'Add book': to add book to the library
        2. 'Add collection': to add a collection to the library
        3. 'list': to list all the items name in the library
        4. 'list all': to list the detail of all the items in the library
        5. 'find': to find the item(s) in the library.
        6. 'exit': to exit the program.
```

#### Console on entering instruction: `exit`