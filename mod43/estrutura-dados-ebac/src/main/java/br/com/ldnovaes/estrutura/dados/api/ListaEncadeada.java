package br.com.ldnovaes.estrutura.dados.api;

/**
 *
 * @author ldnovaes
 */
public class ListaEncadeada<T> {
    
    private No<T> inicio;
    private No<T> ultimo;
    private int tamanho = 0;
    
    public void push(T elemento) {
        No<T> celula = new No(elemento);
        
        if(this.tamanho == 0) {
            this.inicio = celula;
        } else {
            this.ultimo.setProximo(celula);
        }
        
        this.ultimo = celula;
        this.tamanho++;
    }
    
    public No<T> pop() {
        
        if(this.tamanho == 0) {
            throw new RuntimeException("Não há nada inserido na lista encadeada. Por isso é impossível remover itens");
        } 
        
        No<T> penultimo = this.inicio;
        No<T> ultimoNo;
        
        for(int i = 0; i < this.tamanho - 2; i++) {
            penultimo = penultimo.getProximo();
        }
        
        ultimoNo = penultimo.getProximo();
        this.ultimo = penultimo;
        this.ultimo.setProximo(null);
        this.tamanho--;
        return ultimoNo;
        
    }
    
    public void insert(int posicao, T elemento) {
        
        if (posicao<0) throw new RuntimeException("Posição não pode ser um argumento < 0");
        
        No<T> novoNo = new No<>(elemento);
        
        if (posicao >= this.tamanho) {
            this.push(elemento);
        } else if(posicao == 0) {
            No<T> posterior = this.inicio.getProximo();
            novoNo.setProximo(posterior);
            this.inicio = novoNo;
        } else {
            
            No<T> atual = this.inicio;
            No<T> anterior = this.inicio;
            No<T> posterior = atual.getProximo();
            
            for (int i = 0; i < posicao; i++) {
                anterior = atual;
                atual = atual.getProximo();
                posterior = atual.getProximo();
            }
            
            anterior.setProximo(novoNo);
            novoNo.setProximo(posterior);
        }
        

        
    }
    
    public void remove(int posicao) {
        
        if(posicao >= this.tamanho) {
            throw new RuntimeException("Posição inserida é maior que tamanho atual da lista. Não é possível remover elementos nessa posição");
        }
        
        if (posicao == 0) {
            this.inicio = this.inicio.getProximo();
            this.tamanho--;
        } else {
            No<T> atual = this.inicio;
            No<T> anterior = this.inicio;
            No<T> posterior = atual.getProximo();

            for (int i = 0; i < posicao; i++) {
                    anterior = atual;
                    atual = atual.getProximo();
                    posterior = atual.getProximo();
            }

            anterior.setProximo(posterior);
            this.tamanho--;
        }
    }
    
    public No<T> elementAt(int posicao) {
        
        if(posicao >= this.tamanho) {
            throw new RuntimeException("Posição inserida é maior que tamanho atual da lista. Não é possível buscar elementos nessa posição");
        }
        
        No<T> atual = this.inicio;

        
        for (int i = 0; i < posicao; i++) {
            atual = atual.getProximo();
        }
        
        return atual;
        
    }
    
    public int size() {
        return this.tamanho;
    }
    
    public void printList() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        
        builder.append("[");
        
        No<T> atual = this.inicio;
        
        for(int i = 0; i < this.tamanho -1; i++) {
            builder.append(atual.getElemento()).append(", ");
            atual = atual.getProximo();
        }
        builder.append(atual.getElemento());
        builder.append("]");
        return builder.toString();
    }
    
    
}
