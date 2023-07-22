package br.com.ldnovaes;

import br.com.ldnovaes.enums.FactoryEnum;
import br.com.ldnovaes.factory.AbstractFactory;
import br.com.ldnovaes.factory.CarFactory;
import br.com.ldnovaes.factory.CorFactory;

/**
 * @author ldnovaes
 */
public class FabricProvider {
    public static AbstractFactory getFactory(FactoryEnum factory) {
        return factory.getInstance();
    }
}
