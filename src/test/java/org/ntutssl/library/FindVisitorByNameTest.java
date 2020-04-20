package org.ntutssl.library;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Field;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FindVisitorByNameTest 
{
    private final String ITEM_NAME_AAA = "aaa";
    private final String ITEM_NAME_BBB = "bbb";
    // c1
    private final String COLLECTION_1_NAME = ITEM_NAME_AAA;
    private final String COLLECTION_1_DESCRIPTION = "This is a programming collection.";
    // - c2
    private final String COLLECTION_2_NAME = ITEM_NAME_BBB;
    private final String COLLECTION_2_DESCRIPTION = "This is a data structures and algorithms collection";
    // -- b1
    private final String BOOK_1_NAME = ITEM_NAME_BBB;
    private final String BOOK_1_DESCRIPTION = "The book covers a broad range of algorithms in depth, yet makes their design and analysis accessible to all levels of readers.";
    private final String BOOK_1_AUTHOR = "Thomas H. Cormen";
    private final String BOOK_1_ISBN = "9780262033848";
    // -- b2
    private final String BOOK_2_NAME = ITEM_NAME_AAA;
    private final String BOOK_2_DESCRIPTION = "Based on the authors' market leading data structures books in Java and C++, this book offers a comprehensive, definitive introduction to data structures in Python by authoritative authors.";
    private final String BOOK_2_AUTHOR = "Michael H. Goldwasser";
    private final String BOOK_2_ISBN = "9781118290279";
    // - b3
    private final String BOOK_3_NAME = ITEM_NAME_BBB;
    private final String BOOK_3_DESCRIPTION = "This is a software engineering book describing software design patterns.";
    private final String BOOK_3_AUTHOR = "Gang of Four (GoF)";
    private final String BOOK_3_ISBN = "9780201633610";
    
    private final String ITEMS_CANNOT_BE_GOT = "The member variable items cannot be got";
    private final String MEMBER_VARIABLE_NAME_ITEMS = "_items";
    private Item _c1;
    private Item _c2;
    private Item _b1;
    private Item _b2;
    private Item _b3;
    private FindVisitorByName _findingAaaVisitor;

    private ArrayList< Item > GetItems()
    {
        try
        {
            Field itemsField = FindVisitorByName.class.getDeclaredField( MEMBER_VARIABLE_NAME_ITEMS );
            itemsField.setAccessible( true );
            try
            {
                return ( ArrayList< Item > )itemsField.get( _findingAaaVisitor );
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
        throw new IllegalStateException( ITEMS_CANNOT_BE_GOT );
    }

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
        _findingAaaVisitor = new FindVisitorByName( ITEM_NAME_AAA );
    }

    @After
    public void tearDown()
    {
        /* Body intentionally empty */
    }

    @Test
    public void test_finding_aaa_visitor_visiting_b2_adding_b2_to_its_items()
    {
        _findingAaaVisitor.visitBook( ( Book )_b2 );
        ArrayList< Item > expectedItems = GetItems();
        assertEquals( 1, expectedItems.size() );
        assertSame( _b2, expectedItems.get( 0 ) );
    }

    @Test
    public void test_finding_aaa_visitor_visiting_b1_adding_nothing_to_its_items()
    {
        _findingAaaVisitor.visitBook( ( Book )_b1 );
        ArrayList< Item > expectedItems = GetItems();
        assertEquals( 0, expectedItems.size() );
    }

    @Test
    public void test_finding_aaa_visitor_visiting_c1_adding_c1_and_b2_to_its_items()
    {
        _findingAaaVisitor.visitCollection( ( Collection )_c1 );
        ArrayList< Item > expectedItems = GetItems();
        assertEquals( 2, expectedItems.size() );
        assertSame( _c1, expectedItems.get( 0 ) );
        assertSame( _b2, expectedItems.get( 1 ) );
    }

    @Test
    public void test_get_result()
    {
        final String EXPECTED_RESULT = Definitions.COLLECTION_NAME + COLLECTION_1_NAME + Definitions.END_LINE
            + Definitions.INDENT + Definitions.COLLECTION_DESCRIPTION + COLLECTION_1_DESCRIPTION + Definitions.END_LINE
            + Definitions.BOOK_NAME + BOOK_2_NAME + Definitions.END_LINE
            + Definitions.INDENT + Definitions.BOOK_AUTHOR + BOOK_2_AUTHOR + Definitions.END_LINE
            + Definitions.INDENT + Definitions.BOOK_DESCRIPTION + BOOK_2_DESCRIPTION + Definitions.END_LINE
            + Definitions.INDENT + Definitions.BOOK_ISBN + BOOK_2_ISBN + Definitions.END_LINE;
        _findingAaaVisitor.visitCollection( ( Collection )_c1 );
        assertEquals( EXPECTED_RESULT, _findingAaaVisitor.getResult() );
    }
}