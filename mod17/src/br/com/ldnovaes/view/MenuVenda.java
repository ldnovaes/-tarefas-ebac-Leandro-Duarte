package br.com.ldnovaes.view;

import java.util.List;

/**
 * @author ldnovaes
 */

public class MenuVenda implements Menu{

    private List<String> enumMenu;

    public MenuVenda(List<String> enumMenu) {
        this.enumMenu = enumMenu;
    }
    @Override
    public void exibeMenu() {
        for (String item: this.enumMenu) {
            System.out.println(item);
        }
    }
}
