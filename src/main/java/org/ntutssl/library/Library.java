package org.ntutssl.library;

import java.util.ArrayList;

public class Library 
{
    ArrayList< Item > _items;

    public Library()
    {
        _items = new ArrayList< Item >();
    }

    public void add( Item item )
    {
        _items.add( item );
    }

    public int size();

    public Iterator< Item > iterator();
}
