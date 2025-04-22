

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayBagTest {


    @Test
    public void testsize() {

        ArrayBag<Integer> bag = new ArrayBag<>(3);

        bag.add(2);
        bag.add(3);

        int result = bag.size();

        assertEquals(2, result);
    }
    @Test
    public void testcontains(){
        ArrayBag<Integer> bag = new ArrayBag<>(3);

        bag.add(2);
        bag.add(3);

        boolean result = bag.contains(3);

        assertEquals(true , result);
    }


    @Test
    public void testmaxsize(){
        ArrayBag<Integer> bag = new ArrayBag<>(3);

        bag.add(2);
        bag.add(3);
        bag.add(5);

        assertThrows(IllegalArgumentException.class , () -> bag.add(66));
    }
}


