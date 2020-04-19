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
        _jsonArrayItems = ItemHelper.getJsonObject( book, INITIAL_JSON_INDENTS_COUNT );
    }

    @Override
    public void visitCollection( Collection collection )
    {
        _jsonArrayItems = ItemHelper.getJsonObject( collection, INITIAL_JSON_INDENTS_COUNT );
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