package org.ntutssl.library;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Field;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ListDetailVisitorTest 
{
    private final String ITEM_INFO_CANNOT_BE_GOT = "The member variable item info cannot be got";
    private final String MEMBER_VARIABLE_NAME_ITEM_INFO = "_itemInfo";
    private Visitor _visitor;

    private String GetItemInfo()
    {
        try
        {
            Field itemInfoField = ListDetailVisitor.class.getDeclaredField( MEMBER_VARIABLE_NAME_ITEM_INFO );
            itemInfoField.setAccessible( true );
            try
            {
                return ( String )itemInfoField.get( _visitor );
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
        throw new IllegalStateException( ITEM_INFO_CANNOT_BE_GOT );
    }

    @Before
    public void setUp()
    {
        _visitor = new ListDetailVisitor();
    }

    @After
    public void tearDown()
    {
        /* Body intentionally empty */
    }

    @Test
    public void test_visiting_book_setting_item_info_to_book_info()
    {
        final String BOOK_NAME = "Introduction to Algorithms, Third Edition";
        final String BOOK_DESCRIPTION = "The book covers a broad range of algorithms in depth, yet makes their design and analysis accessible to all levels of readers.";
        final String BOOK_AUTHOR = "Thomas H. Cormen";
        final String BOOK_ISBN = "9780262033848";
        final String EXPECTED_STRING = ListDetailVisitor.BOOK_NAME + BOOK_NAME + Definitions.END_LINE
            + Definitions.INDENT + ListDetailVisitor.BOOK_AUTHOR + BOOK_AUTHOR + Definitions.END_LINE
            + Definitions.INDENT + ListDetailVisitor.BOOK_DESCRIPTION + BOOK_DESCRIPTION + Definitions.END_LINE
            + Definitions.INDENT + ListDetailVisitor.BOOK_ISBN + BOOK_ISBN + Definitions.END_LINE;
        Book book = new Book( BOOK_NAME, BOOK_DESCRIPTION, BOOK_AUTHOR, BOOK_ISBN );
        book.accept( _visitor );
        assertEquals( EXPECTED_STRING, _visitor.getResult() );
    }

    @Test
    public void test_visiting_collection_setting_item_info_to_collection_info()
    {
        final String COLLECTION_NAME = "Data Structures and Algorithms Collection";
        final String COLLECTION_DESCRIPTION = "This is a data structures and algorithms collection";
        final String EXPECTED_STRING = ListDetailVisitor.COLLECTION_NAME + COLLECTION_NAME + Definitions.END_LINE
            + Definitions.INDENT + ListDetailVisitor.COLLECTION_DESCRIPTION + COLLECTION_DESCRIPTION + Definitions.END_LINE;
        Collection collection = new Collection( COLLECTION_NAME, COLLECTION_DESCRIPTION );
        collection.accept( _visitor );
        assertEquals( EXPECTED_STRING, _visitor.getResult() );
    }

    @Test
    public void test_getting_result_returning_visitor_item_info()
    {
        assertSame( GetItemInfo(), _visitor.getResult() );
    }
}