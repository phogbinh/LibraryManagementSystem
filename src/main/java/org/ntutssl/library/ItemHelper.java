package org.ntutssl.library;

public final class ItemHelper
{
    public static String BOOK_NAME = "Book Name" + Definitions.COLON + Definitions.SPACE;
    public static String BOOK_AUTHOR = Definitions.INDENT + "Author" + Definitions.COLON + Definitions.SPACE;
    public static String BOOK_DESCRIPTION = Definitions.INDENT + "Description" + Definitions.COLON + Definitions.SPACE;
    public static String BOOK_ISBN = Definitions.INDENT + "ISBN" + Definitions.COLON + Definitions.SPACE;
    public static String COLLECTION_NAME = "Collection Name" + Definitions.COLON + Definitions.SPACE;
    public static String COLLECTION_DESCRIPTION = Definitions.INDENT + "Description" + Definitions.COLON + Definitions.SPACE;
    public static String ERROR_ITEM_IS_OF_INVALID_TYPE = "The given item is of invalid type";
    
    private ItemHelper()
    {
        /* Body intentionally empty */
    }

    public static String getString( Item item )
    {
        if ( item instanceof Book )
        {
            return BOOK_NAME + item.name() + Definitions.END_LINE
                + Definitions.INDENT + BOOK_AUTHOR + item.author() + Definitions.END_LINE
                + Definitions.INDENT + BOOK_DESCRIPTION + item.description() + Definitions.END_LINE
                + Definitions.INDENT + BOOK_ISBN + item.isbn() + Definitions.END_LINE;
        }
        else if ( item instanceof Collection )
        {
            return COLLECTION_NAME + item.name() + Definitions.END_LINE
                + Definitions.INDENT + COLLECTION_DESCRIPTION + item.description() + Definitions.END_LINE;
        }
        else
        {
            throw new IllegalStateException( ERROR_ITEM_IS_OF_INVALID_TYPE );
        }
    }
}