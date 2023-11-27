package br.com.ldnovaes.estrutura.dados.api;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;



/**
 *
 * @author ldnovaes
 */
public class ListaEncadeadaHash<K, V> {
    
    private NoHash<K, V> inicio;
    private NoHash<K, V> ultimo;
    private int tamanho = 0;
    private Class<K> classK;

    public void push(K key, V elemento) {
        
        this.classK = (Class<K>) key.getClass();
        
        NoHash<K, V> celula = new NoHash(key, elemento);
        
        if(this.tamanho == 0) {
            this.inicio = celula;
        } else {
            this.ultimo.setProximo(celula);
        }
        
        this.ultimo = celula;
        this.tamanho++;
    }
    
    public NoHash<K, V> pop() {
        
        if(this.tamanho == 0) {
            throw new RuntimeException("Não há nada inserido na lista encadeada. Por isso é impossível remover itens");
        } 
        
        NoHash<K, V> penultimo = this.inicio;
        NoHash<K, V> ultimoNo;
        
        for(int i = 0; i < this.tamanho - 2; i++) {
            penultimo = penultimo.getProximo();
        }
        
        ultimoNo = penultimo.getProximo();
        this.ultimo = penultimo;
        this.ultimo.setProximo(null);
        this.tamanho--;
        return ultimoNo;
        
    }
    
    public void insert(int posicao, K key, V elemento) {
        
        if (posicao<0) throw new RuntimeException("Posição não pode ser um argumento < 0");
        
        NoHash<K, V> novoNo = new NoHash(key, elemento);
        
        if (posicao >= this.tamanho) {
            this.push(key, elemento);
        } else if(posicao == 0) {
            NoHash<K, V> posterior = this.inicio.getProximo();
            novoNo.setProximo(posterior);
            this.inicio = novoNo;
        } else {
            
            NoHash<K, V> atual = this.inicio;
            NoHash<K, V> anterior = this.inicio;
            NoHash<K, V> posterior = atual.getProximo();
            
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
            NoHash<K, V> atual = this.inicio;
            NoHash<K, V> anterior = this.inicio;
            NoHash<K, V> posterior = atual.getProximo();

            for (int i = 0; i < posicao; i++) {
                    anterior = atual;
                    atual = atual.getProximo();
                    posterior = atual.getProximo();
            }

            anterior.setProximo(posterior);
            this.tamanho--;
        }
    }
    
    public NoHash<K, V> elementAt(int posicao) {
        
        if(posicao >= this.tamanho) {
            throw new RuntimeException("Posição inserida é maior que tamanho atual da lista. Não é possível buscar elementos nessa posição");
        }
        
        NoHash<K, V> atual = this.inicio;

        
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
    
    public NoHash<K, V> get(K key) {
        
        NoHash<K, V> atual = this.inicio;

        for (int i = 0; i < this.tamanho; i++) {
            if(atual.getKey().equals(key)) {
                return atual;
            }
            atual = atual.getProximo();
        }
        
        return null;
    }
    
    @SuppressWarnings("unchecked")
    public List<K> getKeysColision() {
        
        if(this.tamanho <= 0) {
            throw new RuntimeException("Nenhuma key foi adicionada.");
        }
        
        K[] keys = (K[]) Array.newInstance(this.classK, this.tamanho);
        NoHash<K, V> atual = this.inicio;
        
        for(int i = 0; i < this.tamanho; i++) {
            keys[i] = atual.getKey();
            atual = atual.getProximo();
        }
        
        return Arrays.asList(keys);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        
        builder.append("[");
        
        NoHash<K, V> atual = this.inicio;
        
        for(int i = 0; i < this.tamanho -1; i++) {
            builder.append(atual.getElemento()).append(", ");
            atual = atual.getProximo();
        }
        builder.append(atual.getElemento());
        builder.append("]");
        return builder.toString();
    }

}
