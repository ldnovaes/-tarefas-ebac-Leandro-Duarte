package br.com.ldnovaes.fabrica;

import br.com.ldnovaes.carro.Carro;
import br.com.ldnovaes.carro.Gol;
import br.com.ldnovaes.carro.Voyage;

/**
 * @author ldnovaes
 */

public class FabricaCarro implements Fabrica<Carro>{

    @Override
    public Carro criar(String tipoCarro) {
        switch (tipoCarro) {
            case "Gol":
                return new Gol();
            case "Voyage":
                return new Voyage();
            default:
                return null;
        }
    }
}
