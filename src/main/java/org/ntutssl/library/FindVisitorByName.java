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
            result += ItemHelper.getString( item, 0 );
        }
        return result;
    }
}