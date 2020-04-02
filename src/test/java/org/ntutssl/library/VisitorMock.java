package org.ntutssl.library;

public class VisitorMock implements Visitor
{
    public boolean IsCalledVisitBook;
    public boolean IsCalledVisitCollection;

    public VisitorMock()
    {
        IsCalledVisitBook = false;
        IsCalledVisitCollection = false;
    }

    @Override
    public void visitBook( Book book )
    {
        IsCalledVisitBook = true;
    }

    @Override
    public void visitCollection( Collection collection )
    {
        IsCalledVisitCollection = true;
    }

    @Override
    public String getResult()
    {
        return TestDefinitions.DUMP_STRING;
    }
}