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
    // book
    private final String BOOK_NAME = "Introduction to Algorithms, Third Edition";
    private final String BOOK_DESCRIPTION = "The book covers a broad range of algorithms in depth, yet makes their design and analysis accessible to all levels of readers.";
    private final String BOOK_AUTHOR = "Thomas H. Cormen";
    private final String BOOK_ISBN = "9780262033848";
    // collection
    private final String COLLECTION_NAME = "Data Structures and Algorithms Collection";
    private final String COLLECTION_DESCRIPTION = "This is a data structures and algorithms collection";

    private final String ITEM_INFO_CANNOT_BE_GOT = "The member variable item info cannot be got";
    private final String MEMBER_VARIABLE_NAME_ITEM_INFO = "_itemInfo";
    private Book _book;
    private Collection _collection;
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
        _book = new Book( BOOK_NAME, BOOK_DESCRIPTION, BOOK_AUTHOR, BOOK_ISBN );
        _collection = new Collection( COLLECTION_NAME, COLLECTION_DESCRIPTION );
        _collection.add( _book );
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
        final String EXPECTED_STRING = ItemHelper.BOOK_NAME + BOOK_NAME + Definitions.END_LINE
            + Definitions.INDENT + ItemHelper.BOOK_AUTHOR + BOOK_AUTHOR + Definitions.END_LINE
            + Definitions.INDENT + ItemHelper.BOOK_DESCRIPTION + BOOK_DESCRIPTION + Definitions.END_LINE
            + Definitions.INDENT + ItemHelper.BOOK_ISBN + BOOK_ISBN + Definitions.END_LINE;
        _book.accept( _visitor );
        assertEquals( EXPECTED_STRING, _visitor.getResult() );
    }

    @Test
    public void test_visiting_collection_setting_item_info_to_collection_info()
    {
        final String EXPECTED_STRING = ItemHelper.COLLECTION_NAME + COLLECTION_NAME + Definitions.END_LINE
            + Definitions.INDENT + ItemHelper.COLLECTION_DESCRIPTION + COLLECTION_DESCRIPTION + Definitions.END_LINE
            + Definitions.INDENT + ItemHelper.BOOK_NAME + BOOK_NAME + Definitions.END_LINE
            + Definitions.INDENT + Definitions.INDENT + ItemHelper.BOOK_AUTHOR + BOOK_AUTHOR + Definitions.END_LINE
            + Definitions.INDENT + Definitions.INDENT + ItemHelper.BOOK_DESCRIPTION + BOOK_DESCRIPTION + Definitions.END_LINE
            + Definitions.INDENT + Definitions.INDENT + ItemHelper.BOOK_ISBN + BOOK_ISBN + Definitions.END_LINE;
        _collection.accept( _visitor );
        assertEquals( EXPECTED_STRING, _visitor.getResult() );
    }

    @Test
    public void test_getting_result_returning_visitor_item_info()
    {
        assertSame( GetItemInfo(), _visitor.getResult() );
    }
}