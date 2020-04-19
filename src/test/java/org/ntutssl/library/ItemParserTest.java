package org.ntutssl.library;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Field;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ItemParserTest
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
    // b1 JSON object
    private final String BOOK_1_JSON_OBJECT = Definitions.OPENING_CURLY_BRACE + Definitions.END_LINE
        + Definitions.QUOTATION_MARK + Definitions.JSON_OBJECT_PROPERTY_NAME_TYPE        + Definitions.QUOTATION_MARK + Definitions.COLON + Definitions.SPACE + Definitions.QUOTATION_MARK + Definitions.JSON_OBJECT_TYPE_PROPERTY_VALUE_BOOK + Definitions.QUOTATION_MARK + Definitions.COMMA + Definitions.END_LINE
        + Definitions.QUOTATION_MARK + Definitions.JSON_OBJECT_PROPERTY_NAME_NAME        + Definitions.QUOTATION_MARK + Definitions.COLON + Definitions.SPACE + Definitions.QUOTATION_MARK + BOOK_1_NAME                                      + Definitions.QUOTATION_MARK + Definitions.COMMA + Definitions.END_LINE
        + Definitions.QUOTATION_MARK + Definitions.JSON_OBJECT_PROPERTY_NAME_DESCRIPTION + Definitions.QUOTATION_MARK + Definitions.COLON + Definitions.SPACE + Definitions.QUOTATION_MARK + BOOK_1_DESCRIPTION                               + Definitions.QUOTATION_MARK + Definitions.COMMA + Definitions.END_LINE
        + Definitions.QUOTATION_MARK + Definitions.JSON_OBJECT_PROPERTY_NAME_AUTHOR      + Definitions.QUOTATION_MARK + Definitions.COLON + Definitions.SPACE + Definitions.QUOTATION_MARK + BOOK_1_AUTHOR                                    + Definitions.QUOTATION_MARK + Definitions.COMMA + Definitions.END_LINE
        + Definitions.QUOTATION_MARK + Definitions.JSON_OBJECT_PROPERTY_NAME_ISBN        + Definitions.QUOTATION_MARK + Definitions.COLON + Definitions.SPACE + Definitions.QUOTATION_MARK + BOOK_1_ISBN                                      + Definitions.QUOTATION_MARK + Definitions.END_LINE
        + Definitions.CLOSING_CURLY_BRACE;

    private final String ITEM_BUILDER_CANNOT_BE_GOT = "The member variable item builder cannot be got";
    private final String MEMBER_VARIABLE_NAME_ITEM_BUILDER = "_itemBuilder";
    private ItemParser _itemParser;

    private ItemBuilder getItemBuilder()
    {
        try
        {
            Field itemBuilderField = ItemParser.class.getDeclaredField( MEMBER_VARIABLE_NAME_ITEM_BUILDER );
            itemBuilderField.setAccessible( true );
            try
            {
                return ( ItemBuilder )itemBuilderField.get( _itemParser );
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
        throw new IllegalStateException( ITEM_BUILDER_CANNOT_BE_GOT );
    }

    private void assertBookEquals( String expectedBookName, String expectedBookDescription, String expectedBookAuthor, String expectedBookIsbn, Book book )
    {
        assertEquals( expectedBookName,        book.name() );
        assertEquals( expectedBookDescription, book.description() );
        assertEquals( expectedBookAuthor,      book.author() );
        assertEquals( expectedBookIsbn,        book.isbn() );
    }

    @Before
    public void setUp()
    {
        _itemParser = new ItemParser();
    }

    @After
    public void tearDown()
    {
        /* Body intentionally empty */
    }

    @Test
    public void test_parsing_b1()
    {
        _itemParser.parseItem( BOOK_1_JSON_OBJECT );
        assertBookEquals( BOOK_1_NAME, BOOK_1_DESCRIPTION, BOOK_1_AUTHOR, BOOK_1_ISBN, ( Book )getItemBuilder().getResult() );
    }

    @Test
    public void test_getting_result_returning_item_builder_result()
    {
        assertSame( getItemBuilder().getResult(), _itemParser.getResult() );
    }
}