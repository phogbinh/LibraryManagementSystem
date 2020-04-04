package org.ntutssl.library;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.Vector;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CollectionTest 
{
    // c1
    private final String COLLECTION_1_NAME = "Programming Collection";
    private final String COLLECTION_1_DESCRIPTION = "This is a programming collection.";
    // - c2
    private final String COLLECTION_2_NAME = "Data Structures and Algorithms Collection";
    private final String COLLECTION_2_DESCRIPTION = "This is a data structures and algorithms collection";
    // -- b1
    private final String BOOK_1_NAME = "Introduction to Algorithms, Third Edition";
    private final String BOOK_1_DESCRIPTION = "The book covers a broad range of algorithms in depth, yet makes their design and analysis accessible to all levels of readers.";
    private final String BOOK_1_AUTHOR = "Thomas H. Cormen";
    private final String BOOK_1_ISBN = "9780262033848";
    // -- b2
    private final String BOOK_2_NAME = "Data Structures and Algorithms in Python";
    private final String BOOK_2_DESCRIPTION = "Based on the authors' market leading data structures books in Java and C++, this book offers a comprehensive, definitive introduction to data structures in Python by authoritative authors.";
    private final String BOOK_2_AUTHOR = "Michael H. Goldwasser";
    private final String BOOK_2_ISBN = "9781118290279";
    // - b3
    private final String BOOK_3_NAME = "Design Patterns: Elements of Reusable Object-Oriented Software";
    private final String BOOK_3_DESCRIPTION = "This is a software engineering book describing software design patterns.";
    private final String BOOK_3_AUTHOR = "Gang of Four (GoF)";
    private final String BOOK_3_ISBN = "9780201633610";
    
    private final String MEMBER_VARIABLE_NAME_ITEMS = "_items";
    private Item _c1;
    private Item _c2;
    private Item _b1;
    private Item _b2;
    private Item _b3;

    @Before
    public void setUp()
    {
        _b1 = new Book( BOOK_1_NAME, BOOK_1_DESCRIPTION, BOOK_1_AUTHOR, BOOK_1_ISBN );
        _b2 = new Book( BOOK_2_NAME, BOOK_2_DESCRIPTION, BOOK_2_AUTHOR, BOOK_2_ISBN );
        _c2 = new Collection( COLLECTION_2_NAME, COLLECTION_2_DESCRIPTION );
        _c2.add( _b1 );
        _c2.add( _b2 );
        _b3 = new Book( BOOK_3_NAME, BOOK_3_DESCRIPTION, BOOK_3_AUTHOR, BOOK_3_ISBN );
        _c1 = new Collection( COLLECTION_1_NAME, COLLECTION_1_DESCRIPTION );
        _c1.add( _c2 );
        _c1.add( _b3 );
    }

    @After
    public void tearDown()
    {
        /* Body intentionally empty */
    }
    
    @Test
    public void test_getting_name()
    {
        assertEquals( COLLECTION_1_NAME, _c1.name() );
    }

    @Test
    public void test_getting_description()
    {
        assertEquals( COLLECTION_1_DESCRIPTION, _c1.description() );
    }

    @Test
    public void test_adding_b1_and_b2_to_c2()
    {
        Item b1 = new Book( BOOK_1_NAME, BOOK_1_DESCRIPTION, BOOK_1_AUTHOR, BOOK_1_ISBN );
        Item b2 = new Book( BOOK_2_NAME, BOOK_2_DESCRIPTION, BOOK_2_AUTHOR, BOOK_2_ISBN );
        Item c2 = new Collection( COLLECTION_2_NAME, COLLECTION_2_DESCRIPTION );
        c2.add( b1 );
        c2.add( b2 );
        try
        {
            Field itemsField = Collection.class.getDeclaredField( MEMBER_VARIABLE_NAME_ITEMS );
            itemsField.setAccessible( true );
            try
            {
                Vector< Item > expectedItems = ( Vector< Item > )itemsField.get( c2 );
                assertEquals( 2, expectedItems.size() );
                assertSame( b1, expectedItems.get( 0 ) );
                assertSame( b2, expectedItems.get( 1 ) );
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
    public void test_size_of_c1_being_3()
    {
        assertEquals( 3, _c1.size() );
    }

    @Test
    public void test_size_of_c2_being_2()
    {
        assertEquals( 2, _c2.size() );
    }

    @Test
    public void test_iterator_of_c1_being_that_of_its_internal_items()
    {
        try
        {
            Field itemsField = Collection.class.getDeclaredField( MEMBER_VARIABLE_NAME_ITEMS );
            itemsField.setAccessible( true );
            try
            {
                Vector< Item > expectedItems = ( Vector< Item > )itemsField.get( _c1 );
                Iterator< Item > c1Iterator = _c1.iterator();
                Iterator< Item > c1ItemsIterator = expectedItems.iterator();
                assertSame( c1Iterator.next(), c1ItemsIterator.next() );
                assertSame( c1Iterator.next(), c1ItemsIterator.next() );
                assertFalse( c1Iterator.hasNext() );
                assertFalse( c1ItemsIterator.hasNext() );
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
    public void test_accept_calling_visitor_visit_collection()
    {
        VisitorMock visitorMock = new VisitorMock();
        _c1.accept( visitorMock );
        assertTrue( visitorMock.IsCalledVisitCollection );
    }
}
