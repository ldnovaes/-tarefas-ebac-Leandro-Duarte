package br.com.ldnovaes.enums;

import br.com.ldnovaes.car.Car;
import br.com.ldnovaes.car.Civic;
import br.com.ldnovaes.car.Fusion;
import br.com.ldnovaes.car.Golf;

/**
 * @author ldnovaes
 */

public enum CarEnum implements InstanceEnum<Car>{
    CIVIC(new Civic()),
    FUSION(new Fusion()),
    GOLF(new Golf());

    private Car car;

    CarEnum(Car car) {
        this.car = car;
    }

    @Override
    public Car getInstance() {
        return car;
    }
}
