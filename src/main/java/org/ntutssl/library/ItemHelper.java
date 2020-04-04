package org.ntutssl.library;

public final class ItemHelper
{
    private ItemHelper()
    {
        /* Body intentionally empty */
    }

    public static String getString( Item item )
    {
        if ( item instanceof Book )
        {
            return InputOutput.BOOK_NAME + item.name() + Definitions.END_LINE
                + Definitions.INDENT + InputOutput.BOOK_AUTHOR + item.author() + Definitions.END_LINE
                + Definitions.INDENT + InputOutput.BOOK_DESCRIPTION + item.description() + Definitions.END_LINE
                + Definitions.INDENT + InputOutput.BOOK_ISBN + item.isbn() + Definitions.END_LINE;
        }
        else if ( item instanceof Collection )
        {
            return InputOutput.COLLECTION_NAME + item.name() + Definitions.END_LINE
                + Definitions.INDENT + InputOutput.COLLECTION_DESCRIPTION + item.description() + Definitions.END_LINE;
        }
        else
        {
            throw new IllegalStateException( InputOutput.ERROR_ITEM_IS_OF_INVALID_TYPE );
        }
    }
}