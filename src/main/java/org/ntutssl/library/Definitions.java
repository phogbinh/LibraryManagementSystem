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

    private Definitions()
    {
        /* Body intentionally empty */
    }
}