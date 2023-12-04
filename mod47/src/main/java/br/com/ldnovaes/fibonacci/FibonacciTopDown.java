
package br.com.ldnovaes.fibonacci;

/**
 *
 * @author ldnovaes
 */
public class FibonacciTopDown {
    
    private int[] arrayAuxiliarFibonnaci;
    
    public int topDown(int n) {
        
        arrayAuxiliarFibonnaci = new int[n + 1];
        
        for (int i = 0; i <= n; i++) {
            arrayAuxiliarFibonnaci[i] = -1; // inicializa as posições com -1
        }
        
        return fibonacciRecursivo(n);
    }
    
    public int fibonacciRecursivo(int n) {
        
        if (n < 2) {
            return n;
        }
        
        if (arrayAuxiliarFibonnaci[n] == -1) {
            arrayAuxiliarFibonnaci[n] = fibonacciRecursivo(n - 1) + fibonacciRecursivo(n - 2);
        } 
        
        return arrayAuxiliarFibonnaci[n];
     
        
    }
}
