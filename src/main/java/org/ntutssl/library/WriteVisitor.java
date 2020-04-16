package org.ntutssl.library;

public class WriteVisitor implements Visitor
{
    @Override
    public void visitBook( Book book );

    @Override
    public void visitCollection( Collection collection );

    public String getResult();
}