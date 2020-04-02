package org.ntutssl.library;

import java.util.Iterator;

public interface Item 
{
    public void add( Item item );
    public String name();
    public String description();
    public String isbn();
    public String author();
    public int size();
    public Iterator< Item > iterator();
    public void accept( Visitor visitor );
}
