package org.ntutssl.library;

public class Book extends Readable
{
    public Book (String name, String description, String author, String isbn);
    
    public String name();

    public String description();

    public String author();

    public String isbn();
}
