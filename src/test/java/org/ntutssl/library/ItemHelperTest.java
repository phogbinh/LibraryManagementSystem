package org.ntutssl.library;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ItemHelperTest
{
    @Test
    public void test_get_string_of_book()
    {
        final String BOOK_NAME = "Introduction to Algorithms, Third Edition";
        final String BOOK_DESCRIPTION = "The book covers a broad range of algorithms in depth, yet makes their design and analysis accessible to all levels of readers.";
        final String BOOK_AUTHOR = "Thomas H. Cormen";
        final String BOOK_ISBN = "9780262033848";
        final String EXPECTED_STRING = ItemHelper.BOOK_NAME + BOOK_NAME + Definitions.END_LINE
            + Definitions.INDENT + ItemHelper.BOOK_AUTHOR + BOOK_AUTHOR + Definitions.END_LINE
            + Definitions.INDENT + ItemHelper.BOOK_DESCRIPTION + BOOK_DESCRIPTION + Definitions.END_LINE
            + Definitions.INDENT + ItemHelper.BOOK_ISBN + BOOK_ISBN + Definitions.END_LINE;
        assertEquals( EXPECTED_STRING, ItemHelper.getString( new Book( BOOK_NAME, BOOK_DESCRIPTION, BOOK_AUTHOR, BOOK_ISBN ) ) );
    }

    @Test
    public void test_get_string_of_collection()
    {
        final String COLLECTION_NAME = "Data Structures and Algorithms Collection";
        final String COLLECTION_DESCRIPTION = "This is a data structures and algorithms collection";
        final String EXPECTED_STRING = ItemHelper.COLLECTION_NAME + COLLECTION_NAME + Definitions.END_LINE
            + Definitions.INDENT + ItemHelper.COLLECTION_DESCRIPTION + COLLECTION_DESCRIPTION + Definitions.END_LINE;
        assertEquals( EXPECTED_STRING, ItemHelper.getString( new Collection( COLLECTION_NAME, COLLECTION_DESCRIPTION ) ) );
    }

    @Test( expected = IllegalStateException.class )
    public void test_getting_string_of_null_throwing_exception()
    {
        ItemHelper.getString( null );
    }
}