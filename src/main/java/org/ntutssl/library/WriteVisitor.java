package org.ntutssl.library;

public class WriteVisitor implements Visitor
{
    private String _jsonArrayItems;

    public WriteVisitor()
    {
        _jsonArrayItems = "";
    }

    @Override
    public void visitBook( Book book );

    @Override
    public void visitCollection( Collection collection );

    public String getResult()
    {
        return Definitions.OPENING_CURLY_BRACE + Definitions.END_LINE
            + Definitions.JSON_INDENT + Definitions.QUOTATION_MARK + Definitions.JSON_OBJECT_PROPERTY_NAME_ITEMS_LIST + Definitions.QUOTATION_MARK + Definitions.COLON + Definitions.SPACE + Definitions.OPENING_SQUARE_BRACKET + Definitions.END_LINE
            + _jsonArrayItems + Definitions.END_LINE
            + Definitions.JSON_INDENT + Definitions.CLOSING_SQUARE_BRACKET + Definitions.END_LINE
            + Definitions.CLOSING_CURLY_BRACE;
    }
}