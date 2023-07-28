package br.com.ldnovaes.enums;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ldnovaes
 */

public enum EnumMenuPrincipal implements EnumMenu {
    VENDER_CARRO("01 - Vender Carro"),
    OPCAO("Escolha sua Opção abaixo:");

    private String descricao;

    EnumMenuPrincipal(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public List<String> getListEnum() {
        List<String> listaMenu = new ArrayList<>();
        for (EnumMenuPrincipal menu : EnumMenuPrincipal.values()) {
            listaMenu.add(menu.descricao);
        }
        return listaMenu;
    }
    
    @Override
    public String getDescricao() {
        return descricao;
    }
}
