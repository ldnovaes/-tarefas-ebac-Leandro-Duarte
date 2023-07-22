package br.com.ldnovaes.factory;

import br.com.ldnovaes.car.Car;
import br.com.ldnovaes.car.Civic;
import br.com.ldnovaes.car.Fusion;
import br.com.ldnovaes.car.Golf;
import br.com.ldnovaes.enums.CarEnum;

/**
 * @author ldnovaes
 */

public class CarFactory implements AbstractFactory<Car, CarEnum> {
    @Override
    public Car criar(CarEnum car) {
        return car.getInstance();
    }
}
