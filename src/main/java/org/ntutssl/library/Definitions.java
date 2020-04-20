package org.ntutssl.library;

public final class Definitions
{
    public static String CLOSING_CURLY_BRACE = "}";
    public static String CLOSING_SQUARE_BRACKET = "]";
    public static String COLON = ":";
    public static String COMMA = ",";
    public static String EMPTY = "";
    public static String END_LINE = "\n";
    public static String INDENT = "\t";
    public static String OPENING_CURLY_BRACE = "{";
    public static String OPENING_SQUARE_BRACKET = "[";
    public static String QUOTATION_MARK = "\"";
    public static String SPACE = " ";

    public static String JSON_INDENT = SPACE + SPACE;

    public static String JSON_OBJECT_PROPERTY_NAME_TYPE        = "type";
    public static String JSON_OBJECT_PROPERTY_NAME_NAME        = "name";
    public static String JSON_OBJECT_PROPERTY_NAME_DESCRIPTION = "description";
    public static String JSON_OBJECT_PROPERTY_NAME_AUTHOR      = "author";
    public static String JSON_OBJECT_PROPERTY_NAME_ISBN        = "isbn";
    public static String JSON_OBJECT_PROPERTY_NAME_ITEMS       = "items";
    public static String JSON_OBJECT_PROPERTY_NAME_ITEMS_LIST  = "itemlist";

    public static String JSON_OBJECT_TYPE_PROPERTY_VALUE_BOOK       = "book";
    public static String JSON_OBJECT_TYPE_PROPERTY_VALUE_COLLECTION = "collection";

    public static String REGEX_NON_PRINTABLE_UNICODE_CHARACTERS = "\\p{C}";

    public static String BOOK_NAME              = "Book Name"       + Definitions.COLON + Definitions.SPACE;
    public static String BOOK_AUTHOR            = "Author"          + Definitions.COLON + Definitions.SPACE;
    public static String BOOK_DESCRIPTION       = "Description"     + Definitions.COLON + Definitions.SPACE;
    public static String BOOK_ISBN              = "ISBN"            + Definitions.COLON + Definitions.SPACE;
    public static String COLLECTION_NAME        = "Collection Name" + Definitions.COLON + Definitions.SPACE;
    public static String COLLECTION_DESCRIPTION = "Description"     + Definitions.COLON + Definitions.SPACE;

    private Definitions()
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