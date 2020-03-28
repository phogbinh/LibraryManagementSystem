package org.ntutssl.library;

import java.util.Scanner;

public class Main
{
    private static Scanner _scanner;

    public static void main( String[] arguments )
    {
        _scanner = new Scanner( System.in );
        ExecuteLibraryManagementSystem();
        _scanner.close();
    }

    public static void ExecuteLibraryManagementSystem()
    {
        Library library = new Library();
        InputOutput inputOutput = new InputOutput();
        inputOutput.printLibraryInstructions();
        inputOutput.handleLibraryInstructions( getInputString( Definitions.EMPTY ), library );
    }

    public static String getInputString( String instruction )
    {
        System.out.print( instruction );
        return _scanner.nextLine();
    }
}