package br.com.ldnovaes.programacao.dinamica.ebac;

/**
 *
 * @author ldnovaes
 */
public class FatorialBottomUp {
    
     private static int[] arrayAuxiliar;
    
    public static void main(String[] args) {
        System.out.println(getFatorial(10));
    }
    
    public static int getFatorial(int n) {
        arrayAuxiliar = new int[n];
        int fatorialAtual = n;
        arrayAuxiliar[0] = 1;
        
        for(int i = 1; i < n; i++) {
            arrayAuxiliar[i] = arrayAuxiliar[i - 1] * fatorialAtual;
            fatorialAtual--;
        }
        
        return arrayAuxiliar[n-1];
    }
}
