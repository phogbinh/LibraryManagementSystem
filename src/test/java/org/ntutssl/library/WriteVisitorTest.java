package org.ntutssl.library;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Field;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class WriteVisitorTest
{
    private final String ERROR_JSON_ARRAY_ITEMS_CANNOT_BE_GOT = "The member variable JSON array items cannot be got";
    private final String MEMBER_VARIABLE_NAME_JSON_ARRAY_ITEMS = "_jsonArrayItems";
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
        _visitor = new WriteVisitor();
    }

    @After
    public void tearDown()
    {
        /* Body intentionally empty */
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