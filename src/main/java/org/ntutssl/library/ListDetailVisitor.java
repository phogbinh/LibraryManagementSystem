package org.ntutssl.library;

import java.util.Iterator;

public class ListDetailVisitor implements Visitor 
{
    public static String BOOK_NAME = "Book Name" + Definitions.COLON + Definitions.SPACE;
    public static String BOOK_AUTHOR = "Author" + Definitions.COLON + Definitions.SPACE;
    public static String BOOK_DESCRIPTION = "Description" + Definitions.COLON + Definitions.SPACE;
    public static String BOOK_ISBN = "ISBN" + Definitions.COLON + Definitions.SPACE;
    public static String COLLECTION_NAME = "Collection Name" + Definitions.COLON + Definitions.SPACE;
    public static String COLLECTION_DESCRIPTION = "Description" + Definitions.COLON + Definitions.SPACE;
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
        indentItemInfo( 1 );
        _itemInfo += BOOK_NAME + book.name() + Definitions.END_LINE;
        indentItemInfo( 0 );
        _itemInfo += BOOK_AUTHOR + book.author() + Definitions.END_LINE;
        indentItemInfo( 0 );
        _itemInfo += BOOK_DESCRIPTION + book.description() + Definitions.END_LINE;
        indentItemInfo( 0 );
        _itemInfo += BOOK_ISBN + book.isbn() + Definitions.END_LINE;
        _level--;
    }

    @Override
    public void visitCollection( Collection collection )
    {
        indentItemInfo( 1 );
        _itemInfo += COLLECTION_NAME + collection.name() + Definitions.END_LINE;
        indentItemInfo( 0 );
        _itemInfo += COLLECTION_DESCRIPTION + collection.description() + Definitions.END_LINE;
        Iterator< Item > iterator = collection.iterator();
        _level++;
        while ( iterator.hasNext() )
        {
            iterator.next().accept( this );
        }
        _level--;
    }

    private void indentItemInfo( int startingIndentsCount )
    {
        for ( int indentsCount = startingIndentsCount; indentsCount <= _level; indentsCount++ )
        {
            _itemInfo += Definitions.INDENT;
        }
    }

    @Override
    public String getResult()
    {
        return _itemInfo;
    }
}