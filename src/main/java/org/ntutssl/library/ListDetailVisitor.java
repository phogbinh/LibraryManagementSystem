package org.ntutssl.library;

public class ListDetailVisitor implements Visitor 
{
    public static String BOOK_NAME = "Book Name" + Definitions.COLON + Definitions.SPACE;
    public static String BOOK_AUTHOR = "Author" + Definitions.COLON + Definitions.SPACE;
    public static String BOOK_DESCRIPTION = "Description" + Definitions.COLON + Definitions.SPACE;
    public static String BOOK_ISBN = "ISBN" + Definitions.COLON + Definitions.SPACE;
    public static String COLLECTION_NAME = "Collection Name" + Definitions.COLON + Definitions.SPACE;
    public static String COLLECTION_DESCRIPTION = "Description" + Definitions.COLON + Definitions.SPACE;
    private String _itemInfo;

    public ListDetailVisitor()
    {
        /* Body intentionally empty */
    }

    @Override
    public void visitBook( Book book )
    {
        _itemInfo = BOOK_NAME + book.name() + Definitions.END_LINE
            + Definitions.INDENT + BOOK_AUTHOR + book.author() + Definitions.END_LINE
            + Definitions.INDENT + BOOK_DESCRIPTION + book.description() + Definitions.END_LINE
            + Definitions.INDENT + BOOK_ISBN + book.isbn() + Definitions.END_LINE;
    }

    @Override
    public void visitCollection( Collection collection )
    {
        _itemInfo = COLLECTION_NAME + collection.name() + Definitions.END_LINE
            + Definitions.INDENT + COLLECTION_DESCRIPTION + collection.description() + Definitions.END_LINE;
    }

    @Override
    public String getResult()
    {
        return _itemInfo;
    }
}