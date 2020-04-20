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

    public static String getJsonObject( Item item, int initialJsonIndentsCount )
    {
        if ( item instanceof Book )
        {
            return getIndents( initialJsonIndentsCount, Definitions.JSON_INDENT ) + Definitions.OPENING_CURLY_BRACE + Definitions.END_LINE
                 + getIndents( initialJsonIndentsCount + 1, Definitions.JSON_INDENT ) + Definitions.QUOTATION_MARK + Definitions.JSON_OBJECT_PROPERTY_NAME_TYPE        + Definitions.QUOTATION_MARK + Definitions.COLON + Definitions.SPACE + Definitions.QUOTATION_MARK + Definitions.JSON_OBJECT_TYPE_PROPERTY_VALUE_BOOK + Definitions.QUOTATION_MARK + Definitions.COMMA + Definitions.END_LINE
                 + getIndents( initialJsonIndentsCount + 1, Definitions.JSON_INDENT ) + Definitions.QUOTATION_MARK + Definitions.JSON_OBJECT_PROPERTY_NAME_NAME        + Definitions.QUOTATION_MARK + Definitions.COLON + Definitions.SPACE + Definitions.QUOTATION_MARK + item.name()                                      + Definitions.QUOTATION_MARK + Definitions.COMMA + Definitions.END_LINE
                 + getIndents( initialJsonIndentsCount + 1, Definitions.JSON_INDENT ) + Definitions.QUOTATION_MARK + Definitions.JSON_OBJECT_PROPERTY_NAME_DESCRIPTION + Definitions.QUOTATION_MARK + Definitions.COLON + Definitions.SPACE + Definitions.QUOTATION_MARK + item.description()                               + Definitions.QUOTATION_MARK + Definitions.COMMA + Definitions.END_LINE
                 + getIndents( initialJsonIndentsCount + 1, Definitions.JSON_INDENT ) + Definitions.QUOTATION_MARK + Definitions.JSON_OBJECT_PROPERTY_NAME_AUTHOR      + Definitions.QUOTATION_MARK + Definitions.COLON + Definitions.SPACE + Definitions.QUOTATION_MARK + item.author()                                    + Definitions.QUOTATION_MARK + Definitions.COMMA + Definitions.END_LINE
                 + getIndents( initialJsonIndentsCount + 1, Definitions.JSON_INDENT ) + Definitions.QUOTATION_MARK + Definitions.JSON_OBJECT_PROPERTY_NAME_ISBN        + Definitions.QUOTATION_MARK + Definitions.COLON + Definitions.SPACE + Definitions.QUOTATION_MARK + item.isbn()                                      + Definitions.QUOTATION_MARK + Definitions.END_LINE
                 + getIndents( initialJsonIndentsCount, Definitions.JSON_INDENT ) + Definitions.CLOSING_CURLY_BRACE;
        }
        else if ( item instanceof Collection )
        {
            String collectionJsonObject = getIndents( initialJsonIndentsCount, Definitions.JSON_INDENT ) + Definitions.OPENING_CURLY_BRACE + Definitions.END_LINE
                + getIndents( initialJsonIndentsCount + 1, Definitions.JSON_INDENT ) + Definitions.QUOTATION_MARK + Definitions.JSON_OBJECT_PROPERTY_NAME_TYPE        + Definitions.QUOTATION_MARK + Definitions.COLON + Definitions.SPACE + Definitions.QUOTATION_MARK + Definitions.JSON_OBJECT_TYPE_PROPERTY_VALUE_COLLECTION + Definitions.QUOTATION_MARK + Definitions.COMMA + Definitions.END_LINE
                + getIndents( initialJsonIndentsCount + 1, Definitions.JSON_INDENT ) + Definitions.QUOTATION_MARK + Definitions.JSON_OBJECT_PROPERTY_NAME_NAME        + Definitions.QUOTATION_MARK + Definitions.COLON + Definitions.SPACE + Definitions.QUOTATION_MARK + item.name()                                            + Definitions.QUOTATION_MARK + Definitions.COMMA + Definitions.END_LINE
                + getIndents( initialJsonIndentsCount + 1, Definitions.JSON_INDENT ) + Definitions.QUOTATION_MARK + Definitions.JSON_OBJECT_PROPERTY_NAME_DESCRIPTION + Definitions.QUOTATION_MARK + Definitions.COLON + Definitions.SPACE + Definitions.QUOTATION_MARK + item.description()                                     + Definitions.QUOTATION_MARK + Definitions.COMMA + Definitions.END_LINE
                + getIndents( initialJsonIndentsCount + 1, Definitions.JSON_INDENT ) + Definitions.QUOTATION_MARK + Definitions.JSON_OBJECT_PROPERTY_NAME_ITEMS       + Definitions.QUOTATION_MARK + Definitions.COLON + Definitions.SPACE + Definitions.OPENING_SQUARE_BRACKET + Definitions.END_LINE;
            Iterator< Item > iterator = item.iterator();
            while ( iterator.hasNext() )
            {
                collectionJsonObject += getJsonObject( iterator.next(), initialJsonIndentsCount + 2 );
                if ( iterator.hasNext() )
                {
                    collectionJsonObject += Definitions.COMMA;
                }
                collectionJsonObject += Definitions.END_LINE;
            }
            collectionJsonObject += getIndents( initialJsonIndentsCount + 1, Definitions.JSON_INDENT ) + Definitions.CLOSING_SQUARE_BRACKET + Definitions.END_LINE
                + getIndents( initialJsonIndentsCount, Definitions.JSON_INDENT ) + Definitions.CLOSING_CURLY_BRACE;
            return collectionJsonObject;
        }
        else
        {
            throw new IllegalStateException( ERROR_ITEM_IS_OF_INVALID_TYPE );
        }
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