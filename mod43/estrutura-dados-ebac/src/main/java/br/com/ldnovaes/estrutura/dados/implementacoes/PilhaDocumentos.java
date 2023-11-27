package br.com.ldnovaes.estrutura.dados.implementacoes;

import br.com.ldnovaes.estrutura.dados.api.Pilha;
import br.com.ldnovaes.estrutura.dados.models.Documento;

/**
 *
 * @author ldnovaes
 */
public class PilhaDocumentos implements Pilha<Documento> {
    
    private Documento[] documentos;
    private static int tamanhoMaximo;
    private int ponteiro;
    
    public PilhaDocumentos(int capacidadePilha) {
        this.documentos = new Documento[capacidadePilha];
        tamanhoMaximo = capacidadePilha;
        this.ponteiro = -1;
    }

    /**
     *
     * @param item
     * @return 
     */
    @Override
    public Documento push(Documento item) {
        if (this.ponteiro < tamanhoMaximo) {
            this.ponteiro++;
            this.documentos[this.ponteiro] = item;
            return this.documentos[this.ponteiro];
        }
        throw new RuntimeException("Esta pilha já atingiu seu limite e não é possível adicionar mais itens à ela");
    }

    @Override
    public Documento pop() {
        
        if (this.ponteiro < 0) {
            throw new RuntimeException("A pilha está vazia, não é possível remover nenhum elemento.");
        }
        
        Documento documentoRemovido = this.documentos[this.ponteiro];
        this.documentos[this.ponteiro] = null;
        ponteiro--;
        return documentoRemovido;

        
    }

    @Override
    public boolean isEmpty() {
        if (this.ponteiro < 0) { return true; } return false;        
        
    }

    @Override
    public int size() {
        if (this.ponteiro == -1) { return 0; }
        return this.ponteiro;
    }

    @Override
    public Documento top() {    
        if (this.isEmpty()) {
            throw new RuntimeException("A pilha está vazia e não possui nenhum elemento");
        }
        return this.documentos[this.ponteiro];
    }    
    
}
