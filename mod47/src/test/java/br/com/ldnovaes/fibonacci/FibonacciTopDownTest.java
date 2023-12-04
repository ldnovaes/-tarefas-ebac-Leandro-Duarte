package br.com.ldnovaes.fibonacci;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 *
 * @author ldnovaes
 */
public class FibonacciTopDownTest {
    
    @Test
    public void testTopDown() {
        
        FibonacciTopDown fib = new FibonacciTopDown();
        
        int posFib = fib.topDown(2);
        Assertions.assertEquals(1, posFib);
        
        posFib = fib.topDown(10);
        Assertions.assertEquals(55, posFib);
        
        posFib = fib.topDown(15);
        Assertions.assertEquals(610, posFib);

    }
    
}
