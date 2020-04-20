package org.ntutssl.library;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DefinitionsTest
{
    @Test
    public void test_getting_3_indents()
    {
        assertEquals( Definitions.INDENT + Definitions.INDENT + Definitions.INDENT, Definitions.getIndents( 3, Definitions.INDENT ) );
    }

    @Test
    public void test_getting_2_json_indents()
    {
        assertEquals( Definitions.JSON_INDENT + Definitions.JSON_INDENT, Definitions.getIndents( 2, Definitions.JSON_INDENT ) );
    }
}