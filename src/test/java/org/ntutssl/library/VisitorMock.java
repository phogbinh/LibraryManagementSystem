package org.ntutssl.library;

public class VisitorMock implements Visitor
{
    public boolean IsCalledVisitBook;

    public VisitorMock()
    {
        IsCalledVisitBook = false;
    }

    @Override
    public void visitBook( Book book )
    {
        IsCalledVisitBook = true;
    }

    @Override
    public void visitCollection( Collection collection )
    {
        /* Body intentionally empty */
    }

    @Override
    public String getResult()
    {
        return TestDefinitions.DUMP_STRING;
    }
}