package org.ntutssl.library;

import java.util.Iterator;

public class ListDetailVisitor implements Visitor 
{
    private String _itemInfo;
    private int _level;

    public ListDetailVisitor()
    {
        _itemInfo = "";
        _level = 0;
    }

    @Override
    public void visitBook( Book book )
    {
        _itemInfo += ItemHelper.getString( book, _level );
    }

    @Override
    public void visitCollection( Collection collection )
    {
        _itemInfo += ItemHelper.getString( collection, _level );
        Iterator< Item > iterator = collection.iterator();
        _level++;
        while ( iterator.hasNext() )
        {
            iterator.next().accept( this );
        }
        _level--;
    }

    @Override
    public String getResult()
    {
        return _itemInfo;
    }
}