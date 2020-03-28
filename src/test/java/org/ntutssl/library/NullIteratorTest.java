package org.ntutssl.library;

import static org.junit.Assert.assertFalse;

import java.util.NoSuchElementException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class NullIteratorTest 
{
    private NullIterator _nullIterator;

    @Before
    public void setUp()
    {
        _nullIterator = new NullIterator();
    }

    @After
    public void tearDown()
    {
        /* Body intentionally empty */
    }

    @Test
    public void test_has_next_of_null_iterator_being_false()
    {
        assertFalse( _nullIterator.hasNext() );
    }

    @Test( expected = NoSuchElementException.class )
    public void test_next_being_called_on_null_iterator_throwing_exception()
    {
        _nullIterator.next();
    }
}