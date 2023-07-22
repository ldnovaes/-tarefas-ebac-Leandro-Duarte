package br.com.ldnovaes.factory;

import br.com.ldnovaes.enums.FactoryEnum;

/**
 * @author ldnovaes
 */

public interface AbstractFactory<T, U extends Enum<U>> {
    T criar(U tipo);
}
