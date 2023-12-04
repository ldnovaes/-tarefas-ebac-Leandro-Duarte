package br.com.ldnovaes.fibonacci;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 *
 * @author ldnovaes
 */
public class FibonacciBottomUpTest {
    
    @Test
    public void testGetFibonacci() {
        FibonacciBottomUp fib = new FibonacciBottomUp();
        
        int posFib = fib.getFibonacci(2);
        Assertions.assertEquals(1, posFib);
        
        posFib = fib.getFibonacci(10);
        Assertions.assertEquals(55, posFib);
        
        posFib = fib.getFibonacci(15);
        Assertions.assertEquals(610, posFib);


        
        
    }
    
}
