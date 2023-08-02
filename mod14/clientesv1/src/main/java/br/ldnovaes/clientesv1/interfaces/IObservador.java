package br.ldnovaes.clientesv1.interfaces;

/**
 * @author ldnovaes
 */

public interface IObservador<T, U extends Enum<U>> {
    void update(T observer, U acao);
}
