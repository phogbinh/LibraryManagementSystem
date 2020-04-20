package org.ntutssl.library;

import java.util.Iterator;

public class WriteVisitor implements Visitor
{
    private final int INITIAL_JSON_INDENTS_COUNT = 2;
    private final int COLLECTION_TO_CHILDREN_JSON_INDENTS_COUNT = 2;
    private String _jsonArrayItems;
    private int _jsonIndentsCount;

    public WriteVisitor()
    {
        _jsonArrayItems = "";
        _jsonIndentsCount = INITIAL_JSON_INDENTS_COUNT;
    }

    @Override
    public void visitBook( Book book )
    {
        if ( _jsonIndentsCount == INITIAL_JSON_INDENTS_COUNT && !_jsonArrayItems.isEmpty() )
        {
            _jsonArrayItems += Definitions.COMMA + Definitions.END_LINE;
        }
        _jsonArrayItems += ItemHelper.getIndents( _jsonIndentsCount, Definitions.JSON_INDENT ) + Definitions.OPENING_CURLY_BRACE + Definitions.END_LINE
                         + ItemHelper.getIndents( _jsonIndentsCount + 1, Definitions.JSON_INDENT ) + Definitions.QUOTATION_MARK + Definitions.JSON_OBJECT_PROPERTY_NAME_TYPE        + Definitions.QUOTATION_MARK + Definitions.COLON + Definitions.SPACE + Definitions.QUOTATION_MARK + Definitions.JSON_OBJECT_TYPE_PROPERTY_VALUE_BOOK + Definitions.QUOTATION_MARK + Definitions.COMMA + Definitions.END_LINE
                         + ItemHelper.getIndents( _jsonIndentsCount + 1, Definitions.JSON_INDENT ) + Definitions.QUOTATION_MARK + Definitions.JSON_OBJECT_PROPERTY_NAME_NAME        + Definitions.QUOTATION_MARK + Definitions.COLON + Definitions.SPACE + Definitions.QUOTATION_MARK + book.name()                                      + Definitions.QUOTATION_MARK + Definitions.COMMA + Definitions.END_LINE
                         + ItemHelper.getIndents( _jsonIndentsCount + 1, Definitions.JSON_INDENT ) + Definitions.QUOTATION_MARK + Definitions.JSON_OBJECT_PROPERTY_NAME_DESCRIPTION + Definitions.QUOTATION_MARK + Definitions.COLON + Definitions.SPACE + Definitions.QUOTATION_MARK + book.description()                               + Definitions.QUOTATION_MARK + Definitions.COMMA + Definitions.END_LINE
                         + ItemHelper.getIndents( _jsonIndentsCount + 1, Definitions.JSON_INDENT ) + Definitions.QUOTATION_MARK + Definitions.JSON_OBJECT_PROPERTY_NAME_AUTHOR      + Definitions.QUOTATION_MARK + Definitions.COLON + Definitions.SPACE + Definitions.QUOTATION_MARK + book.author()                                    + Definitions.QUOTATION_MARK + Definitions.COMMA + Definitions.END_LINE
                         + ItemHelper.getIndents( _jsonIndentsCount + 1, Definitions.JSON_INDENT ) + Definitions.QUOTATION_MARK + Definitions.JSON_OBJECT_PROPERTY_NAME_ISBN        + Definitions.QUOTATION_MARK + Definitions.COLON + Definitions.SPACE + Definitions.QUOTATION_MARK + book.isbn()                                      + Definitions.QUOTATION_MARK + Definitions.END_LINE
                         + ItemHelper.getIndents( _jsonIndentsCount, Definitions.JSON_INDENT ) + Definitions.CLOSING_CURLY_BRACE;
    }

    @Override
    public void visitCollection( Collection collection )
    {
        if ( _jsonIndentsCount == INITIAL_JSON_INDENTS_COUNT && !_jsonArrayItems.isEmpty() )
        {
            _jsonArrayItems += Definitions.COMMA + Definitions.END_LINE;
        }
        _jsonArrayItems += ItemHelper.getIndents( _jsonIndentsCount, Definitions.JSON_INDENT ) + Definitions.OPENING_CURLY_BRACE + Definitions.END_LINE
                         + ItemHelper.getIndents( _jsonIndentsCount + 1, Definitions.JSON_INDENT ) + Definitions.QUOTATION_MARK + Definitions.JSON_OBJECT_PROPERTY_NAME_TYPE        + Definitions.QUOTATION_MARK + Definitions.COLON + Definitions.SPACE + Definitions.QUOTATION_MARK + Definitions.JSON_OBJECT_TYPE_PROPERTY_VALUE_COLLECTION + Definitions.QUOTATION_MARK + Definitions.COMMA + Definitions.END_LINE
                         + ItemHelper.getIndents( _jsonIndentsCount + 1, Definitions.JSON_INDENT ) + Definitions.QUOTATION_MARK + Definitions.JSON_OBJECT_PROPERTY_NAME_NAME        + Definitions.QUOTATION_MARK + Definitions.COLON + Definitions.SPACE + Definitions.QUOTATION_MARK + collection.name()                                      + Definitions.QUOTATION_MARK + Definitions.COMMA + Definitions.END_LINE
                         + ItemHelper.getIndents( _jsonIndentsCount + 1, Definitions.JSON_INDENT ) + Definitions.QUOTATION_MARK + Definitions.JSON_OBJECT_PROPERTY_NAME_DESCRIPTION + Definitions.QUOTATION_MARK + Definitions.COLON + Definitions.SPACE + Definitions.QUOTATION_MARK + collection.description()                               + Definitions.QUOTATION_MARK + Definitions.COMMA + Definitions.END_LINE
                         + ItemHelper.getIndents( _jsonIndentsCount + 1, Definitions.JSON_INDENT ) + Definitions.QUOTATION_MARK + Definitions.JSON_OBJECT_PROPERTY_NAME_ITEMS       + Definitions.QUOTATION_MARK + Definitions.COLON + Definitions.SPACE + Definitions.OPENING_SQUARE_BRACKET + Definitions.END_LINE;
        Iterator< Item > iterator = collection.iterator();
        _jsonIndentsCount += COLLECTION_TO_CHILDREN_JSON_INDENTS_COUNT;
        while ( iterator.hasNext() )
        {
            iterator.next().accept( this );
            if ( iterator.hasNext() )
            {
                _jsonArrayItems += Definitions.COMMA;
            }
            _jsonArrayItems += Definitions.END_LINE;
        }
        _jsonIndentsCount -= COLLECTION_TO_CHILDREN_JSON_INDENTS_COUNT;
        _jsonArrayItems += ItemHelper.getIndents( _jsonIndentsCount + 1, Definitions.JSON_INDENT ) + Definitions.CLOSING_SQUARE_BRACKET + Definitions.END_LINE
                         + ItemHelper.getIndents( _jsonIndentsCount, Definitions.JSON_INDENT ) + Definitions.CLOSING_CURLY_BRACE;
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