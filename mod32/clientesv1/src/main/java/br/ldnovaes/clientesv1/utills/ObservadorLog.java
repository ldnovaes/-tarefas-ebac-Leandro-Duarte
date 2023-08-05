package br.ldnovaes.clientesv1.utills;

import br.ldnovaes.clientesv1.enums.LogEnum;
import br.ldnovaes.clientesv1.interfaces.IObservador;

/**
 * @author ldnovaes
 */

public class ObservadorLog implements IObservador<IObservador, LogEnum>{

    @Override
    public void update(IObservador observer, LogEnum log) {
        switch (log) {
            case VOLTAR:
                System.out.println(LogEnum.VOLTAR.getLog());
                break;
            case MAIN:
                System.out.println(LogEnum.MAIN.getLog());
                break;
            case CADASTRO:
                System.out.println(LogEnum.CADASTRO.getLog());
                break;
            case BUSCAR:
                System.out.println(LogEnum.BUSCAR.getLog());
                break;
        }
    }
}
