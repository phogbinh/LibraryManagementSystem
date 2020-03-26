package org.ntutssl.library;

import java.util.Vector;

public class Library 
{
    Vector< Item > _items;

    public Library()
    {
        _items = new Vector< Item >();
    }

    public void add( Item item )
    {
        _items.add( item );
    }

    public int size();

    public Iterator< Item > iterator();
}
