
package br.com.ldnovaes;

import br.com.ldnovaes.guloso.Backup;
import br.com.ldnovaes.backtracking.ExercicioBacktracking;
import br.com.ldnovaes.backtracking.NRainha;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author ldnovaes
 */
public class Main {

    public static void main(String[] args) {
        resolveSubconjuntos();
    }
    
    public static void resolveNRainhas() {
        
        int[][] tab = {
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0}
        };
        
        NRainha nRainha = new NRainha(tab);
        nRainha.resolveNRainha();

        nRainha.imprimeTabuleiro();
    }
    
    private static void resolveSubconjuntos() {
        List<Integer> conjunto = new ArrayList<>(Arrays.asList(1, 2, 3));
        
        ExercicioBacktracking eb = new ExercicioBacktracking(conjunto);
        eb.resolverSubconjunto(new ArrayList<>(), 2, 0);
        eb.imprimeSubConjunto();
    }
    
    private static void criarBackup() {
        Backup backup = new Backup();        
    }
}
