package br.ldnovaes.clientesv1.interfaces;

/**
 * @author ldnovaes
 */

public interface ISubject {
    public void registerObserver(IObservador observer);
    public void unregisterObserver(IObservador observer);
    public void notifyObservers();
}
