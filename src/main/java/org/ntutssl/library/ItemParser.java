package org.ntutssl.library;

public class ItemParser
{
    private ItemBuilder _itemBuilder;

    public ItemParser()
    {
        _itemBuilder = new ItemBuilder();
    }

    public void parseItem( String itemInJsonFormat );

    public Item getResult()
    {
        return _itemBuilder.getResult();
    }
}