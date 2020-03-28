# Execution Example
## Description
This is an example on how `LibraryManagementSystem` on the console.

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
        5. 'exit': to exit the program.
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
        5. 'exit': to exit the program.
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
Name of collection: Scrum
Description of collection: This collection contains all books about scrum.
Please enter the instruction as following to manage the collection:
        1. 'Add book': to add book to the collection
        2. 'Add collection': to add a collection to the collection
        3. 'exit': to exit the process.
```

#### Console on entering instruction: `Add book` (to `Collection 2`)
```
Please enter the infomations of books:
Name of book: Essential Scrum: A Practical Guide to the Most Popular Agile Process
Description of book: A Practical Guide to the Most Popular Agile Process
Author of book: Kenneth S. Rubin
ISBN of book: 0137043295
Book Essential Scrum: A Practical Guide to the Most Popular Agile Process added
Please enter the instruction as following to manage the collection:
        1. 'Add book': to add book to the collection
        2. 'Add collection': to add a collection to the collection
        3. 'exit': to exit the process.
```

#### Console on entering instruction: `exit` (from `Collection 2`)
```
Collection Scrum added
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
        5. 'exit': to exit the program.
```

#### Console on entering instruction: `list` (on `Library`)
```
Design Patterns
Agile
Learning Agile: Understanding Scrum, XP, Lean, and Kanban
Scrum
Essential Scrum: A Practical Guide to the Most Popular Agile Process
Please enter the instruction as following to manage the library:
        1. 'Add book': to add book to the library
        2. 'Add collection': to add a collection to the library
        3. 'list': to list all the items name in the library
        4. 'list all': to list the detail of all the items in the library
        5. 'exit': to exit the program.
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
Collection Name: Scrum
        Description: This collection contains all books about scrum.
Book Name: Essential Scrum: A Practical Guide to the Most Popular Agile Process
        Author: Kenneth S. Rubin
        Description: A Practical Guide to the Most Popular Agile Process
        ISBN: 0137043295
Please enter the instruction as following to manage the library:
        1. 'Add book': to add book to the library
        2. 'Add collection': to add a collection to the library
        3. 'list': to list all the items name in the library
        4. 'list all': to list the detail of all the items in the library
        5. 'exit': to exit the program.
```

#### Console on entering instruction: `exit`