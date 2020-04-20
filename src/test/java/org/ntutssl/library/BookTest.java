package org.ntutssl.library;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BookTest 
{
    private final String BOOK_NAME = "Design Patterns: Elements of Reusable Object-Oriented Software";
    private final String BOOK_DESCRIPTION = "This is a software engineering book describing software design patterns.";
    private final String BOOK_AUTHOR = "Gang of Four (GoF)";
    private final String BOOK_ISBN = "9780201633610";
    private Book _book;

    @Before
    public void setUp()
    {
        _book = new Book( BOOK_NAME, BOOK_DESCRIPTION, BOOK_AUTHOR, BOOK_ISBN );
    }

    @After
    public void tearDown()
    {
        /* Body intentionally empty */
    }
    
    @Test
    public void test_get_name()
    {
        assertEquals( BOOK_NAME, _book.name() );
    }

    @Test
    public void test_get_description()
    {
        assertEquals( BOOK_DESCRIPTION, _book.description() );
    }

    @Test
    public void test_get_author()
    {
        assertEquals( BOOK_AUTHOR, _book.author() );
    }

    @Test
    public void test_get_isbn()
    {
        assertEquals( BOOK_ISBN, _book.isbn() );
    }

    @Test
    public void test_size_of_book_being_1()
    {
        assertEquals( 1, _book.size() );
    }
    
    @Test
    public void test_accept_calling_visitor_visit_book()
    {
        VisitorMock visitorMock = new VisitorMock();
        _book.accept( visitorMock );
        assertTrue( visitorMock.IsCalledVisitBook );
    }
}