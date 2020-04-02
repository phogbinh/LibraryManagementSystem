package org.ntutssl.library;

public class FindVisitorByName implements Visitor 
{
    public FindVisitorByName( String itemName );

    @Override
    public void visitBook( Book book );

    @Override
    public void visitCollection( Collection collection );

    @Override
    public String getResult();
}
