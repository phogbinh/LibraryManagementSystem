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

    public static String getJsonObject( Item item, int initialJsonIndentsCount )
    {
        if ( item instanceof Book )
        {
            return getJsonIndents( initialJsonIndentsCount ) + Definitions.OPENING_CURLY_BRACE + Definitions.END_LINE
                 + getJsonIndents( initialJsonIndentsCount + 1 ) + Definitions.QUOTATION_MARK + Definitions.JSON_OBJECT_PROPERTY_NAME_TYPE        + Definitions.QUOTATION_MARK + Definitions.COLON + Definitions.SPACE + Definitions.QUOTATION_MARK + Definitions.JSON_OBJECT_TYPE_PROPERTY_VALUE_BOOK + Definitions.QUOTATION_MARK + Definitions.COMMA + Definitions.END_LINE
                 + getJsonIndents( initialJsonIndentsCount + 1 ) + Definitions.QUOTATION_MARK + Definitions.JSON_OBJECT_PROPERTY_NAME_NAME        + Definitions.QUOTATION_MARK + Definitions.COLON + Definitions.SPACE + Definitions.QUOTATION_MARK + item.name()                                      + Definitions.QUOTATION_MARK + Definitions.COMMA + Definitions.END_LINE
                 + getJsonIndents( initialJsonIndentsCount + 1 ) + Definitions.QUOTATION_MARK + Definitions.JSON_OBJECT_PROPERTY_NAME_DESCRIPTION + Definitions.QUOTATION_MARK + Definitions.COLON + Definitions.SPACE + Definitions.QUOTATION_MARK + item.description()                               + Definitions.QUOTATION_MARK + Definitions.COMMA + Definitions.END_LINE
                 + getJsonIndents( initialJsonIndentsCount + 1 ) + Definitions.QUOTATION_MARK + Definitions.JSON_OBJECT_PROPERTY_NAME_AUTHOR      + Definitions.QUOTATION_MARK + Definitions.COLON + Definitions.SPACE + Definitions.QUOTATION_MARK + item.author()                                    + Definitions.QUOTATION_MARK + Definitions.COMMA + Definitions.END_LINE
                 + getJsonIndents( initialJsonIndentsCount + 1 ) + Definitions.QUOTATION_MARK + Definitions.JSON_OBJECT_PROPERTY_NAME_ISBN        + Definitions.QUOTATION_MARK + Definitions.COLON + Definitions.SPACE + Definitions.QUOTATION_MARK + item.isbn()                                      + Definitions.QUOTATION_MARK + Definitions.END_LINE
                 + getJsonIndents( initialJsonIndentsCount ) + Definitions.CLOSING_CURLY_BRACE;
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

    private static String getJsonIndents( int jsonIndentsCount )
    {
        String jsonIndents = "";
        for ( int index = 0; index < jsonIndentsCount; index++ )
        {
            jsonIndents += Definitions.JSON_INDENT;
        }
        return jsonIndents;
    }
}