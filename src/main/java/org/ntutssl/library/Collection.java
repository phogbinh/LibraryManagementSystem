package org.ntutssl.library;

import java.util.Iterator;
import java.util.Vector;

public class Collection extends Readable
{
    private String _name;
    private String _description;
    private Vector< Item > _items;

    public Collection( String name, String description )
    {
        _name = name;
        _description = description;
        _items = new Vector< Item >();
    }

    @Override
    public String name()
    {
        return _name;
    }

    @Override
    public String description()
    {
        return _description;
    }

    @Override
    public void add( Item item )
    {
        _items.add( item );
    }

    @Override
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

    @Override
    public Iterator< Item > iterator()
    {
        return _items.iterator();
    }

    @Override
    public void accept( Visitor visitor );
}
