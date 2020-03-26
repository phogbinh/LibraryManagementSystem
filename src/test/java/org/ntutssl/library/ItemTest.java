package org.ntutssl.library;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ItemTest 
{
    private final String BOOK_NAME = "Design Patterns: Elements of Reusable Object-Oriented Software";
    private final String BOOK_DESCRIPTION = "This is a software engineering book describing software design patterns.";
    private final String BOOK_AUTHOR = "Gang of Four (GoF)";
    private final String BOOK_ISBN = "9780201633610";
    private final String COLLECTION_NAME = "Programming Collection";
    private final String COLLECTION_DESCRIPTION = "This is a programming collection.";

    private Item _book;
    private Item _collection;

    @Before
    public void setUp()
    {
        _book = new Book( BOOK_NAME, BOOK_DESCRIPTION, BOOK_AUTHOR, BOOK_ISBN );
        _collection = new Collection( COLLECTION_NAME, COLLECTION_DESCRIPTION );
    }

    @After
    public void tearDown()
    {
        /* Body intentionally empty */
    }

    @Test( expected = IllegalStateException.class )
    public void test_add_being_called_on_book_throwing_exception()
    {
        _book.add( new Book( TestDefinitions.DUMP_STRING, TestDefinitions.DUMP_STRING, TestDefinitions.DUMP_STRING, TestDefinitions.DUMP_STRING ) );
    }

    @Test( expected = IllegalStateException.class )
    public void test_isbn_being_called_on_collection_throwing_exception()
    {
        _collection.isbn();
    }

    @Test( expected = IllegalStateException.class )
    public void test_author_being_called_on_collection_throwing_exception()
    {
        _collection.author();
    }
}
