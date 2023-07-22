package br.com.ldnovaes.enums;

import br.com.ldnovaes.cor.Branco;
import br.com.ldnovaes.cor.Cor;
import br.com.ldnovaes.cor.Preto;

/**
 * @author ldnovaes
 */

public enum CorEnum implements InstanceEnum<Cor>{
    PRATA(new Branco()),
    PRETO(new Preto()),
    BRANCO(new Branco());

    private Cor cor;

    CorEnum(Cor cor) {
        this.cor = cor;
    }

    @Override
    public Cor getInstance() {
        return cor;
    }
}
