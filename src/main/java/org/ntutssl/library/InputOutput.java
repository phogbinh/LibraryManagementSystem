package org.ntutssl.library;

import java.util.ArrayList;
import java.util.Iterator;

public class InputOutput
{
    private final String COMMAND_LIBRARY_ADD_BOOK = "1";
    private final String COMMAND_LIBRARY_ADD_COLLECTION = "2";
    private final String COMMAND_LIBRARY_LIST_ALL = "5";
    private final String COMMAND_LIBRARY_FIND = "6";
    private final String COMMAND_LIBRARY_EXIT = "7";

    private final String COMMAND_COLLECTION_ADD_BOOK = "1";
    private final String COMMAND_COLLECTION_ADD_COLLECTION = "2";
    private final String COMMAND_COLLECTION_EXIT = "3";

    private final String INSTRUCTION_ADD_BOOK = "Please enter the informations of books" + Definitions.COLON;
    private final String INSTRUCTION_ADD_COLLECTION = "Please enter the infomations of collection" + Definitions.COLON;
    private final String INSTRUCTION_INPUT_LIBRARY_COMMAND = "Please enter the instruction as following to manage the library:" + Definitions.END_LINE
        + Definitions.INDENT + "1. 'Add book': to add book to the library" + Definitions.END_LINE
        + Definitions.INDENT + "2. 'Add collection': to add a collection to the library" + Definitions.END_LINE
        + Definitions.INDENT + "3. 'import': import the json file to library." + Definitions.END_LINE
        + Definitions.INDENT + "5. 'list all': to list the detail of all the items in the library" + Definitions.END_LINE
        + Definitions.INDENT + "6. 'find': to find the item(s) in the library." + Definitions.END_LINE
        + Definitions.INDENT + "7. 'exit': to exit the program.";
    private final String INSTRUCTION_INPUT_COLLECTION_COMMAND = "Please enter the instruction as following to manage the collection:" + Definitions.END_LINE
        + Definitions.INDENT + "1. 'Add book': to add book to the collection" + Definitions.END_LINE
        + Definitions.INDENT + "2. 'Add collection': to add a collection to the collection" + Definitions.END_LINE
        + Definitions.INDENT + "3. 'exit': to exit the process.";
    private final String INSTRUCTION_INPUT_BOOK_NAME = "Name of book" + Definitions.COLON + Definitions.SPACE;
    private final String INSTRUCTION_INPUT_BOOK_DESCRIPTION = "Description of book" + Definitions.COLON + Definitions.SPACE;
    private final String INSTRUCTION_INPUT_BOOK_AUTHOR = "Author of book" + Definitions.COLON + Definitions.SPACE;
    private final String INSTRUCTION_INPUT_BOOK_ISBN = "ISBN of book" + Definitions.COLON + Definitions.SPACE;
    private final String INSTRUCTION_INPUT_COLLECTION_NAME = "Name of collection" + Definitions.COLON + Definitions.SPACE;
    private final String INSTRUCTION_INPUT_COLLECTION_DESCRIPTION = "Description of collection" + Definitions.COLON + Definitions.SPACE;
    private final String INSTRUCTION_INPUT_TO_BE_FOUND_ITEM_NAME = "Enter the name of the item to find" + Definitions.COLON + Definitions.SPACE;
    private final String INSTRUCTION_INPUT_TO_BE_IMPORTED_JSON_FILE_PATH = "Please enter the json file path you want to import" + Definitions.COLON + Definitions.SPACE;

    private final String BOOK = "Book";
    private final String COLLECTION = "Collection";
    private final String ADDED = "added";

    private final String ERROR_COMMAND_IS_INVALID = "The given command is invalid";

    public InputOutput()
    {
        /* Body intentionally empty */
    }

    public void handleLibraryInstructions( String command, Library library )
    {
        switch ( command )
        {
            case COMMAND_LIBRARY_ADD_BOOK:
                System.out.println( INSTRUCTION_ADD_BOOK );
                addItemToLibraryThenRepeatLibraryInstructions( addBookInstructions(), library );
                break;
            case COMMAND_LIBRARY_ADD_COLLECTION:
                System.out.println( INSTRUCTION_ADD_COLLECTION );
                Item inputCollection = addCollectionInstructions();
                printCollectionInstructions();
                handleCollectionInstructions( Main.getInputString( Definitions.EMPTY ), ( Collection )inputCollection );
                addItemToLibraryThenRepeatLibraryInstructions( inputCollection, library );
                break;
            case COMMAND_LIBRARY_LIST_ALL:
                listBooksInfoDetail( library );
                printLibraryInstructions();
                handleLibraryInstructions( Main.getInputString( Definitions.EMPTY ), library );
                break;
            case COMMAND_LIBRARY_FIND:
                findItems( library );
                printLibraryInstructions();
                handleLibraryInstructions( Main.getInputString( Definitions.EMPTY ), library );
                break;
            case COMMAND_LIBRARY_EXIT:
                break;
            default:
                throw new IllegalArgumentException( ERROR_COMMAND_IS_INVALID );
        }
    }

