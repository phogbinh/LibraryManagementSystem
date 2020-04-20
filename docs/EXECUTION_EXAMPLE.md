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
        3. 'import': import the json file to library.
        4. 'export': export the library to json file.
        5. 'list all': to list the detail of all the items in the library
        6. 'find': to find the item(s) in the library.
        7. 'exit': to exit the program.
```

#### Console on entering instruction: `import` (to `Library`)
```
Please enter the json file path you want to import: ./test_data/sample_data.json
Please enter the instruction as following to manage the library:
        1. 'Add book': to add book to the library
        2. 'Add collection': to add a collection to the library
        3. 'import': import the json file to library.
        4. 'export': export the library to json file.
        5. 'list all': to list the detail of all the items in the library
        6. 'find': to find the item(s) in the library.
        7. 'exit': to exit the program.
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
                Book Name: A Pattern Language: Towns, Buildings, Construction (Hardcover)
                        Author: Christopher Alexander
                        Description: This article is about the structured design approach by architect Christopher Alexander.
                        ISBN: 0195019199
                Book Name: Design Patterns
                        Author: Erich Gamma, Richard Helm, Ralph Johnson, John Vlissides
                        Description: This is a book discuss about 23 patterns of software designs(2nd edition).
                        ISBN: 0201633613
Please enter the instruction as following to manage the library:
        1. 'Add book': to add book to the library
        2. 'Add collection': to add a collection to the library
        3. 'import': import the json file to library.
        4. 'export': export the library to json file.
        5. 'list all': to list the detail of all the items in the library
        6. 'find': to find the item(s) in the library.
        7. 'exit': to exit the program.
```

#### Console on entering instruction: `Add book` (to `Library`)
```
Please enter the infomations of books:
Name of book: new book
Description of book: new
Author of book: new
ISBN of book: 9999
Book new book added
Please enter the instruction as following to manage the library:
        1. 'Add book': to add book to the library
        2. 'Add collection': to add a collection to the library  
        3. 'import': import the json file to library.
        4. 'export': export the library to json file.
        5. 'list all': to list the detail of all the items in the library
        6. 'find': to find the item(s) in the library.
        7. 'exit': to exit the program.
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
                Book Name: A Pattern Language: Towns, Buildings, Construction (Hardcover)
                        Author: Christopher Alexander
                        Description: This article is about the structured design approach by architect Christopher Alexander.
                        ISBN: 0195019199
                Book Name: Design Patterns
                        Author: Erich Gamma, Richard Helm, Ralph Johnson, John Vlissides
                        Description: This is a book discuss about 23 patterns of software designs(2nd edition).
                        ISBN: 0201633613
Book Name: new book
        Author: new
        Description: new
        ISBN: 9999
Please enter the instruction as following to manage the library:
        1. 'Add book': to add book to the library
        2. 'Add collection': to add a collection to the library
        3. 'import': import the json file to library.
        4. 'export': export the library to json file.
        5. 'list all': to list the detail of all the items in the library
        6. 'find': to find the item(s) in the library.
        7. 'exit': to exit the program.
```

#### Console on entering instruction: `export` (from `Library`)
```
Please enter the json file path you want to export: ./test_data/sample_output.json
Please enter the instruction as following to manage the library:
        1. 'Add book': to add book to the library
        2. 'Add collection': to add a collection to the library
        3. 'import': import the json file to library.
        4. 'export': export the library to json file.
        5. 'list all': to list the detail of all the items in the library
        6. 'find': to find the item(s) in the library.
        7. 'exit': to exit the program.
```
##### Content of the file `./test_data/sample_output.json`
```
{
  "itemlist": [
    {
      "type": "book",
      "name": "Design Patterns",
      "description": "This is a book discuss about 23 patterns of software designs.",
      "author": "Erich Gamma, Richard Helm, Ralph Johnson, John Vlissides",
      "isbn": "0201633612"
    },
    {
      "type": "collection",
      "name": "Agile",
      "description": "This collection contains all books about agile.",
      "items": [
        {
          "type": "book",
          "name": "Learning Agile: Understanding Scrum, XP, Lean, and Kanban",
          "description": "Learning Agile is a comprehensive guide to the most popular agile methods, written in a light and engaging style that makes it easy for you to learn.",
          "author": "Andrew Stellman, Jennifer Greene",
          "isbn": "1449331920"
        },
        {
          "type": "collection",
          "name": "Design Patterns",
          "description": "This collection contains all books about patterns.",
          "items": [
            {
              "type": "book",
              "name": "A Pattern Language: Towns, Buildings, Construction (Hardcover)",
              "description": "This article is about the structured design approach by architect Christopher Alexander.",
              "author": "Christopher Alexander",
              "isbn": "0195019199"
            },
            {
              "type": "book",
              "name": "Design Patterns",
              "description": "This is a book discuss about 23 patterns of software designs(2nd edition).",
              "author": "Erich Gamma, Richard Helm, Ralph Johnson, John Vlissides",
              "isbn": "0201633613"
            }
          ]
        }
      ]
    },
    {
      "type": "book",
      "name": "new book",
      "description": "new",
      "author": "new",
      "isbn": "9999"
    }
  ]
}
```

#### Console on entering instruction: `exit`