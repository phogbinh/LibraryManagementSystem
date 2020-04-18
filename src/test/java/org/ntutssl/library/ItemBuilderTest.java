package org.ntutssl.library;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Field;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ItemBuilderTest
{
    private final String ITEM_CANNOT_BE_GOT = "The member variable item cannot be got";
    private final String MEMBER_VARIABLE_NAME_ITEM = "_item";
    private ItemBuilder _itemBuilder;

    private Item GetItem()
    {
        try
        {
            Field itemField = ItemBuilder.class.getDeclaredField( MEMBER_VARIABLE_NAME_ITEM );
            itemField.setAccessible( true );
            try
            {
                return ( Item )itemField.get( _itemBuilder );
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
        throw new IllegalStateException( ITEM_CANNOT_BE_GOT );
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
    public void test_getting_result_returning_item()
    {
        assertSame( GetItem(), _itemBuilder.getResult() );
    }
}