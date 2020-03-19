package org.ntutssl.library;

public class Book extends Readable
{
    private String _name;
    private String _description;
    private String _author;
    private String _isbn;

    public Book( String name, String description, String author, String isbn )
    {
        _name = name;
        _description = description;
        _author = author;
        _isbn = isbn;
    }
    
    @Override
    public String name()
    {
        return _name;
    }

    @Override
    public String description()
    {
        return _description;
    }

    @Override
    public String author()
    {
        return _author;
    }

    @Override
    public String isbn()
    {
        return _isbn;
    }
}
