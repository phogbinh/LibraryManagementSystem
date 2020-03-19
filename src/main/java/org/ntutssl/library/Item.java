package org.ntutssl.library;

public interface Item 
{
    public void add( Item item );
    public String name();
    public String description();
    public String isbn();
    public String author();
    public Item getItem( int index );
}
