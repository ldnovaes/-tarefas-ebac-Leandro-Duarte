package br.com.ldnovaes.controller;

/**
 * @author ldnovaes
 */

public interface ControllerMenu<T, U> {

    public T escolheOpcao();
    public U inputDado();
}
