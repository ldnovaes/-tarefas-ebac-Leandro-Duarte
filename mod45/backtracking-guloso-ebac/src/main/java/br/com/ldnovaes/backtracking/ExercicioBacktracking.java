package br.com.ldnovaes.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ldnovaes
 */
public class ExercicioBacktracking {
    
    List<Integer> input;
    List<List<Integer>> conjuntos;
    
    public ExercicioBacktracking(List<Integer> input) {
        this.input = input;
        this.conjuntos = new ArrayList<>();
    }
    
    public boolean resolverSubconjunto(List<Integer> tempSet, int nElementos, int start) {
        
        if(tempSet.size() == nElementos ){
            this.conjuntos.add(new ArrayList<>(tempSet));
            return false;
        }
        
        for(int i = start; i < this.input.size(); i++) {

            tempSet.add(this.input.get(i));
            
            resolverSubconjunto(tempSet, nElementos, i + 1);
            
            tempSet.remove(this.input.get(i));

        }
        
        return false;
        
    }

    public void imprimeSubConjunto() {
        System.out.println(this.conjuntos);
    }
    
}
