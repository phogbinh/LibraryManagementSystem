package org.ntutssl.library;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Field;
import java.util.Iterator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ItemBuilderTest
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

    private final String ERROR_ITEM_CANNOT_BE_GOT = "The member variable item cannot be got";
    private final String MEMBER_VARIABLE_NAME_ITEM = "_item";
    private ItemBuilder _itemBuilder;

    private Item getItem()
    {
        try
        {
            Field itemField = ItemBuilder.class.getDeclaredField( MEMBER_VARIABLE_NAME_ITEM );
            itemField.setAccessible( true );
            try
            {
                return ( Item )itemField.get( _itemBuilder );
            }
            catch ( IllegalAccessException exception )
            {
                assertTrue( false );
            }
        }
        catch ( NoSuchFieldException exception )
        {
            assertTrue( false );
        }
        throw new IllegalStateException( ERROR_ITEM_CANNOT_BE_GOT );
    }

    private void buildCollectionTwo()
    {
        _itemBuilder.beginBuildingCollection( COLLECTION_2_NAME, COLLECTION_2_DESCRIPTION );
        _itemBuilder.buildBook( BOOK_1_NAME, BOOK_1_DESCRIPTION, BOOK_1_AUTHOR, BOOK_1_ISBN );
        _itemBuilder.buildBook( BOOK_2_NAME, BOOK_2_DESCRIPTION, BOOK_2_AUTHOR, BOOK_2_ISBN );
        _itemBuilder.endBuildingCollection();
    }

    private void assertBookEquals( String expectedBookName, String expectedBookDescription, String expectedBookAuthor, String expectedBookIsbn, Book book )
    {
        assertEquals( expectedBookName,        book.name() );
        assertEquals( expectedBookDescription, book.description() );
        assertEquals( expectedBookAuthor,      book.author() );
        assertEquals( expectedBookIsbn,        book.isbn() );
    }

    private void assertEqualsCollectionTwo( Collection collection )
    {
        assertEquals( COLLECTION_2_NAME,        collection.name() );
        assertEquals( COLLECTION_2_DESCRIPTION, collection.description() );
        assertEquals( 2,                        collection.size() );
        Iterator< Item > iterator = collection.iterator();
        assertBookEquals( BOOK_1_NAME, BOOK_1_DESCRIPTION, BOOK_1_AUTHOR, BOOK_1_ISBN, ( Book )iterator.next() );
        assertBookEquals( BOOK_2_NAME, BOOK_2_DESCRIPTION, BOOK_2_AUTHOR, BOOK_2_ISBN, ( Book )iterator.next() );
        assertFalse( iterator.hasNext() );
    }

    @Before
    public void setUp()
    {
        _itemBuilder = new ItemBuilder();
    }

    @After
    public void tearDown()
    {
        /* Body intentionally empty */
    }

    @Test
    public void test_building_b1()
    {
        _itemBuilder.buildBook( BOOK_1_NAME, BOOK_1_DESCRIPTION, BOOK_1_AUTHOR, BOOK_1_ISBN );
        assertBookEquals( BOOK_1_NAME, BOOK_1_DESCRIPTION, BOOK_1_AUTHOR, BOOK_1_ISBN, ( Book )getItem() );
    }

    @Test
    public void test_building_c2()
    {
        buildCollectionTwo();
        assertEqualsCollectionTwo( ( Collection )getItem() );
    }

    @Test
    public void test_building_c1()
    {
        _itemBuilder.beginBuildingCollection( COLLECTION_1_NAME, COLLECTION_1_DESCRIPTION );
        buildCollectionTwo();
        _itemBuilder.buildBook( BOOK_3_NAME, BOOK_3_DESCRIPTION, BOOK_3_AUTHOR, BOOK_3_ISBN );
        _itemBuilder.endBuildingCollection();
        Collection collectionOne = ( Collection )getItem();
        assertEquals( COLLECTION_1_NAME,        collectionOne.name() );
        assertEquals( COLLECTION_1_DESCRIPTION, collectionOne.description() );
        assertEquals( 3,                        collectionOne.size() );
        Iterator< Item > iterator = collectionOne.iterator();
        assertEqualsCollectionTwo( ( Collection )iterator.next() );
        assertBookEquals( BOOK_3_NAME, BOOK_3_DESCRIPTION, BOOK_3_AUTHOR, BOOK_3_ISBN, ( Book )iterator.next() );
        assertFalse( iterator.hasNext() );
    }

    @Test
    public void test_getting_result_returning_item()
    {
        assertSame( getItem(), _itemBuilder.getResult() );
    }
}