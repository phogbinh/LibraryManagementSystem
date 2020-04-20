package org.ntutssl.library;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.Vector;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class Library 
{
    private Vector< Item > _items;

    public Library()
    {
        _items = new Vector< Item >();
    }

    public void add( Item item )
    {
        _items.add( item );
    }

    public int size()
    {
        int booksCount = 0;
        Iterator< Item > iterator = iterator();
        while ( iterator.hasNext() )
        {
            booksCount += iterator.next().size();
        }
        return booksCount;
    }

    public Iterator< Item > iterator()
    {
        return _items.iterator();
    }

    public String findByName( String itemName )
    {
        FindVisitorByName findingByNameVisitor = new FindVisitorByName( itemName );
        for ( Item item : _items )
        {
            item.accept( findingByNameVisitor );
        }
        return findingByNameVisitor.getResult();
    }

    public void importItems( String sourceFilePath )
    {
        ItemParser itemParser = new ItemParser();
        JsonObject[] items = getItems( sourceFilePath );
        for ( JsonObject item : items )
        {
            itemParser.parseItem( item.toString() );
            add( itemParser.getResult() );
        }
    }

    private JsonObject[] getItems( String sourceFilePath )
    {
        Gson googleJson = new Gson();
        JsonObject jsonObject = googleJson.fromJson( getContent( sourceFilePath ), JsonObject.class );
        String itemsListPropertyJsonArrayValue = jsonObject.get( Definitions.JSON_OBJECT_PROPERTY_NAME_ITEMS_LIST ).toString();
        return googleJson.fromJson( itemsListPropertyJsonArrayValue, JsonObject[].class );
    }

    private String getContent( String sourceFilePath )
    {
        try
        {
            return new String( Files.readAllBytes( Paths.get( sourceFilePath ) ) );
        } 
        catch ( IOException exception )
        {
            throw new RuntimeException( exception );
        }
    }

    public void exportItems( String destinationFilePath )
    {
        WriteVisitor writeVisitor = new WriteVisitor();
        Iterator< Item > iterator = iterator();
        while ( iterator.hasNext() )
        {
            iterator.next().accept( writeVisitor );
        }
        try
        {
            FileWriter fileWriter = new FileWriter( destinationFilePath );
            fileWriter.write( writeVisitor.getResult() );
            fileWriter.close();
        }
        catch ( IOException exception )
        {
            throw new RuntimeException( exception );
        }
    }
}