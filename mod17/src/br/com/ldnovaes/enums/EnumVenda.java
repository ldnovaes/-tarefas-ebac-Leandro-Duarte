package br.com.ldnovaes.enums;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ldnovaes
 */

public enum EnumVenda implements EnumMenu{
    GOL("01 - GOL"),
    VOYAGE("02 - VOYAGE"),
    OPCAO("Escolha sua Opção abaixo:");

    private String descricao;

    EnumVenda(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public List<String> getListEnum() {
        List<String> listaMenu = new ArrayList<>();
        for (EnumVenda menu : EnumVenda.values()) {
            listaMenu.add(menu.descricao);
        }
        return listaMenu;
    }

    @Override
    public String getDescricao() {
        return descricao;
    }
}
