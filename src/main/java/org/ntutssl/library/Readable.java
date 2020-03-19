package org.ntutssl.library;

public abstract class Readable implements Item 
{
    public void add (Item items);

    public String isbn();

    public String author();

    public Item getItem(int index);
}
