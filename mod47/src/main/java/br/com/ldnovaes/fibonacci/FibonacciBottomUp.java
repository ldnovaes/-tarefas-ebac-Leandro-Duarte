package br.com.ldnovaes.fibonacci;

/**
 *
 * @author ldnovaes
 */
public class FibonacciBottomUp {
    
    private int[] arrayAuxiliar;
    
    public int getFibonacci(int n) {
        
        arrayAuxiliar = new int[n];
        
        arrayAuxiliar[0] = 1;
        arrayAuxiliar[1] = 1;
        
        for (int i = 2; i < n; i++) {
            arrayAuxiliar[i] = arrayAuxiliar[i - 1] + arrayAuxiliar[i - 2];
        }
        
        return arrayAuxiliar[n-1];
    }
    
}
