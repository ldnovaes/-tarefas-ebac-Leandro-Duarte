package br.com.ldnovaes.fabrica;

/**
 * @author ldnovaes
 */

public interface Fabrica<T> {

    T criar(String tipoCarro);
}
