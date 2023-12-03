package br.com.ldnovaes.backtracking;

/**
 *
 * @author ldnovaes
 */
public class NRainha {
    /* Nenhuma rainha pode se atacar
        0 1 0 0
        0 0 0 1 
        1 0 0 0
        0 0 1 0
    */
    
    private int[][] tabuleiro;
    private int numeroRainhas;
    
    public NRainha(int [][] tabuleiro) {
        this.tabuleiro = tabuleiro;
        this.numeroRainhas = tabuleiro.length;
    }
    
    public boolean resolveNRainha() {
        if (this.numeroRainhas == 0) {
            return true;
        }
        
        // verifica se tem ataque nas colunas e linha
        for(int i = 0; i < this.tabuleiro.length; i++) {
            for (int j = 0; j < this.tabuleiro.length; j++) {
                
                if(this.temAtaque(i, j)) {
                    continue;
                }
                
                this.tabuleiro[i][j] = 1;
                this.numeroRainhas--;
                
                if(this.resolveNRainha()) {
                    return true;
                }
                
                this.tabuleiro[i][j] = 0;
                this.numeroRainhas++;
            }
        }
        
        return false;
    }

    private boolean temAtaque(int x, int y) {
        
        //verifica eixo x
        for(int i = 0; i < this.tabuleiro.length; i++) {
            if(this.tabuleiro[i][y] == 1) {
                return true;
            }
        }
        
        //verifica eixo y
        for(int j = 0; j < this.tabuleiro.length; j++) {
            if(this.tabuleiro[x][j] == 1) {
                return true;
            }
        }
        
        // checar diagonal
        for(int i = 0; i < this.tabuleiro.length; i++) {
            for(int j = 0; j < this.tabuleiro.length; j++) {
                int indEsq = i + j;
                int indDir = i - j;
                
                if (indDir == (x - y)) {
                    if (this.tabuleiro[i][j] == 1) {
                        return true;
                    }
                }    
                
                if(indEsq == (x + y)) {
                    if (this.tabuleiro[i][j] == 1) {
                        return true;
                    }
                }
            }
        }
        
        return false;
    }
    
    public void imprimeTabuleiro() {
        for(int i = 0; i < this.tabuleiro.length; i++) {
            for(int j = 0; j < this.tabuleiro.length; j++) {
                System.out.print(this.tabuleiro[i][j] + " ");
            }
            System.out.println();
        }
    }
}
