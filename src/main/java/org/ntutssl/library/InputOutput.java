package org.ntutssl.library;

public class InputOutput {
    public InputOutput();

    public void printLibraryInstructions();

    void handleLibraryInstructions(String instruction, Library library);

    Item addBookInstructions();

    Item addCollectionInstructions();

    public void printCollectionInstructions();

    void handleCollectionInstructions(String instruction, Collection collection);
    
    void listBooksInfo(Library library);
    
    void listBooksInfoDetail(Library library);

}
