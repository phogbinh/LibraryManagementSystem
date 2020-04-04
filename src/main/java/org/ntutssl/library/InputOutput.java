package org.ntutssl.library;

import java.util.ArrayList;
import java.util.Iterator;

public class InputOutput
{
    private final String COMMAND_LIBRARY_ADD_BOOK = "1";
    private final String COMMAND_LIBRARY_ADD_COLLECTION = "2";
    private final String COMMAND_LIBRARY_LIST = "3";
    private final String COMMAND_LIBRARY_LIST_ALL = "4";
    private final String COMMAND_LIBRARY_EXIT = "5";

    private final String COMMAND_COLLECTION_ADD_BOOK = "1";
    private final String COMMAND_COLLECTION_ADD_COLLECTION = "2";
    private final String COMMAND_COLLECTION_EXIT = "3";

    private final String INSTRUCTION_ADD_BOOK = "Please enter the informations of books" + Definitions.COLON;
    private final String INSTRUCTION_ADD_COLLECTION = "Please enter the infomations of collection" + Definitions.COLON;
    private final String INSTRUCTION_INPUT_LIBRARY_COMMAND = "Please enter the instruction as following to manage the library:" + Definitions.END_LINE
        + Definitions.INDENT + "1. 'Add book': to add book to the library" + Definitions.END_LINE
        + Definitions.INDENT + "2. 'Add collection': to add a collection to the library" + Definitions.END_LINE
        + Definitions.INDENT + "3. 'list': to list all the items name in the library" + Definitions.END_LINE
        + Definitions.INDENT + "4. 'list all': to list the detail of all the items in the library" + Definitions.END_LINE
        + Definitions.INDENT + "5. 'exit': to exit the program.";
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
            case COMMAND_LIBRARY_LIST:
                listBooksInfo( library );
                printLibraryInstructions();
                handleLibraryInstructions( Main.getInputString( Definitions.EMPTY ), library );
                break;
            case COMMAND_LIBRARY_LIST_ALL:
                listBooksInfoDetail( library );
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
    
    public void listBooksInfo( Library library )
    {
        ArrayList< Item > items = getAllLibraryItems( library );
        for ( Item item : items )
        {
            System.out.println( item.name() );
        }
    }
    
    public void listBooksInfoDetail( Library library )
    {
        ArrayList< Item > items = getAllLibraryItems( library );
        for ( Item item : items )
        {
            if ( item instanceof Book )
            {
                System.out.println( ItemHelper.BOOK_NAME + item.name() );
                System.out.println( ItemHelper.BOOK_AUTHOR + item.author() );
                System.out.println( ItemHelper.BOOK_DESCRIPTION + item.description() );
                System.out.println( ItemHelper.BOOK_ISBN + item.isbn() );
            }
            else if ( item instanceof Collection )
            {
                System.out.println( ItemHelper.COLLECTION_NAME + item.name() );
                System.out.println( ItemHelper.COLLECTION_DESCRIPTION + item.description() );
            }
            else
            {
                throw new IllegalStateException( ItemHelper.ERROR_ITEM_IS_OF_INVALID_TYPE );
            }
        }
    }

    private ArrayList< Item > getAllLibraryItems( Library library )
    {
        ArrayList< Item > items = new ArrayList< Item >();
        Iterator< Item > libraryIterator = library.iterator();
        while ( libraryIterator.hasNext() )
        {
            items.addAll( getAllItems( libraryIterator.next() ) );
        }
        return items;
    }

    private ArrayList< Item > getAllItems( Item item )
    {
        ArrayList< Item > items = new ArrayList< Item >();
        items.add( item );
        Iterator< Item > itemIterator = item.iterator();
        while ( itemIterator.hasNext() )
        {
            items.addAll( getAllItems( itemIterator.next() ) );
        }
        return items;
    }

    public void findItems( Library library );
}