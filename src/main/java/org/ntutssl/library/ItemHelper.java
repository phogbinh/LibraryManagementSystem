package org.ntutssl.library;

import java.util.Iterator;

public final class ItemHelper
{
    public static String BOOK_NAME = "Book Name" + Definitions.COLON + Definitions.SPACE;
    public static String BOOK_AUTHOR = "Author" + Definitions.COLON + Definitions.SPACE;
    public static String BOOK_DESCRIPTION = "Description" + Definitions.COLON + Definitions.SPACE;
    public static String BOOK_ISBN = "ISBN" + Definitions.COLON + Definitions.SPACE;
    public static String COLLECTION_NAME = "Collection Name" + Definitions.COLON + Definitions.SPACE;
    public static String COLLECTION_DESCRIPTION = "Description" + Definitions.COLON + Definitions.SPACE;
    public static String ERROR_ITEM_IS_OF_INVALID_TYPE = "The given item is of invalid type";

    private ItemHelper()
    {
        /* Body intentionally empty */
    }

    public static String getIndents( int indentsCount, String indent )
    {
        String indents = "";
        for ( int index = 0; index < indentsCount; index++ )
        {
            indents += indent;
        }
        return indents;
    }
}