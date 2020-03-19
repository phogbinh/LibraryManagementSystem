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

    public Item getItem( int index )
    {
        if ( index < 0 || _items.size() <= index )
        {
            throw new IllegalArgumentException( Definitions.ERROR_INDEX_IS_OUT_OF_RANGE );
        }
        return _items.get( index );
    }
}
