package org.ntutssl.library;

public class Collection extends Readable
{
    public Collection (String name, String description);

    public String name();

    public String description();

    public void add(Item item);

    public Item getItem(int index);
}
