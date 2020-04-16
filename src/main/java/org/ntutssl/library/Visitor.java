package org.ntutssl.library;

public interface Visitor
{
    public void visitBook( Book book );
    public void visitCollection( Collection collection );
}