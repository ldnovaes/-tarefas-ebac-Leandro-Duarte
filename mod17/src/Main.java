import br.com.ldnovaes.carro.Carro;
import br.com.ldnovaes.carro.Gol;
import br.com.ldnovaes.carro.Voyage;
import br.com.ldnovaes.controller.ControllerMenu;
import br.com.ldnovaes.controller.ControllerMenuPrincipal;
import br.com.ldnovaes.controller.ControllerMenuVenda;
import br.com.ldnovaes.enums.EnumMenuPrincipal;
import br.com.ldnovaes.enums.EnumVenda;
import br.com.ldnovaes.venda.Venda;
import br.com.ldnovaes.view.MenuPrincipal;
import br.com.ldnovaes.view.MenuVenda;

import java.util.Scanner;

/**
 * @author ldnovaes
 */

public class Main {
    public static void main(String[] args) {
//        Carro carroGol = (Carro) Venda.getFabrica("br/com/ldnovaes/carro").criar("carro.Gol");
//        System.out.println(carroGol);

        String opcao;
        Scanner scanner = new Scanner(System.in);
        String carro;

        ControllerMenu menuPrincipal = new ControllerMenuPrincipal(scanner, new MenuPrincipal(EnumMenuPrincipal.OPCAO.getListEnum()));
        opcao = (String) menuPrincipal.escolheOpcao();

        switch (opcao) {
            case "01":
            case "1":
                ControllerMenu menuVenda = new ControllerMenuVenda(scanner, new MenuVenda(EnumVenda.OPCAO.getListEnum()));
                opcao = (String) menuVenda.escolheOpcao();
        }

        if (opcao.equals("1" ) || opcao.equals("01")) {
            Carro gol = (Carro) Venda.getFabrica("Carro").criar("Gol");
            carro = gol.getCarro();
        } else {
            Carro voyage = (Carro) Venda.getFabrica("Carro").criar("Voyage");
            carro = voyage.getCarro();

        }

        System.out.println("Você vendeu um " + carro);
    }
}
