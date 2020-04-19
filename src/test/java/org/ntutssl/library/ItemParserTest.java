package org.ntutssl.library;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Field;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ItemParserTest
{
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
    public void test_getting_result_returning_item_builder_result()
    {
        assertSame( getItemBuilder().getResult(), _itemParser.getResult() );
    }
}