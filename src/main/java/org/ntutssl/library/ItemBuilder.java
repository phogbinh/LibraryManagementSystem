package org.ntutssl.library;

import java.util.Stack;

public class ItemBuilder
{
    private Item _item;
    private Stack< Collection > _collectionsStack;

    public ItemBuilder()
    {
        _collectionsStack = new Stack< Collection >();
    }

    public void buildBook( String bookName, String bookDescription, String bookAuthor, String bookIsbn )
    {
        Book book = new Book( bookName, bookDescription, bookAuthor, bookIsbn );
        if ( _collectionsStack.empty() )
        {
            _item = book;
        }
        else
        {
            _collectionsStack.peek().add( book );
        }
    }

    public void beginBuildingCollection( String collectionName, String collectionDescription )
    {
        _collectionsStack.push( new Collection( collectionName, collectionDescription ) );
    }

    public void endBuildingCollection()
    {
        Collection collection = _collectionsStack.pop();
        if ( _collectionsStack.empty() )
        {
            _item = collection;
        }
        else
        {
            _collectionsStack.peek().add( collection );
        }
    }

    public Item getResult()
    {
        return _item;
    }
}