package org.ntutssl.library;

import java.io.IOException;
import java.io.StringReader;
import java.util.NoSuchElementException;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;

public class ItemParser
{
    private final String ERROR_JSON_OBJECT_PROPERTY_NAME_IS_NOT = "The name of the property of the JSON object is not";
    private final String ERROR_ITEM_TYPE_IS_INVALID = "The item type is invalid";
    private JsonReader _jsonReader;
    private ItemBuilder _itemBuilder;

    public ItemParser()
    {
        _itemBuilder = new ItemBuilder();
    }

    public void parseItem( String itemJsonObject )
    {
        _jsonReader = new JsonReader( new StringReader( itemJsonObject ) );
        parseJsonObjectThenBuildItem();
    }

    private void parseJsonObjectThenBuildItem()
    {
        try
        {
            _jsonReader.beginObject();
            parseJsonObjectPropertiesThenBuildItem();
            _jsonReader.endObject();
        }
        catch ( IOException exception )
        {
            throw new IllegalStateException( exception );
        }
    }

    private void parseJsonObjectPropertiesThenBuildItem()
    {
        String itemType = nextJsonObjectPropertyStringValue( Definitions.JSON_OBJECT_PROPERTY_NAME_TYPE );
        if ( itemType.equals( Definitions.JSON_OBJECT_TYPE_PROPERTY_VALUE_BOOK ) )
        {
            parseJsonObjectPropertiesThenBuildBook();
        }
        else if ( itemType.equals( Definitions.JSON_OBJECT_TYPE_PROPERTY_VALUE_COLLECTION ) )
        {
            parseJsonObjectPropertiesThenBuildCollection();
        }
        else
        {
            throw new NoSuchElementException( ERROR_ITEM_TYPE_IS_INVALID );
        }
    }

    private void parseJsonObjectPropertiesThenBuildBook()
    {
        String bookName        = nextJsonObjectPropertyStringValue( Definitions.JSON_OBJECT_PROPERTY_NAME_NAME );
        String bookDescription = nextJsonObjectPropertyStringValue( Definitions.JSON_OBJECT_PROPERTY_NAME_DESCRIPTION );
        String bookAuthor      = nextJsonObjectPropertyStringValue( Definitions.JSON_OBJECT_PROPERTY_NAME_AUTHOR );
        String bookIsbn        = nextJsonObjectPropertyStringValue( Definitions.JSON_OBJECT_PROPERTY_NAME_ISBN );
        _itemBuilder.buildBook( bookName, bookDescription, bookAuthor, bookIsbn );
    }

    private void parseJsonObjectPropertiesThenBuildCollection()
    {
        String collectionName        = nextJsonObjectPropertyStringValue( Definitions.JSON_OBJECT_PROPERTY_NAME_NAME );
        String collectionDescription = nextJsonObjectPropertyStringValue( Definitions.JSON_OBJECT_PROPERTY_NAME_DESCRIPTION );
        _itemBuilder.beginBuildingCollection( collectionName, collectionDescription );
        try
        {
            if ( !_jsonReader.nextName().equals( Definitions.JSON_OBJECT_PROPERTY_NAME_ITEMS ) )
            {
                throw new IllegalStateException( ERROR_JSON_OBJECT_PROPERTY_NAME_IS_NOT + Definitions.SPACE + Definitions.JSON_OBJECT_PROPERTY_NAME_ITEMS );
            }
            _jsonReader.beginArray();
            while ( !_jsonReader.peek().equals( JsonToken.END_ARRAY ) )
            {
                parseJsonObjectThenBuildItem();
            }
            _jsonReader.endArray();
        }
        catch ( IOException exception )
        {
            throw new IllegalStateException( exception );
        }
        _itemBuilder.endBuildingCollection();
    }

    private String nextJsonObjectPropertyStringValue( String jsonObjectPropertyName )
    {
        try
        {
            if ( !_jsonReader.nextName().equals( jsonObjectPropertyName ) )
            {
                throw new IllegalStateException( ERROR_JSON_OBJECT_PROPERTY_NAME_IS_NOT + Definitions.SPACE + jsonObjectPropertyName );
            }
            return _jsonReader.nextString();
        }
        catch ( IOException exception )
        {
            throw new IllegalStateException( exception );
        }
    }

    public Item getResult()
    {
        return _itemBuilder.getResult();
    }
}