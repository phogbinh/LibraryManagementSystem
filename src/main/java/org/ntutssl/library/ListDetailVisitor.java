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
        _itemInfo += Definitions.getIndents( _level, Definitions.INDENT )     + Definitions.BOOK_NAME        + book.name()        + Definitions.END_LINE
                   + Definitions.getIndents( _level + 1, Definitions.INDENT ) + Definitions.BOOK_AUTHOR      + book.author()      + Definitions.END_LINE
                   + Definitions.getIndents( _level + 1, Definitions.INDENT ) + Definitions.BOOK_DESCRIPTION + book.description() + Definitions.END_LINE
                   + Definitions.getIndents( _level + 1, Definitions.INDENT ) + Definitions.BOOK_ISBN        + book.isbn()        + Definitions.END_LINE;
    }

    @Override
    public void visitCollection( Collection collection )
    {
        _itemInfo += Definitions.getIndents( _level, Definitions.INDENT )     + Definitions.COLLECTION_NAME        + collection.name()        + Definitions.END_LINE
                   + Definitions.getIndents( _level + 1, Definitions.INDENT ) + Definitions.COLLECTION_DESCRIPTION + collection.description() + Definitions.END_LINE;
        Iterator< Item > iterator = collection.iterator();
        _level++;
        while ( iterator.hasNext() )
        {
            iterator.next().accept( this );
        }
        _level--;
    }

    public String getResult()
    {
        return _itemInfo;
    }
}