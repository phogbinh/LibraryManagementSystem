package org.ntutssl.library;

public class ItemBuilder
{
    private Item _item;

    public ItemBuilder()
    {
        /* Body intentionally empty */
    }

    public void buildBook( String bookName, String bookDescription, String bookAuthor, String bookIsbn )
    {
        _item = new Book( bookName, bookDescription, bookAuthor, bookIsbn );
    }

    public Item getResult()
    {
        return _item;
    }
}