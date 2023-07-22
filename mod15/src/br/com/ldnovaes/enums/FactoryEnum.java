package br.com.ldnovaes.enums;

import br.com.ldnovaes.cor.Cor;
import br.com.ldnovaes.factory.AbstractFactory;
import br.com.ldnovaes.factory.CarFactory;
import br.com.ldnovaes.factory.CorFactory;

/**
 * @author ldnovaes
 */

public enum FactoryEnum implements InstanceEnum<AbstractFactory> {
    CAR(new CarFactory()),
    COR(new CorFactory());

    private final AbstractFactory factory;

    FactoryEnum(AbstractFactory factory) {
        this.factory = factory;
    }

    @Override
    public AbstractFactory getInstance() {
        return factory;
    }
}
