package org.ntutssl.library;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Field;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LibraryTest 
{
    // c1
    private final String COLLECTION_1_NAME = "Programming Collection";
    private final String COLLECTION_1_DESCRIPTION = "This is a programming collection.";
    // b1
    private final String BOOK_1_NAME = "Introduction to Algorithms, Third Edition";
    private final String BOOK_1_DESCRIPTION = "The book covers a broad range of algorithms in depth, yet makes their design and analysis accessible to all levels of readers.";
    private final String BOOK_1_AUTHOR = "Thomas H. Cormen";
    private final String BOOK_1_ISBN = "9780262033848";
    // c2
    private final String COLLECTION_2_NAME = "Data Structures and Algorithms Collection";
    private final String COLLECTION_2_DESCRIPTION = "This is a data structures and algorithms collection";

    private final String MEMBER_VARIABLE_NAME_ITEMS = "_items";
    private Item _c1;
    private Item _b1;
    private Item _c2;
    private Library _library;

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
                ArrayList< Item > expectedItems = ( ArrayList< Item > )itemsField.get( library );
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
}
