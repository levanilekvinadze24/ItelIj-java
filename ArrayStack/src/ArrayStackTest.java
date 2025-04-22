import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayStackTest {


    @Test
    public void testpop(){

        ArrayStack<Integer> stack = new ArrayStack<>(2);

        stack.push(2);
        stack.push(4);
        stack.pop();

        int result = stack.pop();

        assertEquals(2,result);

    }
}