package org.ntutssl.library;

import java.util.ArrayList;
import java.util.Iterator;

public class FindVisitorByName implements Visitor 
{
    private ArrayList< Item > _items;
    private String _itemName;

    public FindVisitorByName( String itemName )
    {
        _items = new ArrayList< Item >();
        _itemName = itemName;
    }

    @Override
    public void visitBook( Book book )
    {
        if ( _itemName.equals( book.name() ) )
        {
            _items.add( book );
        }
    }

    @Override
    public void visitCollection( Collection collection )
    {
        if ( _itemName.equals( collection.name() ) )
        {
            _items.add( collection );
        }
        Iterator< Item > iterator = collection.iterator();
        while ( iterator.hasNext() )
        {
            iterator.next().accept( this );
        }
    }

    public String getResult()
    {
        String result = "";
        for ( Item item : _items )
        {
            result += getString( item );
        }
        return result;
    }

    private String getString( Item item )
    {
        if ( item instanceof Book )
        {
            return                 Definitions.BOOK_NAME        + item.name()        + Definitions.END_LINE
            + Definitions.INDENT + Definitions.BOOK_AUTHOR      + item.author()      + Definitions.END_LINE
            + Definitions.INDENT + Definitions.BOOK_DESCRIPTION + item.description() + Definitions.END_LINE
            + Definitions.INDENT + Definitions.BOOK_ISBN        + item.isbn()        + Definitions.END_LINE;
        }
        else if ( item instanceof Collection )
        {
            return                 Definitions.COLLECTION_NAME        + item.name()        + Definitions.END_LINE
            + Definitions.INDENT + Definitions.COLLECTION_DESCRIPTION + item.description() + Definitions.END_LINE;
        }
        else
        {
            throw new IllegalStateException( Definitions.ERROR_ITEM_IS_OF_INVALID_TYPE );
        }
    }
}