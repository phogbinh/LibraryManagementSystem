package org.ntutssl.library;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Field;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class WriteVisitorTest
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

    private final String ERROR_JSON_ARRAY_ITEMS_CANNOT_BE_GOT = "The member variable JSON array items cannot be got";
    private final String MEMBER_VARIABLE_NAME_JSON_ARRAY_ITEMS = "_jsonArrayItems";
    private Collection _c1;
    private Collection _c2;
    private Book _b1;
    private Book _b2;
    private Book _b3;
    private WriteVisitor _visitor;

    private String getJsonArrayItems()
    {
        try
        {
            Field jsonArrayItemsField = WriteVisitor.class.getDeclaredField( MEMBER_VARIABLE_NAME_JSON_ARRAY_ITEMS );
            jsonArrayItemsField.setAccessible( true );
            try
            {
                return ( String )jsonArrayItemsField.get( _visitor );
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
        throw new IllegalStateException( ERROR_JSON_ARRAY_ITEMS_CANNOT_BE_GOT );
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
        _visitor = new WriteVisitor();
    }

    @After
    public void tearDown()
    {
        /* Body intentionally empty */
    }

    @Test
    public void test_visiting_b1()
    {
        final String EXPECTED_ITEMS_LIST_JSON_OBJECT = Definitions.OPENING_CURLY_BRACE + Definitions.END_LINE
            + Definitions.JSON_INDENT + Definitions.QUOTATION_MARK + Definitions.JSON_OBJECT_PROPERTY_NAME_ITEMS_LIST + Definitions.QUOTATION_MARK + Definitions.COLON + Definitions.SPACE + Definitions.OPENING_SQUARE_BRACKET + Definitions.END_LINE
            + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.OPENING_CURLY_BRACE + Definitions.END_LINE
            + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.QUOTATION_MARK + Definitions.JSON_OBJECT_PROPERTY_NAME_TYPE        + Definitions.QUOTATION_MARK + Definitions.COLON + Definitions.SPACE + Definitions.QUOTATION_MARK + Definitions.JSON_OBJECT_TYPE_PROPERTY_VALUE_BOOK + Definitions.QUOTATION_MARK + Definitions.COMMA + Definitions.END_LINE
            + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.QUOTATION_MARK + Definitions.JSON_OBJECT_PROPERTY_NAME_NAME        + Definitions.QUOTATION_MARK + Definitions.COLON + Definitions.SPACE + Definitions.QUOTATION_MARK + BOOK_1_NAME                                      + Definitions.QUOTATION_MARK + Definitions.COMMA + Definitions.END_LINE
            + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.QUOTATION_MARK + Definitions.JSON_OBJECT_PROPERTY_NAME_DESCRIPTION + Definitions.QUOTATION_MARK + Definitions.COLON + Definitions.SPACE + Definitions.QUOTATION_MARK + BOOK_1_DESCRIPTION                               + Definitions.QUOTATION_MARK + Definitions.COMMA + Definitions.END_LINE
            + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.QUOTATION_MARK + Definitions.JSON_OBJECT_PROPERTY_NAME_AUTHOR      + Definitions.QUOTATION_MARK + Definitions.COLON + Definitions.SPACE + Definitions.QUOTATION_MARK + BOOK_1_AUTHOR                                    + Definitions.QUOTATION_MARK + Definitions.COMMA + Definitions.END_LINE
            + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.QUOTATION_MARK + Definitions.JSON_OBJECT_PROPERTY_NAME_ISBN        + Definitions.QUOTATION_MARK + Definitions.COLON + Definitions.SPACE + Definitions.QUOTATION_MARK + BOOK_1_ISBN                                      + Definitions.QUOTATION_MARK + Definitions.END_LINE
            + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.CLOSING_CURLY_BRACE + Definitions.END_LINE
            + Definitions.JSON_INDENT + Definitions.CLOSING_SQUARE_BRACKET + Definitions.END_LINE
            + Definitions.CLOSING_CURLY_BRACE;
        _visitor.visitBook( _b1 );
        assertEquals( EXPECTED_ITEMS_LIST_JSON_OBJECT, _visitor.getResult() );
    }

    @Test
    public void test_visiting_c2()
    {
        final String EXPECTED_ITEMS_LIST_JSON_OBJECT = Definitions.OPENING_CURLY_BRACE + Definitions.END_LINE
            + Definitions.JSON_INDENT + Definitions.QUOTATION_MARK + Definitions.JSON_OBJECT_PROPERTY_NAME_ITEMS_LIST + Definitions.QUOTATION_MARK + Definitions.COLON + Definitions.SPACE + Definitions.OPENING_SQUARE_BRACKET + Definitions.END_LINE
            // c2 JSON object
            + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.OPENING_CURLY_BRACE + Definitions.END_LINE
            + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.QUOTATION_MARK + Definitions.JSON_OBJECT_PROPERTY_NAME_TYPE        + Definitions.QUOTATION_MARK + Definitions.COLON + Definitions.SPACE + Definitions.QUOTATION_MARK + Definitions.JSON_OBJECT_TYPE_PROPERTY_VALUE_COLLECTION + Definitions.QUOTATION_MARK + Definitions.COMMA + Definitions.END_LINE
            + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.QUOTATION_MARK + Definitions.JSON_OBJECT_PROPERTY_NAME_NAME        + Definitions.QUOTATION_MARK + Definitions.COLON + Definitions.SPACE + Definitions.QUOTATION_MARK + COLLECTION_2_NAME                                      + Definitions.QUOTATION_MARK + Definitions.COMMA + Definitions.END_LINE
            + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.QUOTATION_MARK + Definitions.JSON_OBJECT_PROPERTY_NAME_DESCRIPTION + Definitions.QUOTATION_MARK + Definitions.COLON + Definitions.SPACE + Definitions.QUOTATION_MARK + COLLECTION_2_DESCRIPTION                               + Definitions.QUOTATION_MARK + Definitions.COMMA + Definitions.END_LINE
            + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.QUOTATION_MARK + Definitions.JSON_OBJECT_PROPERTY_NAME_ITEMS       + Definitions.QUOTATION_MARK + Definitions.COLON + Definitions.SPACE + Definitions.OPENING_SQUARE_BRACKET + Definitions.END_LINE
            // - b1 JSON object
            + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.OPENING_CURLY_BRACE + Definitions.END_LINE
            + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.QUOTATION_MARK + Definitions.JSON_OBJECT_PROPERTY_NAME_TYPE        + Definitions.QUOTATION_MARK + Definitions.COLON + Definitions.SPACE + Definitions.QUOTATION_MARK + Definitions.JSON_OBJECT_TYPE_PROPERTY_VALUE_BOOK + Definitions.QUOTATION_MARK + Definitions.COMMA + Definitions.END_LINE
            + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.QUOTATION_MARK + Definitions.JSON_OBJECT_PROPERTY_NAME_NAME        + Definitions.QUOTATION_MARK + Definitions.COLON + Definitions.SPACE + Definitions.QUOTATION_MARK + BOOK_1_NAME                                      + Definitions.QUOTATION_MARK + Definitions.COMMA + Definitions.END_LINE
            + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.QUOTATION_MARK + Definitions.JSON_OBJECT_PROPERTY_NAME_DESCRIPTION + Definitions.QUOTATION_MARK + Definitions.COLON + Definitions.SPACE + Definitions.QUOTATION_MARK + BOOK_1_DESCRIPTION                               + Definitions.QUOTATION_MARK + Definitions.COMMA + Definitions.END_LINE
            + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.QUOTATION_MARK + Definitions.JSON_OBJECT_PROPERTY_NAME_AUTHOR      + Definitions.QUOTATION_MARK + Definitions.COLON + Definitions.SPACE + Definitions.QUOTATION_MARK + BOOK_1_AUTHOR                                    + Definitions.QUOTATION_MARK + Definitions.COMMA + Definitions.END_LINE
            + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.QUOTATION_MARK + Definitions.JSON_OBJECT_PROPERTY_NAME_ISBN        + Definitions.QUOTATION_MARK + Definitions.COLON + Definitions.SPACE + Definitions.QUOTATION_MARK + BOOK_1_ISBN                                      + Definitions.QUOTATION_MARK + Definitions.END_LINE
            + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.CLOSING_CURLY_BRACE + Definitions.COMMA + Definitions.END_LINE
            // - b2 JSON object
            + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.OPENING_CURLY_BRACE + Definitions.END_LINE
            + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.QUOTATION_MARK + Definitions.JSON_OBJECT_PROPERTY_NAME_TYPE        + Definitions.QUOTATION_MARK + Definitions.COLON + Definitions.SPACE + Definitions.QUOTATION_MARK + Definitions.JSON_OBJECT_TYPE_PROPERTY_VALUE_BOOK + Definitions.QUOTATION_MARK + Definitions.COMMA + Definitions.END_LINE
            + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.QUOTATION_MARK + Definitions.JSON_OBJECT_PROPERTY_NAME_NAME        + Definitions.QUOTATION_MARK + Definitions.COLON + Definitions.SPACE + Definitions.QUOTATION_MARK + BOOK_2_NAME                                      + Definitions.QUOTATION_MARK + Definitions.COMMA + Definitions.END_LINE
            + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.QUOTATION_MARK + Definitions.JSON_OBJECT_PROPERTY_NAME_DESCRIPTION + Definitions.QUOTATION_MARK + Definitions.COLON + Definitions.SPACE + Definitions.QUOTATION_MARK + BOOK_2_DESCRIPTION                               + Definitions.QUOTATION_MARK + Definitions.COMMA + Definitions.END_LINE
            + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.QUOTATION_MARK + Definitions.JSON_OBJECT_PROPERTY_NAME_AUTHOR      + Definitions.QUOTATION_MARK + Definitions.COLON + Definitions.SPACE + Definitions.QUOTATION_MARK + BOOK_2_AUTHOR                                    + Definitions.QUOTATION_MARK + Definitions.COMMA + Definitions.END_LINE
            + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.QUOTATION_MARK + Definitions.JSON_OBJECT_PROPERTY_NAME_ISBN        + Definitions.QUOTATION_MARK + Definitions.COLON + Definitions.SPACE + Definitions.QUOTATION_MARK + BOOK_2_ISBN                                      + Definitions.QUOTATION_MARK + Definitions.END_LINE
            + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.CLOSING_CURLY_BRACE + Definitions.END_LINE
            + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.CLOSING_SQUARE_BRACKET + Definitions.END_LINE
            + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.CLOSING_CURLY_BRACE + Definitions.END_LINE
            + Definitions.JSON_INDENT + Definitions.CLOSING_SQUARE_BRACKET + Definitions.END_LINE
            + Definitions.CLOSING_CURLY_BRACE;
        _visitor.visitCollection( _c2 );
        assertEquals( EXPECTED_ITEMS_LIST_JSON_OBJECT, _visitor.getResult() );
    }

    @Test
    public void test_visiting_c1()
    {
        final String EXPECTED_ITEMS_LIST_JSON_OBJECT = Definitions.OPENING_CURLY_BRACE + Definitions.END_LINE
            + Definitions.JSON_INDENT + Definitions.QUOTATION_MARK + Definitions.JSON_OBJECT_PROPERTY_NAME_ITEMS_LIST + Definitions.QUOTATION_MARK + Definitions.COLON + Definitions.SPACE + Definitions.OPENING_SQUARE_BRACKET + Definitions.END_LINE
            // c1 JSON object
            + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.OPENING_CURLY_BRACE + Definitions.END_LINE
            + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.QUOTATION_MARK + Definitions.JSON_OBJECT_PROPERTY_NAME_TYPE        + Definitions.QUOTATION_MARK + Definitions.COLON + Definitions.SPACE + Definitions.QUOTATION_MARK + Definitions.JSON_OBJECT_TYPE_PROPERTY_VALUE_COLLECTION + Definitions.QUOTATION_MARK + Definitions.COMMA + Definitions.END_LINE
            + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.QUOTATION_MARK + Definitions.JSON_OBJECT_PROPERTY_NAME_NAME        + Definitions.QUOTATION_MARK + Definitions.COLON + Definitions.SPACE + Definitions.QUOTATION_MARK + COLLECTION_1_NAME                                      + Definitions.QUOTATION_MARK + Definitions.COMMA + Definitions.END_LINE
            + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.QUOTATION_MARK + Definitions.JSON_OBJECT_PROPERTY_NAME_DESCRIPTION + Definitions.QUOTATION_MARK + Definitions.COLON + Definitions.SPACE + Definitions.QUOTATION_MARK + COLLECTION_1_DESCRIPTION                               + Definitions.QUOTATION_MARK + Definitions.COMMA + Definitions.END_LINE
            + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.QUOTATION_MARK + Definitions.JSON_OBJECT_PROPERTY_NAME_ITEMS       + Definitions.QUOTATION_MARK + Definitions.COLON + Definitions.SPACE + Definitions.OPENING_SQUARE_BRACKET + Definitions.END_LINE
            // - c2 JSON object
            + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.OPENING_CURLY_BRACE + Definitions.END_LINE
            + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.QUOTATION_MARK + Definitions.JSON_OBJECT_PROPERTY_NAME_TYPE        + Definitions.QUOTATION_MARK + Definitions.COLON + Definitions.SPACE + Definitions.QUOTATION_MARK + Definitions.JSON_OBJECT_TYPE_PROPERTY_VALUE_COLLECTION + Definitions.QUOTATION_MARK + Definitions.COMMA + Definitions.END_LINE
            + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.QUOTATION_MARK + Definitions.JSON_OBJECT_PROPERTY_NAME_NAME        + Definitions.QUOTATION_MARK + Definitions.COLON + Definitions.SPACE + Definitions.QUOTATION_MARK + COLLECTION_2_NAME                                      + Definitions.QUOTATION_MARK + Definitions.COMMA + Definitions.END_LINE
            + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.QUOTATION_MARK + Definitions.JSON_OBJECT_PROPERTY_NAME_DESCRIPTION + Definitions.QUOTATION_MARK + Definitions.COLON + Definitions.SPACE + Definitions.QUOTATION_MARK + COLLECTION_2_DESCRIPTION                               + Definitions.QUOTATION_MARK + Definitions.COMMA + Definitions.END_LINE
            + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.QUOTATION_MARK + Definitions.JSON_OBJECT_PROPERTY_NAME_ITEMS       + Definitions.QUOTATION_MARK + Definitions.COLON + Definitions.SPACE + Definitions.OPENING_SQUARE_BRACKET + Definitions.END_LINE
            // -- b1 JSON object
            + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.OPENING_CURLY_BRACE + Definitions.END_LINE
            + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.QUOTATION_MARK + Definitions.JSON_OBJECT_PROPERTY_NAME_TYPE        + Definitions.QUOTATION_MARK + Definitions.COLON + Definitions.SPACE + Definitions.QUOTATION_MARK + Definitions.JSON_OBJECT_TYPE_PROPERTY_VALUE_BOOK + Definitions.QUOTATION_MARK + Definitions.COMMA + Definitions.END_LINE
            + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.QUOTATION_MARK + Definitions.JSON_OBJECT_PROPERTY_NAME_NAME        + Definitions.QUOTATION_MARK + Definitions.COLON + Definitions.SPACE + Definitions.QUOTATION_MARK + BOOK_1_NAME                                      + Definitions.QUOTATION_MARK + Definitions.COMMA + Definitions.END_LINE
            + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.QUOTATION_MARK + Definitions.JSON_OBJECT_PROPERTY_NAME_DESCRIPTION + Definitions.QUOTATION_MARK + Definitions.COLON + Definitions.SPACE + Definitions.QUOTATION_MARK + BOOK_1_DESCRIPTION                               + Definitions.QUOTATION_MARK + Definitions.COMMA + Definitions.END_LINE
            + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.QUOTATION_MARK + Definitions.JSON_OBJECT_PROPERTY_NAME_AUTHOR      + Definitions.QUOTATION_MARK + Definitions.COLON + Definitions.SPACE + Definitions.QUOTATION_MARK + BOOK_1_AUTHOR                                    + Definitions.QUOTATION_MARK + Definitions.COMMA + Definitions.END_LINE
            + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.QUOTATION_MARK + Definitions.JSON_OBJECT_PROPERTY_NAME_ISBN        + Definitions.QUOTATION_MARK + Definitions.COLON + Definitions.SPACE + Definitions.QUOTATION_MARK + BOOK_1_ISBN                                      + Definitions.QUOTATION_MARK + Definitions.END_LINE
            + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.CLOSING_CURLY_BRACE + Definitions.COMMA + Definitions.END_LINE
            // -- b2 JSON object
            + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.OPENING_CURLY_BRACE + Definitions.END_LINE
            + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.QUOTATION_MARK + Definitions.JSON_OBJECT_PROPERTY_NAME_TYPE        + Definitions.QUOTATION_MARK + Definitions.COLON + Definitions.SPACE + Definitions.QUOTATION_MARK + Definitions.JSON_OBJECT_TYPE_PROPERTY_VALUE_BOOK + Definitions.QUOTATION_MARK + Definitions.COMMA + Definitions.END_LINE
            + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.QUOTATION_MARK + Definitions.JSON_OBJECT_PROPERTY_NAME_NAME        + Definitions.QUOTATION_MARK + Definitions.COLON + Definitions.SPACE + Definitions.QUOTATION_MARK + BOOK_2_NAME                                      + Definitions.QUOTATION_MARK + Definitions.COMMA + Definitions.END_LINE
            + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.QUOTATION_MARK + Definitions.JSON_OBJECT_PROPERTY_NAME_DESCRIPTION + Definitions.QUOTATION_MARK + Definitions.COLON + Definitions.SPACE + Definitions.QUOTATION_MARK + BOOK_2_DESCRIPTION                               + Definitions.QUOTATION_MARK + Definitions.COMMA + Definitions.END_LINE
            + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.QUOTATION_MARK + Definitions.JSON_OBJECT_PROPERTY_NAME_AUTHOR      + Definitions.QUOTATION_MARK + Definitions.COLON + Definitions.SPACE + Definitions.QUOTATION_MARK + BOOK_2_AUTHOR                                    + Definitions.QUOTATION_MARK + Definitions.COMMA + Definitions.END_LINE
            + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.QUOTATION_MARK + Definitions.JSON_OBJECT_PROPERTY_NAME_ISBN        + Definitions.QUOTATION_MARK + Definitions.COLON + Definitions.SPACE + Definitions.QUOTATION_MARK + BOOK_2_ISBN                                      + Definitions.QUOTATION_MARK + Definitions.END_LINE
            + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.CLOSING_CURLY_BRACE + Definitions.END_LINE
            + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.CLOSING_SQUARE_BRACKET + Definitions.END_LINE
            + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.CLOSING_CURLY_BRACE + Definitions.COMMA + Definitions.END_LINE
            // - b3 JSON object
            + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.OPENING_CURLY_BRACE + Definitions.END_LINE
            + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.QUOTATION_MARK + Definitions.JSON_OBJECT_PROPERTY_NAME_TYPE        + Definitions.QUOTATION_MARK + Definitions.COLON + Definitions.SPACE + Definitions.QUOTATION_MARK + Definitions.JSON_OBJECT_TYPE_PROPERTY_VALUE_BOOK + Definitions.QUOTATION_MARK + Definitions.COMMA + Definitions.END_LINE
            + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.QUOTATION_MARK + Definitions.JSON_OBJECT_PROPERTY_NAME_NAME        + Definitions.QUOTATION_MARK + Definitions.COLON + Definitions.SPACE + Definitions.QUOTATION_MARK + BOOK_3_NAME                                      + Definitions.QUOTATION_MARK + Definitions.COMMA + Definitions.END_LINE
            + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.QUOTATION_MARK + Definitions.JSON_OBJECT_PROPERTY_NAME_DESCRIPTION + Definitions.QUOTATION_MARK + Definitions.COLON + Definitions.SPACE + Definitions.QUOTATION_MARK + BOOK_3_DESCRIPTION                               + Definitions.QUOTATION_MARK + Definitions.COMMA + Definitions.END_LINE
            + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.QUOTATION_MARK + Definitions.JSON_OBJECT_PROPERTY_NAME_AUTHOR      + Definitions.QUOTATION_MARK + Definitions.COLON + Definitions.SPACE + Definitions.QUOTATION_MARK + BOOK_3_AUTHOR                                    + Definitions.QUOTATION_MARK + Definitions.COMMA + Definitions.END_LINE
            + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.QUOTATION_MARK + Definitions.JSON_OBJECT_PROPERTY_NAME_ISBN        + Definitions.QUOTATION_MARK + Definitions.COLON + Definitions.SPACE + Definitions.QUOTATION_MARK + BOOK_3_ISBN                                      + Definitions.QUOTATION_MARK + Definitions.END_LINE
            + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.CLOSING_CURLY_BRACE + Definitions.END_LINE
            + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.CLOSING_SQUARE_BRACKET + Definitions.END_LINE
            + Definitions.JSON_INDENT + Definitions.JSON_INDENT + Definitions.CLOSING_CURLY_BRACE + Definitions.END_LINE
            + Definitions.JSON_INDENT + Definitions.CLOSING_SQUARE_BRACKET + Definitions.END_LINE
            + Definitions.CLOSING_CURLY_BRACE;
        _visitor.visitCollection( _c1 );
        assertEquals( EXPECTED_ITEMS_LIST_JSON_OBJECT, _visitor.getResult() );
    }

    @Test
    public void test_get_result()
    {
        final String EXPECTED_RESULT = Definitions.OPENING_CURLY_BRACE + Definitions.END_LINE
            + Definitions.JSON_INDENT + Definitions.QUOTATION_MARK + Definitions.JSON_OBJECT_PROPERTY_NAME_ITEMS_LIST + Definitions.QUOTATION_MARK + Definitions.COLON + Definitions.SPACE + Definitions.OPENING_SQUARE_BRACKET + Definitions.END_LINE
            + getJsonArrayItems() + Definitions.END_LINE
            + Definitions.JSON_INDENT + Definitions.CLOSING_SQUARE_BRACKET + Definitions.END_LINE
            + Definitions.CLOSING_CURLY_BRACE;
        assertEquals( EXPECTED_RESULT, _visitor.getResult() ); 
    }
}