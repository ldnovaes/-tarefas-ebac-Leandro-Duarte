package br.com.ldnovaes.programacao.dinamica.ebac;

/**
 *
 * @author ldnovaes
 */
public class FatorialTopDown {
    
    private static int[] arrayAuxiliar;
    
    public static void main(String[] args) {
        System.out.println(topDown(7));
    }
    
    public static int topDown(int n) {
        arrayAuxiliar = new int[n + 1];
        
        arrayAuxiliar[0] = 1;
        arrayAuxiliar[1] = 1;
        
        for(int i = 2; i <= n; i++) {
            arrayAuxiliar[i] = -1;
        }
        
        return getFatorial(n);
    }
    
    public static int getFatorial(int n) {

        int resultado = n * arrayAuxiliar[n - 1];
        
        if (arrayAuxiliar[n] == -1) {
            arrayAuxiliar[n] = n * getFatorial(n - 1);
        }
        
        return arrayAuxiliar[n];
    }
    
}
