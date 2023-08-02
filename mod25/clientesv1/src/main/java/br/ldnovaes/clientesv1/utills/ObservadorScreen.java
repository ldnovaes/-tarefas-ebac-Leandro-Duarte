package br.ldnovaes.clientesv1.utills;

import br.ldnovaes.clientesv1.enums.ScreenChangeEnum;
import br.ldnovaes.clientesv1.interfaces.IObservador;

/**
 * @author ldnovaes
 */

// observa a screen, futuras implementações
public class ObservadorScreen implements IObservador<IObservador, ScreenChangeEnum> {

    @Override
    public void update(IObservador observer, ScreenChangeEnum acao) {
        switch (acao) {
            case MAIN:
                break;
            case DETAIL:
                break;
            case CADASTRO:
                break;
        }
    }

}
