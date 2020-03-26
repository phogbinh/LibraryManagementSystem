package org.ntutssl.library;

public class InputOutput
{
    public InputOutput();

    public void printLibraryInstructions();

    public void handleLibraryInstructions( String instruction, Library library );

    public Item addBookInstructions();

    public Item addCollectionInstructions();

    public void printCollectionInstructions();

    public void handleCollectionInstructions( String instruction, Collection collection );
    
    public void listBooksInfo( Library library );
    
    public void listBooksInfoDetail( Library library );
}