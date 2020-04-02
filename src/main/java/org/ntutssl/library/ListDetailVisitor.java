package org.ntutssl.library;

public class ListDetailVisitor implements Visitor 
{
    public ListDetailVisitor();

    @Override
    public void visitBook( Book book );

    @Override
    public void visitCollection( Collection collection );

    @Override
    public String getResult();
}