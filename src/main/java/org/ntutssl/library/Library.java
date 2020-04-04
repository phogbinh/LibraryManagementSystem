package org.ntutssl.library;

import java.util.Iterator;
import java.util.Vector;

public class Library 
{
    private Vector< Item > _items;

    public Library()
    {
        _items = new Vector< Item >();
    }

    public void add( Item item )
    {
        _items.add( item );
    }

    public int size()
    {
        int booksCount = 0;
        Iterator< Item > iterator = iterator();
        while ( iterator.hasNext() )
        {
            booksCount += iterator.next().size();
        }
        return booksCount;
    }

    public Iterator< Item > iterator()
    {
        return _items.iterator();
    }

    public String findByName( String itemName )
    {
        Visitor findingByNameVisitor = new FindVisitorByName( itemName );
        for ( Item item : _items )
        {
            item.accept( findingByNameVisitor );
        }
        return findingByNameVisitor.getResult();
    }
}
