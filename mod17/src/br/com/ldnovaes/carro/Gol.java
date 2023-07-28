package br.com.ldnovaes.carro;

/**
 * @author ldnovaes
 */

public class Gol implements Carro {
    @Override
    public String getCarro() {
        return "Gol";
    }

    @Override
    public String toString() {
        return this.getCarro();
    }
}
