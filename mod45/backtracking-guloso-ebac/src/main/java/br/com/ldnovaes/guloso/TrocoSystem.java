package br.com.ldnovaes.guloso;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author ldnovaes
 */
public class TrocoSystem {
    
    // menor numero de moedas
    // moedas de 5, 2 e 1
    // entrada de 18 e saída 5
    
    public static class Troco {
        
        public int[] getMoedas() {
            return new int[] {
                5, 2, 1
            };
        }
        
        public int quantiaTroco() {
            return 18;
        }
        
    }
    
    public int getMenorQuantidadeDeMoeda(Troco troco) {
        
        Map<Integer, Integer> moedasMap = new HashMap<>();
        moedasMap.put(5, 0);
        moedasMap.put(2, 0);
        moedasMap.put(1, 0);
        
        int[] moedas = troco.getMoedas();
        int quantiaTroco = troco.quantiaTroco();
        int quantidadeMoedas = 0;
        int i = 0;
        
        while(quantiaTroco > 0) {
            if(quantiaTroco - moedas[i] >= 0) {
                quantiaTroco -= moedas[i];
                quantidadeMoedas++;
                int moedaAtual = moedasMap.get(moedas[i]); 
                moedaAtual++;
                moedasMap.put(moedas[i], moedaAtual);
            } else {
                i++;
            } 
        }
        
        System.out.println(moedasMap);
        return quantidadeMoedas;
    }
    
    public static void main(String[] args) {
        TrocoSystem trocoSystem = new TrocoSystem();
        
        Troco troco = new Troco();
        
        System.out.println(trocoSystem.getMenorQuantidadeDeMoeda(troco));
    }
}
