import lab01.tdd.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {

    private CircularList cl;

    @BeforeEach
    public void beforeEach() {
        cl = new CircularListBasic();
    }

    @Test
    public void testAdd(){
        cl.add(0);
    }

    @Test
    public void testSize(){
        assertEquals(0,cl.size());
        cl.add(0);
        assertEquals(1,cl.size());
    }

    @Test
    public void testEmpty() {
        assertTrue(cl.isEmpty());
        cl.add(1);
        assertFalse(cl.isEmpty());
    }

    @Test
    public void testNext() {
        int elem = 10;
        assertEquals(Optional.empty(),cl.next());
        cl.add(elem);
        assertEquals(Optional.of(elem),cl.next());
        assertEquals(Optional.of(elem),cl.next());
    }

    @Test
    public void testPrevious() {
        int elem1 = 20;
        int elem2 = 21;
        assertEquals(Optional.empty(),cl.previous());
        cl.add(elem1);
        assertEquals(Optional.of(elem1),cl.previous());
        assertEquals(Optional.of(elem1),cl.previous());
        cl.add(elem2);
        assertEquals(Optional.of(elem2),cl.previous());
        assertEquals(Optional.of(elem1),cl.previous());
        assertEquals(Optional.of(elem2),cl.previous());
        assertEquals(Optional.of(elem1),cl.previous());
    }

    @Test
    public void testReset(){
        int elem1 = 30;
        int elem2 = 31;
        int elem3 = 32;
        int elem4 = 33;
        cl.add(elem1);
        cl.add(elem2);
        cl.add(elem3);
        cl.add(elem4);
        assertEquals(Optional.of(elem1),cl.next());
        assertEquals(Optional.of(elem2),cl.next());
        assertEquals(Optional.of(elem3),cl.next());
        cl.reset();
        assertEquals(Optional.of(elem1), cl.next());
    }

    @Test
    public void testNextWithStrategy(){
        int elem1 = 30;
        int elem2 = 31;
        int elem3 = 32;
        int elem4 = 33;
        cl.add(elem1);
        cl.add(elem2);
        cl.add(elem3);
        cl.add(elem4);
        //using strategy. aka implementations of interface SelectStrategy
        SelectStrategy stEven = new EvenStrategy();
        SelectStrategy stEquals = new EqualsStrategy(elem4);
        SelectStrategy stMultiple = new MultipleOfStrategy(3);
        assertEquals(Optional.of(elem1),cl.next(stEven));
        assertEquals(Optional.of(elem4),cl.next(stEquals));
        assertEquals(Optional.of(elem1),cl.next(stMultiple));
        assertEquals(Optional.of(elem4),cl.next(stMultiple));
        //using a factory
        SelectFactory factory = new SimpleFactory();
        assertEquals(Optional.of(elem1),cl.next(factory.createEvenStrategy()));
        assertEquals(Optional.of(elem2),cl.next(factory.createEqualsStrategy(elem2)));
        assertEquals(Optional.of(elem4),cl.next(factory.createMultipleOfStrategy(3)));
        //passing lambda instead of SelectStrategy implementations
        assertEquals(Optional.of(elem1),cl.next(element -> element % 2 == 0));
        assertEquals(Optional.of(elem2),cl.next(element -> element == elem2));
        assertEquals(Optional.of(elem4),cl.next(element -> element % 3 == 0));
    }
}
