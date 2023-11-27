package br.com.ldnovaes.estrutura.dados.api;

import java.util.List;

/**
 *
 * @author ldnovaes
 */
public class TabelaHash<K, V> {

    private ListaEncadeadaHash<K, V>[] values = new ListaEncadeadaHash[15];
    private int tamanho = 0;
    
    public TabelaHash() {
    }
    
    public void put(K key, V value) {
        
        int index = hash(key);  

        if(this.values[index] != null && this.values[index].getKeysColision().contains(key)) {
            throw new RuntimeException("Chave já foi inserida anteriormente");
        }
        
        if (this.values[index] != null) {
            ListaEncadeadaHash<K, V> noPosicao = this.values[index];
            noPosicao.push(key, value);
            this.tamanho++;
        } 
        else if(this.values[index] == null) {
            ListaEncadeadaHash<K, V> novoNo = new ListaEncadeadaHash();
            novoNo.push(key, value);
            this.values[index] = novoNo;
            this.tamanho++;
        }
    }
    
    private int hash(K key) {
        int hash = key.hashCode() % this.values.length;
        
        if (hash < 0) {
            hash += this.values.length;
        }
        return hash;
    }
    
    public int size() {
        return this.tamanho;
    }
    
    public List<K> getKeysColision(K key) {
        int index = hash(key);
        return this.values[index].getKeysColision();
    }
    
    public V get(K key) {
        int index = hash(key);
        
        try {
            NoHash<K, V> no = this.values[index].get(key);
            
            if (no != null) {
                return no.getElemento();
            }
            
        } catch (NullPointerException e) {
            throw new RuntimeException("Não é possivel obter " + key + ". Essa chave não foi inserida");
        } 

        throw new RuntimeException("Não é possivel obter " + key + ". Essa chave não foi inserida");

    }
    
        
    public void clear() {
        this.values = new ListaEncadeadaHash[15];
        this.tamanho = 0;
    }
    
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        boolean isFirstNonNull = true;

        for (ListaEncadeadaHash<K, V> value : this.values) {
            if (value != null) {
                if (!isFirstNonNull) {
                    builder.append(", ");
                } else {
                    isFirstNonNull = false;
                }
                builder.append(value);
            }
        }
        
        builder.append("]");
        return builder.toString();
    }

    
}
