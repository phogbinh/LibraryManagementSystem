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
    public int size();

    @Override
    public Iterator< Item > iterator();
}
