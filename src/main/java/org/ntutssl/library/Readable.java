package org.ntutssl.library;

public abstract class Readable implements Item 
{
    private final String ERROR_ADD_IS_CALLED_ON_A_BOOK_OBJECT = "The function `add()` is called on a book object";
    private final String ERROR_ISBN_IS_CALLED_ON_A_COLLECTION_OBJECT = "The function `isbn()` is called on a collection object";
    private final String ERROR_AUTHOR_IS_CALLED_ON_A_COLLECTION_OBJECT = "The function `author()` is called on a collection object";
    private final String ERROR_GET_ITEM_IS_CALLED_ON_A_BOOK_OBJECT = "The function `getItem( int )` is called on a book object";

    @Override
    public void add( Item item )
    {
        throw new IllegalStateException( ERROR_ADD_IS_CALLED_ON_A_BOOK_OBJECT );
    }

    @Override
    public String isbn()
    {
        throw new IllegalStateException( ERROR_ISBN_IS_CALLED_ON_A_COLLECTION_OBJECT );
    }

    @Override
    public String author()
    {
        throw new IllegalStateException( ERROR_AUTHOR_IS_CALLED_ON_A_COLLECTION_OBJECT );
    }

    @Override
    public Item getItem( int index )
    {
        throw new IllegalStateException( ERROR_GET_ITEM_IS_CALLED_ON_A_BOOK_OBJECT );
    }
}
