package org.ntutssl.library;

public class WriteVisitor implements Visitor
{
    private final int INITIAL_JSON_INDENTS_COUNT = 2;
    private String _jsonArrayItems;

    public WriteVisitor()
    {
        _jsonArrayItems = "";
    }

    @Override
    public void visitBook( Book book )
    {
        if ( !_jsonArrayItems.isEmpty() )
        {
            _jsonArrayItems += Definitions.COMMA + Definitions.END_LINE;
        }
        _jsonArrayItems += ItemHelper.getIndents( INITIAL_JSON_INDENTS_COUNT, Definitions.JSON_INDENT ) + Definitions.OPENING_CURLY_BRACE + Definitions.END_LINE
                         + ItemHelper.getIndents( INITIAL_JSON_INDENTS_COUNT + 1, Definitions.JSON_INDENT ) + Definitions.QUOTATION_MARK + Definitions.JSON_OBJECT_PROPERTY_NAME_TYPE        + Definitions.QUOTATION_MARK + Definitions.COLON + Definitions.SPACE + Definitions.QUOTATION_MARK + Definitions.JSON_OBJECT_TYPE_PROPERTY_VALUE_BOOK + Definitions.QUOTATION_MARK + Definitions.COMMA + Definitions.END_LINE
                         + ItemHelper.getIndents( INITIAL_JSON_INDENTS_COUNT + 1, Definitions.JSON_INDENT ) + Definitions.QUOTATION_MARK + Definitions.JSON_OBJECT_PROPERTY_NAME_NAME        + Definitions.QUOTATION_MARK + Definitions.COLON + Definitions.SPACE + Definitions.QUOTATION_MARK + book.name()                                      + Definitions.QUOTATION_MARK + Definitions.COMMA + Definitions.END_LINE
                         + ItemHelper.getIndents( INITIAL_JSON_INDENTS_COUNT + 1, Definitions.JSON_INDENT ) + Definitions.QUOTATION_MARK + Definitions.JSON_OBJECT_PROPERTY_NAME_DESCRIPTION + Definitions.QUOTATION_MARK + Definitions.COLON + Definitions.SPACE + Definitions.QUOTATION_MARK + book.description()                               + Definitions.QUOTATION_MARK + Definitions.COMMA + Definitions.END_LINE
                         + ItemHelper.getIndents( INITIAL_JSON_INDENTS_COUNT + 1, Definitions.JSON_INDENT ) + Definitions.QUOTATION_MARK + Definitions.JSON_OBJECT_PROPERTY_NAME_AUTHOR      + Definitions.QUOTATION_MARK + Definitions.COLON + Definitions.SPACE + Definitions.QUOTATION_MARK + book.author()                                    + Definitions.QUOTATION_MARK + Definitions.COMMA + Definitions.END_LINE
                         + ItemHelper.getIndents( INITIAL_JSON_INDENTS_COUNT + 1, Definitions.JSON_INDENT ) + Definitions.QUOTATION_MARK + Definitions.JSON_OBJECT_PROPERTY_NAME_ISBN        + Definitions.QUOTATION_MARK + Definitions.COLON + Definitions.SPACE + Definitions.QUOTATION_MARK + book.isbn()                                      + Definitions.QUOTATION_MARK + Definitions.END_LINE
                         + ItemHelper.getIndents( INITIAL_JSON_INDENTS_COUNT, Definitions.JSON_INDENT ) + Definitions.CLOSING_CURLY_BRACE;
    }

    @Override
    public void visitCollection( Collection collection )
    {
        if ( !_jsonArrayItems.isEmpty() )
        {
            _jsonArrayItems += Definitions.COMMA + Definitions.END_LINE;
        }
        _jsonArrayItems += ItemHelper.getJsonObject( collection, INITIAL_JSON_INDENTS_COUNT );
    }

    public String getResult()
    {
        return Definitions.OPENING_CURLY_BRACE + Definitions.END_LINE
            + Definitions.JSON_INDENT + Definitions.QUOTATION_MARK + Definitions.JSON_OBJECT_PROPERTY_NAME_ITEMS_LIST + Definitions.QUOTATION_MARK + Definitions.COLON + Definitions.SPACE + Definitions.OPENING_SQUARE_BRACKET + Definitions.END_LINE
            + _jsonArrayItems + Definitions.END_LINE
            + Definitions.JSON_INDENT + Definitions.CLOSING_SQUARE_BRACKET + Definitions.END_LINE
            + Definitions.CLOSING_CURLY_BRACE;
    }
}