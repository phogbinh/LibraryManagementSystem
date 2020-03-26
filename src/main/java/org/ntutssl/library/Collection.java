package org.ntutssl.library;

import java.util.ArrayList;

public class Collection extends Readable
{
    private String _name;
    private String _description;
    private ArrayList< Item > _items;

    public Collection( String name, String description )
    {
        _name = name;
        _description = description;
        _items = new ArrayList< Item >();
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

    public int size();

    public Iterator< Item > iterator();
}
