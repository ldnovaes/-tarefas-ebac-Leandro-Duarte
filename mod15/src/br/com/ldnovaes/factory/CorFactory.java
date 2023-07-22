package br.com.ldnovaes.factory;

import br.com.ldnovaes.cor.Branco;
import br.com.ldnovaes.cor.Cor;
import br.com.ldnovaes.cor.Prata;
import br.com.ldnovaes.cor.Preto;
import br.com.ldnovaes.enums.CorEnum;
import br.com.ldnovaes.factory.AbstractFactory;

/**
 * @author ldnovaes
 */

public class CorFactory implements AbstractFactory<Cor, CorEnum> {

    @Override
    public Cor criar(CorEnum cor) {
        return cor.getInstance();
    }
}
