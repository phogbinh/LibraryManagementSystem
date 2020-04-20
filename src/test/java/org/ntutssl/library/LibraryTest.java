package org.ntutssl.library;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.Vector;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LibraryTest 
{
    private final String ITEM_NAME_AAA = "aaa";
    // c1
    private final String COLLECTION_1_NAME = ITEM_NAME_AAA;
    private final String COLLECTION_1_DESCRIPTION = "This is a programming collection.";
    // b1
    private final String BOOK_1_NAME = ITEM_NAME_AAA;
    private final String BOOK_1_DESCRIPTION = "The book covers a broad range of algorithms in depth, yet makes their design and analysis accessible to all levels of readers.";
    private final String BOOK_1_AUTHOR = "Thomas H. Cormen";
    private final String BOOK_1_ISBN = "9780262033848";
    // c2
    private final String COLLECTION_2_NAME = "Data Structures and Algorithms Collection";
    private final String COLLECTION_2_DESCRIPTION = "This is a data structures and algorithms collection";

    private final String FILE_PATH = "./test_data/sample_data.json";
    private final String MEMBER_VARIABLE_NAME_ITEMS = "_items";
    private Item _c1;
    private Item _b1;
    private Item _c2;
    private Library _library;

    private String getFileContent( String filePath )
    {
        try
        {
            return new String( Files.readAllBytes( Paths.get( filePath ) ) );
        } 
        catch ( IOException exception )
        {
            throw new RuntimeException( exception );
        }
    }

    @Before
    public void setUp()
    {
        _c1 = new Collection( COLLECTION_1_NAME, COLLECTION_1_DESCRIPTION );
        _b1 = new Book( BOOK_1_NAME, BOOK_1_DESCRIPTION, BOOK_1_AUTHOR, BOOK_1_ISBN );
        _c2 = new Collection( COLLECTION_2_NAME, COLLECTION_2_DESCRIPTION );
        _library = new Library();
        _library.add( _c1 );
        _library.add( _b1 );
        _library.add( _c2 );
    }

    @After
    public void tearDown()
    {
        /* Body intentionally empty */
    }

    @Test
    public void test_adding_c1_and_b1_and_c2_to_library()
    {
        Item c1 = new Collection( COLLECTION_1_NAME, COLLECTION_1_DESCRIPTION );
        Item b1 = new Book( BOOK_1_NAME, BOOK_1_DESCRIPTION, BOOK_1_AUTHOR, BOOK_1_ISBN );
        Item c2 = new Collection( COLLECTION_2_NAME, COLLECTION_2_DESCRIPTION );
        Library library = new Library();
        library.add( c1 );
        library.add( b1 );
        library.add( c2 );
        try
        {
            Field itemsField = Library.class.getDeclaredField( MEMBER_VARIABLE_NAME_ITEMS );
            itemsField.setAccessible( true );
            try
            {
                Vector< Item > expectedItems = ( Vector< Item > )itemsField.get( library );
                assertEquals( 3, expectedItems.size() );
                assertSame( c1, expectedItems.get( 0 ) );
                assertSame( b1, expectedItems.get( 1 ) );
                assertSame( c2, expectedItems.get( 2 ) );
            }
            catch( IllegalAccessException exception )
            {
                assertTrue( false );
            }
        }
        catch( NoSuchFieldException exception )
        {
            assertTrue( false );
        }
    }

    @Test
    public void test_size_of_library_being_1()
    {
        assertEquals( 1, _library.size() );
    }

    @Test
    public void test_iterator_of_library_being_that_of_its_internal_items()
    {
        try
        {
            Field itemsField = Library.class.getDeclaredField( MEMBER_VARIABLE_NAME_ITEMS );
            itemsField.setAccessible( true );
            try
            {
                Vector< Item > expectedItems = ( Vector< Item > )itemsField.get( _library );
                Iterator< Item > libraryIterator = _library.iterator();
                Iterator< Item > libraryItemsIterator = expectedItems.iterator();
                assertSame( libraryIterator.next(), libraryItemsIterator.next() );
                assertSame( libraryIterator.next(), libraryItemsIterator.next() );
                assertSame( libraryIterator.next(), libraryItemsIterator.next() );
                assertFalse( libraryIterator.hasNext() );
                assertFalse( libraryItemsIterator.hasNext() );
            }
            catch( IllegalAccessException exception )
            {
                assertTrue( false );
            }
        }
        catch( NoSuchFieldException exception )
        {
            assertTrue( false );
        }
    }

    @Test
    public void test_finding_aaa_returning_info_of_c1_and_b1()
    {
        final String EXPECTED_STRING = ItemHelper.COLLECTION_NAME + COLLECTION_1_NAME + Definitions.END_LINE
            + Definitions.INDENT + ItemHelper.COLLECTION_DESCRIPTION + COLLECTION_1_DESCRIPTION + Definitions.END_LINE
            + ItemHelper.BOOK_NAME + BOOK_1_NAME + Definitions.END_LINE
            + Definitions.INDENT + ItemHelper.BOOK_AUTHOR + BOOK_1_AUTHOR + Definitions.END_LINE
            + Definitions.INDENT + ItemHelper.BOOK_DESCRIPTION + BOOK_1_DESCRIPTION + Definitions.END_LINE
            + Definitions.INDENT + ItemHelper.BOOK_ISBN + BOOK_1_ISBN + Definitions.END_LINE;
        assertEquals( EXPECTED_STRING, _library.findByName( ITEM_NAME_AAA ) );
    }

    // TA b1
    private final String TEACHING_ASSISTANT_BOOK_1_NAME = "Design Patterns";
    private final String TEACHING_ASSISTANT_BOOK_1_DESCRIPTION = "This is a book discuss about 23 patterns of software designs.";
    private final String TEACHING_ASSISTANT_BOOK_1_AUTHOR = "Erich Gamma, Richard Helm, Ralph Johnson, John Vlissides";
    private final String TEACHING_ASSISTANT_BOOK_1_ISBN = "0201633612";
    // TA c1
    private final String TEACHING_ASSISTANT_COLLECTION_1_NAME = "Agile";
    private final String TEACHING_ASSISTANT_COLLECTION_1_DESCRIPTION = "This collection contains all books about agile.";
    // - TA b2
    private final String TEACHING_ASSISTANT_BOOK_2_NAME = "Learning Agile: Understanding Scrum, XP, Lean, and Kanban";
    private final String TEACHING_ASSISTANT_BOOK_2_DESCRIPTION = "Learning Agile is a comprehensive guide to the most popular agile methods, written in a light and engaging style that makes it easy for you to learn.";
    private final String TEACHING_ASSISTANT_BOOK_2_AUTHOR = "Andrew Stellman, Jennifer Greene";
    private final String TEACHING_ASSISTANT_BOOK_2_ISBN = "1449331920";
    // - TA c2
    private final String TEACHING_ASSISTANT_COLLECTION_2_NAME = "Design Patterns";
    private final String TEACHING_ASSISTANT_COLLECTION_2_DESCRIPTION = "This collection contains all books about patterns.";
    // -- TA b3
    private final String TEACHING_ASSISTANT_BOOK_3_NAME = "A Pattern Language: Towns, Buildings, Construction (Hardcover)";
    private final String TEACHING_ASSISTANT_BOOK_3_DESCRIPTION = "This article is about the structured design approach by architect Christopher Alexander.";
    private final String TEACHING_ASSISTANT_BOOK_3_AUTHOR = "Christopher Alexander";
    private final String TEACHING_ASSISTANT_BOOK_3_ISBN = "0195019199";
    // -- TA b4
    private final String TEACHING_ASSISTANT_BOOK_4_NAME = "Design Patterns";
    private final String TEACHING_ASSISTANT_BOOK_4_DESCRIPTION = "This is a book discuss about 23 patterns of software designs(2nd edition).";
    private final String TEACHING_ASSISTANT_BOOK_4_AUTHOR = "Erich Gamma, Richard Helm, Ralph Johnson, John Vlissides";
    private final String TEACHING_ASSISTANT_BOOK_4_ISBN = "0201633613";

    @Test
    public void test_import_items()
    {
        Library library = new Library();
        library.importItems( FILE_PATH );
        Iterator< Item > libraryIterator = library.iterator();
        {
            Book book = ( Book )libraryIterator.next();
            assertEquals( "Design Patterns", book.name() );
            assertEquals( "This is a book discuss about 23 patterns of software designs.", book.description() );
            assertEquals( "Erich Gamma, Richard Helm, Ralph Johnson, John Vlissides", book.author() );
            assertEquals( "0201633612", book.isbn() );
        }
        {
            Collection collection = ( Collection )libraryIterator.next();
            assertEquals( "Agile", collection.name() );
            assertEquals( "This collection contains all books about agile.", collection.description() );
            Iterator< Item > collectionIterator = collection.iterator();
            {
                Book book = ( Book )collectionIterator.next();
                assertEquals( "Learning Agile: Understanding Scrum, XP, Lean, and Kanban", book.name() );
                assertEquals( "Learning Agile is a comprehensive guide to the most popular agile methods, written in a light and engaging style that makes it easy for you to learn.", book.description() );
                assertEquals( "Andrew Stellman, Jennifer Greene", book.author() );
                assertEquals( "1449331920", book.isbn() );
            }
            {
                Collection nestedCollection = ( Collection )collectionIterator.next();
                assertEquals( "Design Patterns", nestedCollection.name() );
                assertEquals( "This collection contains all books about patterns.", nestedCollection.description() );
                Iterator< Item > nestedCollectionIterator = nestedCollection.iterator();
                {
                    Book book = ( Book )nestedCollectionIterator.next();
                    assertEquals( "A Pattern Language: Towns, Buildings, Construction (Hardcover)", book.name() );
                    assertEquals( "This article is about the structured design approach by architect Christopher Alexander.", book.description() );
                    assertEquals( "Christopher Alexander", book.author() );
                    assertEquals( "0195019199", book.isbn() );
                }
                {
                    Book book = ( Book )nestedCollectionIterator.next();
                    assertEquals( "Design Patterns", book.name() );
                    assertEquals( "This is a book discuss about 23 patterns of software designs(2nd edition).", book.description() );
                    assertEquals( "Erich Gamma, Richard Helm, Ralph Johnson, John Vlissides", book.author() );
                    assertEquals( "0201633613", book.isbn() );
                }
                assertFalse( nestedCollectionIterator.hasNext() );
            }
            assertFalse( collectionIterator.hasNext() );
        }
        assertFalse( libraryIterator.hasNext() );
    }

    @Test
    public void test_export_items()
    {
        final String EXPECTED_DESTINATION_FILE_CONTENT = Definitions.OPENING_CURLY_BRACE + Definitions.END_LINE
            + Definitions.JSON_INDENT + Definitions.QUOTATION_MARK + Definitions.JSON_OBJECT_PROPERTY_NAME_ITEMS_LIST + Definitions.QUOTATION_MARK + Definitions.COLON + Definitions.SPACE + Definitions.OPENING_SQUARE_BRACKET + Definitions.END_LINE
            // TA b1 JSON object
            + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.OPENING_CURLY_BRACE + Definitions.END_LINE
            + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.QUOTATION_MARK + Definitions.JSON_OBJECT_PROPERTY_NAME_TYPE        + Definitions.QUOTATION_MARK + Definitions.COLON + Definitions.SPACE + Definitions.QUOTATION_MARK + Definitions.JSON_OBJECT_TYPE_PROPERTY_VALUE_BOOK + Definitions.QUOTATION_MARK + Definitions.COMMA + Definitions.END_LINE
            + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.QUOTATION_MARK + Definitions.JSON_OBJECT_PROPERTY_NAME_NAME        + Definitions.QUOTATION_MARK + Definitions.COLON + Definitions.SPACE + Definitions.QUOTATION_MARK + TEACHING_ASSISTANT_BOOK_1_NAME                   + Definitions.QUOTATION_MARK + Definitions.COMMA + Definitions.END_LINE
            + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.QUOTATION_MARK + Definitions.JSON_OBJECT_PROPERTY_NAME_DESCRIPTION + Definitions.QUOTATION_MARK + Definitions.COLON + Definitions.SPACE + Definitions.QUOTATION_MARK + TEACHING_ASSISTANT_BOOK_1_DESCRIPTION            + Definitions.QUOTATION_MARK + Definitions.COMMA + Definitions.END_LINE
            + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.QUOTATION_MARK + Definitions.JSON_OBJECT_PROPERTY_NAME_AUTHOR      + Definitions.QUOTATION_MARK + Definitions.COLON + Definitions.SPACE + Definitions.QUOTATION_MARK + TEACHING_ASSISTANT_BOOK_1_AUTHOR                 + Definitions.QUOTATION_MARK + Definitions.COMMA + Definitions.END_LINE
            + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.QUOTATION_MARK + Definitions.JSON_OBJECT_PROPERTY_NAME_ISBN        + Definitions.QUOTATION_MARK + Definitions.COLON + Definitions.SPACE + Definitions.QUOTATION_MARK + TEACHING_ASSISTANT_BOOK_1_ISBN                   + Definitions.QUOTATION_MARK + Definitions.END_LINE
            + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.CLOSING_CURLY_BRACE + Definitions.COMMA + Definitions.END_LINE
            // TA c1 JSON object
            + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.OPENING_CURLY_BRACE + Definitions.END_LINE
            + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.QUOTATION_MARK + Definitions.JSON_OBJECT_PROPERTY_NAME_TYPE        + Definitions.QUOTATION_MARK + Definitions.COLON + Definitions.SPACE + Definitions.QUOTATION_MARK + Definitions.JSON_OBJECT_TYPE_PROPERTY_VALUE_COLLECTION + Definitions.QUOTATION_MARK + Definitions.COMMA + Definitions.END_LINE
            + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.QUOTATION_MARK + Definitions.JSON_OBJECT_PROPERTY_NAME_NAME        + Definitions.QUOTATION_MARK + Definitions.COLON + Definitions.SPACE + Definitions.QUOTATION_MARK + TEACHING_ASSISTANT_COLLECTION_1_NAME                   + Definitions.QUOTATION_MARK + Definitions.COMMA + Definitions.END_LINE
            + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.QUOTATION_MARK + Definitions.JSON_OBJECT_PROPERTY_NAME_DESCRIPTION + Definitions.QUOTATION_MARK + Definitions.COLON + Definitions.SPACE + Definitions.QUOTATION_MARK + TEACHING_ASSISTANT_COLLECTION_1_DESCRIPTION            + Definitions.QUOTATION_MARK + Definitions.COMMA + Definitions.END_LINE
            + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.QUOTATION_MARK + Definitions.JSON_OBJECT_PROPERTY_NAME_ITEMS       + Definitions.QUOTATION_MARK + Definitions.COLON + Definitions.SPACE + Definitions.OPENING_SQUARE_BRACKET + Definitions.END_LINE
            // - TA b2 JSON object
            + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.OPENING_CURLY_BRACE + Definitions.END_LINE
            + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.QUOTATION_MARK + Definitions.JSON_OBJECT_PROPERTY_NAME_TYPE        + Definitions.QUOTATION_MARK + Definitions.COLON + Definitions.SPACE + Definitions.QUOTATION_MARK + Definitions.JSON_OBJECT_TYPE_PROPERTY_VALUE_BOOK + Definitions.QUOTATION_MARK + Definitions.COMMA + Definitions.END_LINE
            + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.QUOTATION_MARK + Definitions.JSON_OBJECT_PROPERTY_NAME_NAME        + Definitions.QUOTATION_MARK + Definitions.COLON + Definitions.SPACE + Definitions.QUOTATION_MARK + TEACHING_ASSISTANT_BOOK_2_NAME                   + Definitions.QUOTATION_MARK + Definitions.COMMA + Definitions.END_LINE
            + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.QUOTATION_MARK + Definitions.JSON_OBJECT_PROPERTY_NAME_DESCRIPTION + Definitions.QUOTATION_MARK + Definitions.COLON + Definitions.SPACE + Definitions.QUOTATION_MARK + TEACHING_ASSISTANT_BOOK_2_DESCRIPTION            + Definitions.QUOTATION_MARK + Definitions.COMMA + Definitions.END_LINE
            + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.QUOTATION_MARK + Definitions.JSON_OBJECT_PROPERTY_NAME_AUTHOR      + Definitions.QUOTATION_MARK + Definitions.COLON + Definitions.SPACE + Definitions.QUOTATION_MARK + TEACHING_ASSISTANT_BOOK_2_AUTHOR                 + Definitions.QUOTATION_MARK + Definitions.COMMA + Definitions.END_LINE
            + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.QUOTATION_MARK + Definitions.JSON_OBJECT_PROPERTY_NAME_ISBN        + Definitions.QUOTATION_MARK + Definitions.COLON + Definitions.SPACE + Definitions.QUOTATION_MARK + TEACHING_ASSISTANT_BOOK_2_ISBN                   + Definitions.QUOTATION_MARK + Definitions.END_LINE
            + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.CLOSING_CURLY_BRACE + Definitions.COMMA + Definitions.END_LINE
            // - TA c2 JSON object
            + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.OPENING_CURLY_BRACE + Definitions.END_LINE
            + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.QUOTATION_MARK + Definitions.JSON_OBJECT_PROPERTY_NAME_TYPE        + Definitions.QUOTATION_MARK + Definitions.COLON + Definitions.SPACE + Definitions.QUOTATION_MARK + Definitions.JSON_OBJECT_TYPE_PROPERTY_VALUE_COLLECTION + Definitions.QUOTATION_MARK + Definitions.COMMA + Definitions.END_LINE
            + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.QUOTATION_MARK + Definitions.JSON_OBJECT_PROPERTY_NAME_NAME        + Definitions.QUOTATION_MARK + Definitions.COLON + Definitions.SPACE + Definitions.QUOTATION_MARK + TEACHING_ASSISTANT_COLLECTION_2_NAME                   + Definitions.QUOTATION_MARK + Definitions.COMMA + Definitions.END_LINE
            + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.QUOTATION_MARK + Definitions.JSON_OBJECT_PROPERTY_NAME_DESCRIPTION + Definitions.QUOTATION_MARK + Definitions.COLON + Definitions.SPACE + Definitions.QUOTATION_MARK + TEACHING_ASSISTANT_COLLECTION_2_DESCRIPTION            + Definitions.QUOTATION_MARK + Definitions.COMMA + Definitions.END_LINE
            + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.QUOTATION_MARK + Definitions.JSON_OBJECT_PROPERTY_NAME_ITEMS       + Definitions.QUOTATION_MARK + Definitions.COLON + Definitions.SPACE + Definitions.OPENING_SQUARE_BRACKET + Definitions.END_LINE
            // -- TA b3 JSON object
            + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.OPENING_CURLY_BRACE + Definitions.END_LINE
            + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.QUOTATION_MARK + Definitions.JSON_OBJECT_PROPERTY_NAME_TYPE        + Definitions.QUOTATION_MARK + Definitions.COLON + Definitions.SPACE + Definitions.QUOTATION_MARK + Definitions.JSON_OBJECT_TYPE_PROPERTY_VALUE_BOOK + Definitions.QUOTATION_MARK + Definitions.COMMA + Definitions.END_LINE
            + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.QUOTATION_MARK + Definitions.JSON_OBJECT_PROPERTY_NAME_NAME        + Definitions.QUOTATION_MARK + Definitions.COLON + Definitions.SPACE + Definitions.QUOTATION_MARK + TEACHING_ASSISTANT_BOOK_3_NAME                   + Definitions.QUOTATION_MARK + Definitions.COMMA + Definitions.END_LINE
            + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.QUOTATION_MARK + Definitions.JSON_OBJECT_PROPERTY_NAME_DESCRIPTION + Definitions.QUOTATION_MARK + Definitions.COLON + Definitions.SPACE + Definitions.QUOTATION_MARK + TEACHING_ASSISTANT_BOOK_3_DESCRIPTION            + Definitions.QUOTATION_MARK + Definitions.COMMA + Definitions.END_LINE
            + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.QUOTATION_MARK + Definitions.JSON_OBJECT_PROPERTY_NAME_AUTHOR      + Definitions.QUOTATION_MARK + Definitions.COLON + Definitions.SPACE + Definitions.QUOTATION_MARK + TEACHING_ASSISTANT_BOOK_3_AUTHOR                 + Definitions.QUOTATION_MARK + Definitions.COMMA + Definitions.END_LINE
            + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.QUOTATION_MARK + Definitions.JSON_OBJECT_PROPERTY_NAME_ISBN        + Definitions.QUOTATION_MARK + Definitions.COLON + Definitions.SPACE + Definitions.QUOTATION_MARK + TEACHING_ASSISTANT_BOOK_3_ISBN                   + Definitions.QUOTATION_MARK + Definitions.END_LINE
            + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.CLOSING_CURLY_BRACE + Definitions.COMMA + Definitions.END_LINE
            // -- TA b4 JSON object
            + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.OPENING_CURLY_BRACE + Definitions.END_LINE
            + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.QUOTATION_MARK + Definitions.JSON_OBJECT_PROPERTY_NAME_TYPE        + Definitions.QUOTATION_MARK + Definitions.COLON + Definitions.SPACE + Definitions.QUOTATION_MARK + Definitions.JSON_OBJECT_TYPE_PROPERTY_VALUE_BOOK + Definitions.QUOTATION_MARK + Definitions.COMMA + Definitions.END_LINE
            + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.QUOTATION_MARK + Definitions.JSON_OBJECT_PROPERTY_NAME_NAME        + Definitions.QUOTATION_MARK + Definitions.COLON + Definitions.SPACE + Definitions.QUOTATION_MARK + TEACHING_ASSISTANT_BOOK_4_NAME                   + Definitions.QUOTATION_MARK + Definitions.COMMA + Definitions.END_LINE
            + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.QUOTATION_MARK + Definitions.JSON_OBJECT_PROPERTY_NAME_DESCRIPTION + Definitions.QUOTATION_MARK + Definitions.COLON + Definitions.SPACE + Definitions.QUOTATION_MARK + TEACHING_ASSISTANT_BOOK_4_DESCRIPTION            + Definitions.QUOTATION_MARK + Definitions.COMMA + Definitions.END_LINE
            + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.QUOTATION_MARK + Definitions.JSON_OBJECT_PROPERTY_NAME_AUTHOR      + Definitions.QUOTATION_MARK + Definitions.COLON + Definitions.SPACE + Definitions.QUOTATION_MARK + TEACHING_ASSISTANT_BOOK_4_AUTHOR                 + Definitions.QUOTATION_MARK + Definitions.COMMA + Definitions.END_LINE
            + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.QUOTATION_MARK + Definitions.JSON_OBJECT_PROPERTY_NAME_ISBN        + Definitions.QUOTATION_MARK + Definitions.COLON + Definitions.SPACE + Definitions.QUOTATION_MARK + TEACHING_ASSISTANT_BOOK_4_ISBN                   + Definitions.QUOTATION_MARK + Definitions.END_LINE
            + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.CLOSING_CURLY_BRACE + Definitions.END_LINE
            + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.CLOSING_SQUARE_BRACKET + Definitions.END_LINE
            + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.CLOSING_CURLY_BRACE + Definitions.END_LINE
            + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.CLOSING_SQUARE_BRACKET + Definitions.END_LINE
            + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.CLOSING_CURLY_BRACE + Definitions.END_LINE
            + Definitions.JSON_INDENT + Definitions.CLOSING_SQUARE_BRACKET + Definitions.END_LINE
            + Definitions.CLOSING_CURLY_BRACE;
        Book taB1 = new Book( TEACHING_ASSISTANT_BOOK_1_NAME, TEACHING_ASSISTANT_BOOK_1_DESCRIPTION, TEACHING_ASSISTANT_BOOK_1_AUTHOR, TEACHING_ASSISTANT_BOOK_1_ISBN );
        Book taB2 = new Book( TEACHING_ASSISTANT_BOOK_2_NAME, TEACHING_ASSISTANT_BOOK_2_DESCRIPTION, TEACHING_ASSISTANT_BOOK_2_AUTHOR, TEACHING_ASSISTANT_BOOK_2_ISBN );
        Book taB3 = new Book( TEACHING_ASSISTANT_BOOK_3_NAME, TEACHING_ASSISTANT_BOOK_3_DESCRIPTION, TEACHING_ASSISTANT_BOOK_3_AUTHOR, TEACHING_ASSISTANT_BOOK_3_ISBN );
        Book taB4 = new Book( TEACHING_ASSISTANT_BOOK_4_NAME, TEACHING_ASSISTANT_BOOK_4_DESCRIPTION, TEACHING_ASSISTANT_BOOK_4_AUTHOR, TEACHING_ASSISTANT_BOOK_4_ISBN );
        Collection taC2 = new Collection( TEACHING_ASSISTANT_COLLECTION_2_NAME, TEACHING_ASSISTANT_COLLECTION_2_DESCRIPTION );
        taC2.add( taB3 );
        taC2.add( taB4 );
        Collection taC1 = new Collection( TEACHING_ASSISTANT_COLLECTION_1_NAME, TEACHING_ASSISTANT_COLLECTION_1_DESCRIPTION );
        taC1.add( taB2 );
        taC1.add( taC2 );
        Library library = new Library();
        library.add( taB1 );
        library.add( taC1 );
        library.exportItems( FILE_PATH );
        assertEquals( EXPECTED_DESTINATION_FILE_CONTENT.replaceAll( Definitions.REGEX_NON_PRINTABLE_UNICODE_CHARACTERS, Definitions.EMPTY ), getFileContent( FILE_PATH ).replaceAll( Definitions.REGEX_NON_PRINTABLE_UNICODE_CHARACTERS, Definitions.EMPTY ) ); // There was problems reading string from file that forced the developer to use this assertion method.
    }
}