    private void addItemToLibraryThenRepeatLibraryInstructions( Item inputItem, Library library )
    {
        library.add( inputItem );
        printAdded( inputItem );
        printLibraryInstructions();
        handleLibraryInstructions( Main.getInputString( Definitions.EMPTY ), library );
    }

    public void printLibraryInstructions()
    {
        System.out.println( INSTRUCTION_INPUT_LIBRARY_COMMAND );
    }

    public void handleCollectionInstructions( String command, Collection collection )
    {
        switch ( command )
        {
            case COMMAND_COLLECTION_ADD_BOOK:
                System.out.println( INSTRUCTION_ADD_BOOK );
                addItemToCollectionThenRepeatCollectionInstructions( addBookInstructions(), collection );
                break;
            case COMMAND_COLLECTION_ADD_COLLECTION:
                System.out.println( INSTRUCTION_ADD_COLLECTION );
                Item inputCollection = addCollectionInstructions();
                printCollectionInstructions();
                handleCollectionInstructions( Main.getInputString( Definitions.EMPTY ), ( Collection )inputCollection );
                addItemToCollectionThenRepeatCollectionInstructions( inputCollection, collection );
                break;
            case COMMAND_COLLECTION_EXIT:
                break;
            default:
                throw new IllegalArgumentException( ERROR_COMMAND_IS_INVALID );
        }
    }

    private void addItemToCollectionThenRepeatCollectionInstructions( Item inputItem, Collection collection )
    {
        collection.add( inputItem );
        printAdded( inputItem );
        printCollectionInstructions();
        handleCollectionInstructions( Main.getInputString( Definitions.EMPTY ), collection );
    }

    private void printAdded( Item item )
    {
        if ( item instanceof Book )
        {
            System.out.print( BOOK );
        }
        else if ( item instanceof Collection )
        {
            System.out.print( COLLECTION );
        }
        else
        {
            throw new IllegalStateException( ItemHelper.ERROR_ITEM_IS_OF_INVALID_TYPE );
        }
        System.out.println( Definitions.SPACE + item.name() + Definitions.SPACE + ADDED );
    }

    public void printCollectionInstructions()
    {
        System.out.println( INSTRUCTION_INPUT_COLLECTION_COMMAND );
    }

    public Item addBookInstructions()
    {
        String inputBookName        = Main.getInputString( INSTRUCTION_INPUT_BOOK_NAME );
        String inputBookDescription = Main.getInputString( INSTRUCTION_INPUT_BOOK_DESCRIPTION );
        String inputBookAuthor      = Main.getInputString( INSTRUCTION_INPUT_BOOK_AUTHOR );
        String inputBookIsbn        = Main.getInputString( INSTRUCTION_INPUT_BOOK_ISBN );
        return new Book( inputBookName, inputBookDescription, inputBookAuthor, inputBookIsbn );
    }

    public Item addCollectionInstructions()
    {
        String inputCollectionName        = Main.getInputString( INSTRUCTION_INPUT_COLLECTION_NAME );
        String inputCollectionDescription = Main.getInputString( INSTRUCTION_INPUT_COLLECTION_DESCRIPTION );
        return new Collection( inputCollectionName, inputCollectionDescription );
    }
    
    public void listBooksInfoDetail( Library library )
    {
        ListDetailVisitor listDetailVisitor = new ListDetailVisitor();
        Iterator< Item > iterator = library.iterator();
        while ( iterator.hasNext() )
        {
            iterator.next().accept( listDetailVisitor );
        }
        System.out.print( listDetailVisitor.getResult() );
    }

    public void findItems( Library library )
    {
        String itemName = Main.getInputString( INSTRUCTION_INPUT_TO_BE_FOUND_ITEM_NAME );
        System.out.print( library.findByName( itemName ) );
    }

    public void importInstructions( Library library )
    {
        String jsonFilePath = Main.getInputString( INSTRUCTION_INPUT_TO_BE_IMPORTED_JSON_FILE_PATH );
        library.importItems( jsonFilePath );
    }

    public void exportInstructions( Library library );
}