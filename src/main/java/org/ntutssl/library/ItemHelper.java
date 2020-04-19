package org.ntutssl.library;

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

    public static String getString( Item item, int initialIndentsCount )
    {
        if ( item instanceof Book )
        {
            return getIndents( initialIndentsCount )     + BOOK_NAME        + item.name()        + Definitions.END_LINE
                 + getIndents( initialIndentsCount + 1 ) + BOOK_AUTHOR      + item.author()      + Definitions.END_LINE
                 + getIndents( initialIndentsCount + 1 ) + BOOK_DESCRIPTION + item.description() + Definitions.END_LINE
                 + getIndents( initialIndentsCount + 1 ) + BOOK_ISBN        + item.isbn()        + Definitions.END_LINE;
        }
        else if ( item instanceof Collection )
        {
            return getIndents( initialIndentsCount )     + COLLECTION_NAME        + item.name()        + Definitions.END_LINE
                 + getIndents( initialIndentsCount + 1 ) + COLLECTION_DESCRIPTION + item.description() + Definitions.END_LINE;
        }
        else
        {
            throw new IllegalStateException( ERROR_ITEM_IS_OF_INVALID_TYPE );
        }
    }

    private static String getIndents( int indentsCount )
    {
        String indents = "";
        for ( int index = 0; index < indentsCount; index++ )
        {
            indents += Definitions.INDENT;
        }
        return indents;
    }
}