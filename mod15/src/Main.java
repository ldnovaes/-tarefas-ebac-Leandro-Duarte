import br.com.ldnovaes.FabricProvider;
import br.com.ldnovaes.car.Car;
import br.com.ldnovaes.cor.Cor;
import br.com.ldnovaes.enums.CarEnum;
import br.com.ldnovaes.enums.CorEnum;
import br.com.ldnovaes.enums.FactoryEnum;
import br.com.ldnovaes.factory.AbstractFactory;

/**
 * @author ldnovaes
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(CarEnum.CIVIC.getInstance());


        Car car = (Car) FabricProvider.getFactory(FactoryEnum.CAR).criar(CarEnum.CIVIC);
        Cor cor = (Cor) FabricProvider.getFactory(FactoryEnum.COR).criar(CorEnum.BRANCO);

        System.out.println("O carro é o " + car.getCar() + " e a cor dele é " + cor.getCor());
    }
}