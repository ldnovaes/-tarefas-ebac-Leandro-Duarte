package br.com.ldnovaes.venda;

import br.com.ldnovaes.fabrica.Fabrica;
import br.com.ldnovaes.fabrica.FabricaCarro;

/**
 * @author ldnovaes
 */

public class Venda {
    public static Fabrica getFabrica(String fabrica) {
        switch (fabrica) {
            case "Carro":
                return new FabricaCarro();
            default:
                return null;
        }

    }
}
