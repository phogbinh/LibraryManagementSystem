package org.ntutssl.library;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class NullIterator implements Iterator<Item>
{
    private final String ERROR_NEXT_IS_CALLED_ON_A_NULL_ITERATOR_OBJECT = "The function `next()` is called on a null iterator object";

    @Override
    public boolean hasNext()
    {
        return false;
    }

    @Override
    public Item next()
    {
        throw new NoSuchElementException( ERROR_NEXT_IS_CALLED_ON_A_NULL_ITERATOR_OBJECT );
    }
}