package br.com.ldnovaes.estrutura.dados.api;

public class NoHash<K, V> {
    
    private K key;
    private V elemento;
    private NoHash<K, V> proximo;
    
    public NoHash(K key, V elemento) {
        this.key = key;
        this.elemento = elemento;
        this.proximo = null;
    }
    
    public NoHash(K key, V elemento, NoHash<K, V> proximo) {
        this.key = key;
        this.elemento = elemento;
        this.proximo = proximo;
    }   

    public V getElemento() {
        return elemento;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public void setElemento(V elemento) {
        this.elemento = elemento;
    }

    public NoHash<K, V> getProximo() {
        return proximo;
    }

    public void setProximo(NoHash<K, V> proximo) {
        this.proximo = proximo;
    }
    
    
}
