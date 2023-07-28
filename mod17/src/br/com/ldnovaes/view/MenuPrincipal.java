package br.com.ldnovaes.view;

import java.util.List;

/**
 * @author ldnovaes
 */

public class MenuPrincipal<U extends Enum<U>> implements Menu{
    private List<String> enumMenu;

    public MenuPrincipal(List<String> enumMenu) {
        this.enumMenu = enumMenu;
    }

    @Override
    public void exibeMenu() {
        for (String item : this.enumMenu) {
            System.out.println(item);
        }
    }
}
