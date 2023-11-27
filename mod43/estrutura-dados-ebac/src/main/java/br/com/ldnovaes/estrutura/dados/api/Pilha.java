/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package br.com.ldnovaes.estrutura.dados.api;

/**
 *
 * @author ldnovaes
 * @param <T>
 */
public interface Pilha<T> {
    
    public T push(T item);
    public T pop();
    public boolean isEmpty();
    public int size();
    public T top();
}
