
package br.com.ldnovaes.programacao.dinamica.ebac;

/**
 *
 * @author ldnovaes
 */
public class FibonacciTopDown {
    
    private static int[] arrayAuxiliarFibonnaci;

    public static void main(String[] args) {
        int fibonacci = topDown(10);
        System.out.println(fibonacci);
    }
    
    public static int topDown(int n) {
        
        arrayAuxiliarFibonnaci = new int[n + 1];
        
        for (int i = 0; i <= n; i++) {
            arrayAuxiliarFibonnaci[i] = -1; // inicializa as posições com -1
        }
        
        return fibonacciRecursivo(n);
    }
    
    public static int fibonacciRecursivo(int n) {
        
        if (n < 2) {
            return n;
        }
        
        if (arrayAuxiliarFibonnaci[n] == -1) {
            arrayAuxiliarFibonnaci[n] = fibonacciRecursivo(n - 1) + fibonacciRecursivo(n - 2);
        } 
        
        return arrayAuxiliarFibonnaci[n];
     
        
    }
}
