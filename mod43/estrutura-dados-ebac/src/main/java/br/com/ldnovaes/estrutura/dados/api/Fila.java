package br.com.ldnovaes.estrutura.dados.api;

/**
 *
 * @author ldnovaes
 */
public class Fila<T> {
    
    private int ultimo;
    private T[] itens;
    
    public Fila(int capacidade) {
        this.itens = (T[]) new Object[capacidade];
        this.ultimo = -1;
    }
    
    public void enqueue(T item) {
        this.ultimo++;
        this.itens[this.ultimo] = item;
    }
    
    public T dequeue() {
        
        if (this.isEmpty()) {
            throw new RuntimeException("A fila está vazia. Não é possível remover o item");
        }
        
        this.ultimo--;
        
        T primeiroDaFila = this.itens[0];
        
        for(int i = 0; i<= this.ultimo; i++){
            this.itens[i] = this.itens[i+1];
        }
        
        return primeiroDaFila;
    }
    
    public T rear() {
        return this.itens[this.ultimo];
    }
    
    public T front() {
        return this.itens[0];
    }
    
    public int size() {
        return this.ultimo;
    }
    
    public boolean isEmpty() {
        return this.ultimo < 0;
    }
    
}
